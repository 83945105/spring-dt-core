package com.dt.core.engine;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/28.
 */
public interface SqlEngine<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    default String getTableName() {
        return "";
    }

    default String getTableAlias() {
        return "";
    }

    default String getPrimaryKeyName() {
        return "";
    }

    default String getPrimaryKeyAlias() {
        return "";
    }

    default String getColumnSql() {
        return "";
    }

    default String getJoinSql() {
        return "";
    }

    default String getWhereSql() {
        return "";
    }

    default String getGroupSql() {
        return "";
    }

    default String getSortSql() {
        return "";
    }

}
