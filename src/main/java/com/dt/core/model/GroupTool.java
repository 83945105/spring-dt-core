package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.GroupData;
import com.dt.core.data.TableData;
import com.dt.core.norm.Data;
import com.dt.core.norm.Group;
import com.dt.core.norm.Model;
import com.dt.core.parser.GroupParser;

import java.util.Collection;
import java.util.List;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class GroupTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends SortTool<M, ML, MO, MC, MS, MG> {

    private GroupParser groupParser = GroupParser.getInstance();

    public GroupTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public GroupTool<M, ML, MO, MC, MS, MG> group(String... columnNames) {
        if (columnNames == null || columnNames.length == 0) {
            return this;
        }
        TableData tableData = this.data.getMainTableData();
        tableData.addGroupColumns(columnNames);
        this.data.addGroupDataList(new GroupData(tableData, columnNames));
        return this;
    }

    public GroupTool<M, ML, MO, MC, MS, MG> group(Collection<String> columnNames) {
        if (columnNames == null || columnNames.size() == 0) {
            return this;
        }
        TableData tableData = this.data.getMainTableData();
        tableData.addGroupColumns(columnNames);
        this.data.addGroupDataList(new GroupData(tableData, columnNames.toArray(new String[columnNames.size()])));
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> GroupTool<M, ML, MO, MC, MS, MG> group(String alias, Class<T> columnClass, String... columnNames) {
        if (columnNames == null || columnNames.length == 0) {
            return this;
        }
        TableData tableData = this.data.getJoinTableData(alias, columnClass);
        tableData.addGroupColumns(columnNames);
        this.data.addGroupDataList(new GroupData(tableData, columnNames));
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> GroupTool<M, ML, MO, MC, MS, MG> group(String alias, Class<T> columnClass, Collection<String> columnNames) {
        if (columnNames == null || columnNames.size() == 0) {
            return this;
        }
        TableData tableData = this.data.getJoinTableData(alias, columnClass);
        tableData.addGroupColumns(columnNames);
        this.data.addGroupDataList(new GroupData(tableData, columnNames.toArray(new String[columnNames.size()])));
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> GroupTool<M, ML, MO, MC, MS, MG> group(Class<T> columnClass, String... columnNames) {
        return group(null, columnClass, columnNames);
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> GroupTool<M, ML, MO, MC, MS, MG> group(Class<T> columnClass, Collection<String> columnNames) {
        return group(null, columnClass, columnNames);
    }


    public GroupTool<M, ML, MO, MC, MS, MG> group(Group<M, ML, MO, MC, MS, MG> group) {
        List<String> columns = group.apply((MG) this.data.getMainTableData().getTable().getGroup()).getColumns();
        return group(columns);
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> GroupTool<M, ML, MO, MC, MS, MG> group(Class<T> groupClass, String alias, Group<T, TL, TO, TC, TS, TG> group) {
        List<String> columns = group.apply((TG) this.data.getJoinTableData(alias, groupClass).getTable().getGroup()).getColumns();
        return group(alias, groupClass, columns);
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> GroupTool<M, ML, MO, MC, MS, MG> group(Class<T> groupClass, Group<T, TL, TO, TC, TS, TG> group) {
        return group(groupClass, null, group);
    }

    @Override
    public String getGroupSql() {
        return this.groupParser.parse(this.getData().getGroupDataList());
    }

}
