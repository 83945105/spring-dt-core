package com.dt.core.model;

import com.dt.core.converter.ColumnFieldConverter;
import com.dt.core.converter.HumpConverter;
import com.dt.core.jdbc.JdbcSource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.net.ConnectException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by 白超 on 2018/7/3.
 */
public class ModelTemplateEngine extends JdbcSource {

    private String ip;

    private String port;

    private String dataBaseName;

    public static ModelTemplateEngine newMySqlEngine(String ip, String port, String dataBaseName, String username, String password) {
        ModelTemplateEngine engine = new ModelTemplateEngine("com.mysql.jdbc.Driver",
                "jdbc:mysql://" + ip + ":" + port + "/" + dataBaseName + "?useSSL=false",
                username, password);
        engine.ip = ip;
        engine.port = port;
        engine.dataBaseName = dataBaseName;
        return engine;
    }

    private ModelTemplateEngine(String driverClassName, String url, String username, String password) {
        super(driverClassName, url, username, password);
    }

    private void link() {
        if (this.connection == null) {
            if (this.getConnection()) {
                return;
            }
            throw new RuntimeException("can not connect to " + this.url);
        }
    }

    public List<String> getTableNames() throws SQLException {
        this.link();
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + this.dataBaseName + "'";
        this.executeQuery(sql);
        List<String> tableNames = new ArrayList<>();
        while (this.resultSet.next()) {
            tableNames.add(this.resultSet.getString(1));
        }
        return tableNames;
    }

    public Column getPrimaryKeyColumn(String tableName, ColumnFieldConverter columnFieldConverter) throws SQLException {
        link();
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name='" + tableName + "' AND COLUMN_KEY='PRI' LIMIT 1";
        this.executeQuery(sql);
        Column column = null;
        while (this.resultSet.next()) {
            column = new Column();
            column.setName(this.resultSet.getString(1));
            column.setAlias(columnFieldConverter.columnToField(column.getName()));
            break;
        }
        sql = "SHOW FULL COLUMNS FROM " + tableName;
        this.executeQuery(sql);
        while (this.resultSet.next()) {
            if (!this.resultSet.getString("Field").equals(column.getName())) {
                continue;
            }
            column.setTypeString(this.resultSet.getString("Type"));
            column.setCollation(this.resultSet.getString("Collation"));
            column.setNullString(this.resultSet.getString("Null"));
            column.setKeyString(this.resultSet.getString("Key"));
            column.setDefaultString(this.resultSet.getString("Default"));
            column.setExtra(this.resultSet.getString("Extra"));
            column.setComment(this.resultSet.getString("Comment"));
        }
        return column;
    }

    public LinkedHashMap<String, String> getColumnAndField(String tableName, ColumnFieldConverter columnFieldConverter) throws SQLException {
        link();
        String sql = "SELECT * FROM " + tableName + " LIMIT 1";
        this.executeQuery(sql);
        LinkedHashMap<String, String> columnAndField = new LinkedHashMap<>();
        ResultSetMetaData resultSetMetaData = this.resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            String columnName = resultSetMetaData.getColumnName(i);
            columnAndField.put(columnName, columnFieldConverter.columnToField(columnName));
        }
        return columnAndField;
    }

    public LinkedHashMap<String, String> getFieldAndColumn(String tableName, ColumnFieldConverter columnFieldConverter) throws SQLException {
        link();
        String sql = "SELECT * FROM " + tableName + " LIMIT 1";
        this.executeQuery(sql);
        LinkedHashMap<String, String> fieldAndColumn = new LinkedHashMap<>();
        ResultSetMetaData resultSetMetaData = this.resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            String columnName = resultSetMetaData.getColumnName(i);
            fieldAndColumn.put(columnFieldConverter.columnToField(columnName), columnName);
        }
        return fieldAndColumn;
    }

    public Collection<Column> getColumns(String tableName, ColumnFieldConverter columnFieldConverter) throws SQLException {
        link();
        String sql = "SELECT * FROM " + tableName + " LIMIT 1";
        this.executeQuery(sql);
        Map<String, Column> columns = new LinkedHashMap<>();
        ResultSetMetaData resultSetMetaData = this.resultSet.getMetaData();
        Column column;
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            column = new Column();
            String columnName = resultSetMetaData.getColumnName(i);
            column.setName(columnName);
            column.setAlias(columnFieldConverter.columnToField(columnName));
            column.setCatalog(resultSetMetaData.getCatalogName(i));
            column.setLabel(resultSetMetaData.getColumnLabel(i));
            column.setCurrency(resultSetMetaData.isCurrency(i));
            column.setReadOnly(resultSetMetaData.isReadOnly(i));
            column.setAutoIncrement(resultSetMetaData.isAutoIncrement(i));
            column.setTypeInt(resultSetMetaData.getColumnType(i));
            columns.put(columnName, column);
        }
        sql = "SHOW FULL COLUMNS FROM " + tableName;
        this.executeQuery(sql);
        while (this.resultSet.next()) {
            column = columns.get(this.resultSet.getString("Field"));
            if (column == null) {
                continue;
            }
            column.setTypeString(this.resultSet.getString("Type"));
            column.setCollation(this.resultSet.getString("Collation"));
            column.setNullString(this.resultSet.getString("Null"));
            column.setKeyString(this.resultSet.getString("Key"));
            column.setDefaultString(this.resultSet.getString("Default"));
            column.setExtra(this.resultSet.getString("Extra"));
            column.setComment(this.resultSet.getString("Comment"));
        }
        return columns.values();
    }

    public boolean isTableExist(String tableName) throws SQLException {
        link();
        String sql = "SELECT COUNT(*) FROM information_schema.TABLES WHERE table_name = '" + tableName + "'";
        this.executeQuery(sql);
        return this.resultSet.next() ? this.resultSet.getInt(1) > 0 : false;
    }

    public boolean isColumnExist(String tableName, String columnName) throws SQLException {
        link();
        String sql = "SELECT COUNT(*) FROM information_schema.COLUMNS WHERE table_name = '" + tableName + "' AND column_name = '" + columnName + "'";
        this.executeQuery(sql, new Object[]{});
        return this.resultSet.next() ? this.resultSet.getInt(1) > 0 : false;
    }

    public static void main(String[] args) throws SQLException {

        ModelTemplateEngine engine = ModelTemplateEngine.newMySqlEngine("192.168.3.3",
                "3306", "cloud_demo", "root", "root");

        List<String> tableNames = engine.getTableNames();

        Map<String, String> cf = engine.getColumnAndField("jur_role", new HumpConverter());
        for (Map.Entry<String, String> entry : cf.entrySet()) {
            System.out.println("key:" + entry.getKey() + " - value:" + entry.getValue());
        }

        System.out.println(engine.isTableExist("jur_role"));
        System.out.println(engine.isTableExist("jur_role1"));
        System.out.println(engine.isColumnExist("jur_role", "id"));
        System.out.println(engine.isColumnExist("jur_role", "id2"));

        Collection<Column> columns = engine.getColumns("jur_role", new HumpConverter());

        Column primaryKeyColumn = engine.getPrimaryKeyColumn("jur_role", new HumpConverter());

        System.out.println("------------------");

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("templates/");
        resolver.setSuffix(".text");
        resolver.setCacheable(true);
        resolver.setTemplateMode(TemplateMode.TEXT);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        Context context = new Context();

        Map<String, Object> setting = new HashMap<>();
        setting.put("packagePath", "com.huanet.bean");
        setting.put("tableName", "jur_role");
        setting.put("tableAlias", "JurRole");
        setting.put("primaryKeyColumn", primaryKeyColumn);
        setting.put("templateSuffix", "Model");

        context.setVariable("setting", setting);
        context.setVariable("columns", columns);


        String str = templateEngine.process("model", context);
        System.out.println(str);


    }
}
