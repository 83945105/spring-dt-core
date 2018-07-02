package com.dt.core.norm;

import com.dt.core.bean.*;
import com.dt.core.norm.DataTool;
import com.dt.core.norm.Model;
import com.dt.core.parser.SelectColumnParser;

/**
 * Created by 白超 on 2018/6/28.
 */
public interface SqlTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    String getSelectColumnSql();

    String getJoinSql();

    String getWhereSql();

    String getGroupSql();

    String getSortSql();

}
