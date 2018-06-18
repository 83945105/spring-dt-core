package com.dt.core.bean;

import java.util.*;
import java.util.Map.Entry;

/**
 * 条件体
 */
public final class Criterion {

    private String tableName;

    private String columnName;

    private ColumnHandler columnHandler;

    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private List<Map<NoValueCondition, NoValueType>> noValueCriteria;

    public boolean isSingleNoValueCriteria() {
        return noValueCriteria == null || noValueCriteria.size() == 1;
    }

    public String noValueCriteria(String tableName, String fieldName) {
        if (noValueCriteria == null) return "";
        StringBuilder sb = new StringBuilder();
        for (Map<NoValueCondition, NoValueType> map : noValueCriteria) {
            for (Entry<NoValueCondition, NoValueType> entry : map.entrySet()) {
                switch (entry.getValue()) {
                    case NULL:
                        switch (entry.getKey()) {
                            case AND_EQUAL:
                                sb.append(" AND ").append(tableName).append(".").append(fieldName).append(" IS NULL");
                                break;
                            case AND_NOTEUQAL:
                                sb.append(" AND ").append(tableName).append(".").append(fieldName).append(" IS NOT NULL");
                                break;
                            case OR_EQUAL:
                                sb.append(" OR ").append(tableName).append(".").append(fieldName).append(" IS NULL");
                                break;
                            case OR_NOTEUQAL:
                                sb.append(" OR ").append(tableName).append(".").append(fieldName).append(" IS NOT NULL");
                                break;
                        }
                        break;
                    case EMPTY:
                        switch (entry.getKey()) {
                            case AND_EQUAL:
                                sb.append(" AND ").append(tableName).append(".").append(fieldName).append(" = ''");
                                break;
                            case AND_NOTEUQAL:
                                sb.append(" AND ").append(tableName).append(".").append(fieldName).append(" <> ''");
                                break;
                            case OR_EQUAL:
                                sb.append(" OR ").append(tableName).append(".").append(fieldName).append(" = ''");
                                break;
                            case OR_NOTEUQAL:
                                sb.append(" OR ").append(tableName).append(".").append(fieldName).append(" <> ''");
                                break;
                        }
                        break;
                }
            }
        }
        return sb.substring(5);
    }

    /**
     * 等于NULL
     */
    public final static List<Map<NoValueCondition, NoValueType>> EQUAL_NULL = new ArrayList<>();
    /**
     * 等于空
     */
    public final static List<Map<NoValueCondition, NoValueType>> EQUAL_EMPTY = new ArrayList<>();
    /**
     * 等于NULL且等于空
     */
    public final static List<Map<NoValueCondition, NoValueType>> EQUAL_NULL_AND_EQUAL_EMPTY = new ArrayList<>();
    /**
     * 等于NULL或等于空
     */
    public final static List<Map<NoValueCondition, NoValueType>> EQUAL_NULL_OR_EQUAL_EMPTY = new ArrayList<>();
    /**
     * 不等于NULL
     */
    public final static List<Map<NoValueCondition, NoValueType>> NOTEQUAL_NULL = new ArrayList<>();
    /**
     * 不等于空
     */
    public final static List<Map<NoValueCondition, NoValueType>> NOTEQUAL_EMPTY = new ArrayList<>();
    /**
     * 不等于NULL且不等于空
     */
    public final static List<Map<NoValueCondition, NoValueType>> NOTEQUAL_NULL_AND_NOTEQUAL_EMPTY = new ArrayList<>();
    /**
     * 不等于NULL或不等于空
     */
    public final static List<Map<NoValueCondition, NoValueType>> NOTEQUAL_NULL_OR_NOTEQUAL_EMPTY = new ArrayList<>();

    static {
        Map<NoValueCondition, NoValueType> AND_EQUAL_NULL = new HashMap<>();
        AND_EQUAL_NULL.put(NoValueCondition.AND_EQUAL, NoValueType.NULL);

        Map<NoValueCondition, NoValueType> AND_EQUAL_EMPTY = new HashMap<>();
        AND_EQUAL_EMPTY.put(NoValueCondition.AND_EQUAL, NoValueType.EMPTY);

        Map<NoValueCondition, NoValueType> OR_EQUAL_NULL = new HashMap<>();
        OR_EQUAL_NULL.put(NoValueCondition.OR_EQUAL, NoValueType.NULL);

        Map<NoValueCondition, NoValueType> OR_EQUAL_EMPTY = new HashMap<>();
        OR_EQUAL_EMPTY.put(NoValueCondition.OR_EQUAL, NoValueType.EMPTY);

        Map<NoValueCondition, NoValueType> AND_NOTEQUAL_NULL = new HashMap<>();
        AND_NOTEQUAL_NULL.put(NoValueCondition.AND_NOTEUQAL, NoValueType.NULL);

        Map<NoValueCondition, NoValueType> AND_NOTEQUAL_EMPTY = new HashMap<>();
        AND_NOTEQUAL_EMPTY.put(NoValueCondition.AND_NOTEUQAL, NoValueType.EMPTY);

        Map<NoValueCondition, NoValueType> OR_NOTEQUAL_NULL = new HashMap<>();
        OR_NOTEQUAL_NULL.put(NoValueCondition.OR_NOTEUQAL, NoValueType.NULL);

        Map<NoValueCondition, NoValueType> OR_NOTEQUAL_EMPTY = new HashMap<>();
        OR_NOTEQUAL_EMPTY.put(NoValueCondition.OR_NOTEUQAL, NoValueType.EMPTY);

        EQUAL_NULL.add(AND_EQUAL_NULL);

        EQUAL_EMPTY.add(AND_EQUAL_EMPTY);

        EQUAL_NULL_AND_EQUAL_EMPTY.add(AND_EQUAL_NULL);
        EQUAL_NULL_AND_EQUAL_EMPTY.add(AND_EQUAL_EMPTY);

        EQUAL_NULL_OR_EQUAL_EMPTY.add(AND_EQUAL_NULL);
        EQUAL_NULL_OR_EQUAL_EMPTY.add(OR_EQUAL_EMPTY);

        NOTEQUAL_NULL.add(AND_NOTEQUAL_NULL);

        NOTEQUAL_EMPTY.add(AND_NOTEQUAL_EMPTY);

        NOTEQUAL_NULL_AND_NOTEQUAL_EMPTY.add(AND_NOTEQUAL_NULL);
        NOTEQUAL_NULL_AND_NOTEQUAL_EMPTY.add(AND_NOTEQUAL_EMPTY);

        NOTEQUAL_NULL_OR_NOTEQUAL_EMPTY.add(AND_NOTEQUAL_NULL);
        NOTEQUAL_NULL_OR_NOTEQUAL_EMPTY.add(OR_NOTEQUAL_EMPTY);
    }

    private boolean singleValue;

    private boolean betweenValue;

    private boolean collectionValue;

    private boolean arrayValue;

    private boolean isTransient;

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnHandle() {
        return columnHandler == null ? " " : columnHandler.value;
    }

    public String getCondition() {
        return condition;
    }

    public Object getValue() {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Integer) {
            return value;
        } else if (value instanceof Enum) {
            return "'" + value.toString() + "'";
        } else if (value.getClass().isArray()) {
            return value;
        } else if (value instanceof Collection) {
            return value;
        }
        throw new RuntimeException("value 数据格式不正确,只能为String、Integer、Enum、Arrays、Collection类型,value:" + value);
    }

    public Object getSecondValue() {
        if (secondValue instanceof String) {
            return "'" + secondValue + "'";
        } else if (secondValue instanceof Integer) {
            return secondValue;
        } else if (secondValue instanceof Enum) {
            return "'" + secondValue.toString() + "'";
        } else if (secondValue.getClass().isArray()) {
            return secondValue;
        } else if (secondValue instanceof Collection) {
            return secondValue;
        }
        throw new RuntimeException("secondValue 数据格式不正确,只能为String、Integer、Enum、Arrays、Collection类型类型,secondValue:" + secondValue);
    }

    public Object getValues() {
        StringBuilder _sb = new StringBuilder(64);
        if (isArrayValue()) {
            Object[] values = (Object[]) getValue();
            for (Object value : values) {
                if (value instanceof String) {
                    _sb.append(",'").append(value.toString()).append("'");
                } else if (value instanceof Integer) {
                    _sb.append(",").append(value.toString());
                } else if (value instanceof Enum) {
                    _sb.append(",'").append(value.toString()).append("'");
                } else {
                    throw new RuntimeException("数组内元素value 数据格式不正确,只能为String、Integer、Enum类型,value:" + value);
                }
            }
        } else if (isCollectionValue()) {
            Collection<?> values = (Collection<?>) getValue();
            for (Object value : values) {
                if (value instanceof String) {
                    _sb.append(",'").append(value.toString()).append("'");
                } else if (value instanceof Integer) {
                    _sb.append(",").append(value.toString());
                } else if (value instanceof Enum) {
                    _sb.append(",'").append(value.toString()).append("'");
                } else {
                    throw new RuntimeException("数组内元素value 数据格式不正确,只能为String、Integer、Enum类型,value:" + value);
                }
            }
        } else {
            return "";
        }
        return _sb.substring(1);
    }

    public boolean isNoValue() {
        return noValue;
    }

    public boolean isSingleValue() {
        return singleValue;
    }

    public boolean isBetweenValue() {
        return betweenValue;
    }

    public boolean isCollectionValue() {
        return collectionValue;
    }

    public boolean isArrayValue() {
        return arrayValue;
    }

    public boolean isTransient() {
        return isTransient;
    }

    public Criterion(String tableName, String columnName, Boolean isTransient, List<Map<NoValueCondition, NoValueType>> noValueCriteria) {
        super();
        this.tableName = tableName;
        this.columnName = columnName;
        this.noValue = true;
        this.noValueCriteria = noValueCriteria;
        this.isTransient = isTransient;
    }

    public Criterion(String tableName, String columnName, ColumnHandler columnHandler, Boolean isTransient, List<Map<NoValueCondition, NoValueType>> noValueCriteria) {
        super();
        this.tableName = tableName;
        this.columnName = columnName;
        this.noValue = true;
        this.noValueCriteria = noValueCriteria;
        this.isTransient = isTransient;
        this.columnHandler = columnHandler;
    }

    public Criterion(String tableName, String columnName, String condition, Object value, Boolean isTransient) {
        super();
        this.tableName = tableName;
        this.columnName = columnName;
        this.condition = condition;
        this.value = value;
        if (value instanceof Collection) {
            this.collectionValue = true;
        } else if (value.getClass().isArray()) {
            this.arrayValue = true;
        } else {
            this.singleValue = true;
        }
        this.isTransient = isTransient;
    }

    public Criterion(String tableName, String columnName, ColumnHandler columnHandler, String condition, Object value, Boolean isTransient) {
        super();
        this.tableName = tableName;
        this.columnName = columnName;
        this.condition = condition;
        this.value = value;
        this.columnHandler = columnHandler;
        if (value instanceof Collection) {
            this.collectionValue = true;
        } else if (value.getClass().isArray()) {
            this.arrayValue = true;
        } else {
            this.singleValue = true;
        }
        this.isTransient = isTransient;
    }

    public Criterion(String tableName, String columnName, String condition, Object value, Object secondValue, Boolean isTransient) {
        super();
        this.tableName = tableName;
        this.columnName = columnName;
        this.condition = condition;
        this.value = value;
        this.secondValue = secondValue;
        this.betweenValue = true;
        this.isTransient = isTransient;
    }

    public Criterion(String tableName, String columnName, ColumnHandler columnHandler, String condition, Object value, Object secondValue, Boolean isTransient) {
        super();
        this.tableName = tableName;
        this.columnName = columnName;
        this.condition = condition;
        this.value = value;
        this.secondValue = secondValue;
        this.betweenValue = true;
        this.isTransient = isTransient;
        this.columnHandler = columnHandler;
    }

    public enum ColumnHandler {
        /**
         * 数据库字段值转为数值类型
         */
        TO_INT(" * 1 ");

        String value;

        ColumnHandler(String value) {
            this.value = value;
        }

    }

    public enum NoValueCondition {
        /**
         * 且相等
         */
        AND_EQUAL,
        /**
         * 且不相等
         */
        AND_NOTEUQAL,
        /**
         * 或相等
         */
        OR_EQUAL,
        /**
         * 或不相等
         */
        OR_NOTEUQAL

    }

    public enum NoValueType {
        /**
         * null表示无数据,默认
         */
        NULL,
        /**
         * 空字符串表示无数据
         */
        EMPTY

    }

}
