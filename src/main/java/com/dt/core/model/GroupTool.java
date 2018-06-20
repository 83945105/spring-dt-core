package com.dt.core.model;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.GroupModel;
import com.dt.core.bean.OnModel;
import com.dt.core.bean.SortModel;
import com.dt.core.norm.Data;
import com.dt.core.norm.Group;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class GroupTool<M extends Model<M, MO, MC, MS, MG>,
        MO extends OnModel<M, MO, MC, MS, MG>,
        MC extends ConditionModel<M, MO, MC, MS, MG>,
        MS extends SortModel<M, MO, MC, MS, MG>,
        MG extends GroupModel<M, MO, MC, MS, MG>> extends SortTool<M, MO, MC, MS, MG> {

    public GroupTool(Data<M, MO, MC, MS, MG> data) {
        super(data);
    }

    public GroupTool<M, MO, MC, MS, MG> group(Group<M, MO, MC, MS, MG> group) {

        return this;
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> GroupTool<M, MO, MC, MS, MG> group(Class<T> groupClass, Group<T, TO, TC, TS, TG> group) {
        return group(groupClass, null, group);
    }

    public <T extends Model<T, TO, TC, TS, TG>,
            TO extends OnModel<T, TO, TC, TS, TG>,
            TC extends ConditionModel<T, TO, TC, TS, TG>,
            TS extends SortModel<T, TO, TC, TS, TG>,
            TG extends GroupModel<T, TO, TC, TS, TG>> GroupTool<M, MO, MC, MS, MG> group(Class<T> groupClass, String alias, Group<T, TO, TC, TS, TG> group) {

        return this;
    }

}
