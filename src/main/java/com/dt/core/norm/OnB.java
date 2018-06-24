package com.dt.core.norm;

import com.dt.core.bean.*;

/**
 * Created by 白超 on 2018/6/24.
 */
@FunctionalInterface
public interface OnB<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    OnBuilder<M, ML, MO, MC, MS, MG> apply(MO table);

}
