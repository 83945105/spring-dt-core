package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.JoinTableData;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;
import com.dt.core.norm.OnA;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class JoinTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends WhereTool<M, ML, MO, MC, MS, MG> {

    public JoinTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> join(String tableName,
                                                                                               Class<J> joinClass,
                                                                                               String alias,
                                                                                               JoinType joinType,
                                                                                               OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        //TODO
        MainTableData<M, ML, MO, MC, MS, MG> mainTableData = this.data.getMainMainTableData();
        JoinTableData<J, JL, JO, JC, JS, JG> joinTableData = this.data.getJoinTableData(alias, joinClass);
        joinTableData.setTableName(tableName);
        joinTableData.setJoinType(joinType);
        OnLink<J, JL, JO, JC, JS, JG> onLink = new OnLink<>();
        JO jo = (JO) joinTableData.getTable().getOn();
        jo.setTargetTableData(mainTableData);
        on.apply(onLink, jo, (MO) mainTableData.getTable().getOn());
        return this;
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> join(String tableName,
                                                                                               Class<J> joinClass,
                                                                                               JoinType joinType,
                                                                                               OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, null, joinType, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> join(Class<J> joinClass,
                                                                                               String alias,
                                                                                               JoinType joinType,
                                                                                               OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, alias, joinType, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> join(Class<J> joinClass,
                                                                                               JoinType joinType,
                                                                                               OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, null, joinType, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> innerJoin(String tableName,
                                                                                                    Class<J> joinClass,
                                                                                                    String alias,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, alias, JoinType.INNER, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> innerJoin(String tableName,
                                                                                                    Class<J> joinClass,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, null, JoinType.INNER, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> innerJoin(Class<J> joinClass,
                                                                                                    String alias,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, alias, JoinType.INNER, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> innerJoin(Class<J> joinClass,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, null, JoinType.INNER, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> leftJoin(String tableName,
                                                                                                   Class<J> joinClass,
                                                                                                   String alias,
                                                                                                   OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, alias, JoinType.LEFT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> leftJoin(String tableName,
                                                                                                   Class<J> joinClass,
                                                                                                   OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, null, JoinType.LEFT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> leftJoin(Class<J> joinClass,
                                                                                                   String alias,
                                                                                                   OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, alias, JoinType.LEFT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> leftJoin(Class<J> joinClass,
                                                                                                   OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, null, JoinType.LEFT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> rightJoin(String tableName,
                                                                                                    Class<J> joinClass,
                                                                                                    String alias,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, alias, JoinType.RIGHT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> rightJoin(String tableName,
                                                                                                    Class<J> joinClass,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(tableName, joinClass, null, JoinType.RIGHT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> rightJoin(Class<J> joinClass,
                                                                                                    String alias,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, alias, JoinType.RIGHT, on);
    }

    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTool<M, ML, MO, MC, MS, MG> rightJoin(Class<J> joinClass,
                                                                                                    OnA<M, ML, MO, MC, MS, MG, J, JL, JO, JC, JS, JG> on) {
        return join(null, joinClass, null, JoinType.RIGHT, on);
    }

}
