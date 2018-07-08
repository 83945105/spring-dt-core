package com.dt.core.norm;

import com.dt.core.bean.*;

import java.util.Map;

/**
 * Created by 白超 on 2018/6/16.
 */
public interface Model<T extends Model<T, TL, TO, TC, TS, TG>,
        TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
        TO extends OnModel<T, TL, TO, TC, TS, TG>,
        TC extends WhereModel<T, TL, TO, TC, TS, TG>,
        TS extends SortModel<T, TL, TO, TC, TS, TG>,
        TG extends GroupModel<T, TL, TO, TC, TS, TG>> {

    String getTableName();

    String getTableAlias();

    String getPrimaryKeyName();

    String getPrimaryKeyAlias();

    Map<String, String> getColumnAliasMap();

    Map<String, String> getAliasColumnMap();

    ColumnModel<T, TL, TO, TC, TS, TG> getColumn();

    OnModel<T, TL, TO, TC, TS, TG> getOn();

    WhereModel<T, TL, TO, TC, TS, TG> getWhere();

    GroupModel<T, TL, TO, TC, TS, TG> getGroup();

    SortModel<T, TL, TO, TC, TS, TG> getSort();
}
