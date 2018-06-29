package com.dt.core.bean;

import com.dt.core.data.JoinTableData;
import com.dt.core.data.LinkWhereData;
import com.dt.core.norm.ConditionA;
import com.dt.core.norm.ConditionB;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件
 * Created by 白超 on 2018/6/7.
 */
public final class WhereLink<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    private Data data;

    public WhereLink(Data data) {
        this.data = data;
    }

    private List<LinkWhereData> linkWhereDataList = new ArrayList<>();

    public WhereLink<M, ML, MO, MC, MS, MG> and(WhereModel<?, ?, ?, ?, ?, ?> whereModel) {
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.AND);
        linkWhereData.setWhereDataList(whereModel.whereBuilder.getWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public WhereLink<M, ML, MO, MC, MS, MG> and(ConditionA<M, ML, MO, MC, MS, MG> condition) {
        MC mc = (MC) this.data.getMainTableData().getTable().getWhere();
        WhereLink whereLink = condition.apply(new WhereLink<>(this.data), mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.AND);
        linkWhereData.setLinkWhereDataList(whereLink.linkWhereDataList);
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLink<M, ML, MO, MC, MS, MG> and(Class<T> conditionClass,
                                                                                               String alias,
                                                                                               ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        JoinTableData joinTableData = this.data.getJoinTableData(alias, conditionClass);
        TC tc = (TC) joinTableData.getTable().getWhere();
        MC mc = (MC) this.data.getMainTableData().getTable().getWhere();
        WhereLink whereLink = condition.apply(new WhereLink<>(this.data), tc, mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.AND);
        linkWhereData.setLinkWhereDataList(whereLink.linkWhereDataList);
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLink<M, ML, MO, MC, MS, MG> and(Class<T> conditionClass, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        return and(conditionClass, null, condition);
    }

    public WhereLink<M, ML, MO, MC, MS, MG> or(WhereModel<?, ?, ?, ?, ?, ?> whereModel) {
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.OR);
        linkWhereData.setWhereDataList(whereModel.whereBuilder.getWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public WhereLink<M, ML, MO, MC, MS, MG> or(ConditionA<M, ML, MO, MC, MS, MG> condition) {
        MC mc = (MC) this.data.getMainTableData().getTable().getWhere();
        WhereLink whereLink = condition.apply(new WhereLink<>(this.data), mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.OR);
        linkWhereData.setLinkWhereDataList(whereLink.linkWhereDataList);
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLink<M, ML, MO, MC, MS, MG> or(Class<T> conditionClass, String alias, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        JoinTableData joinTableData = this.data.getJoinTableData(alias, conditionClass);
        TC tc = (TC) joinTableData.getTable().getWhere();
        MC mc = (MC) this.data.getMainTableData().getTable().getWhere();
        WhereLink whereLink = condition.apply(new WhereLink<>(this.data), tc, mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.OR);
        linkWhereData.setLinkWhereDataList(whereLink.linkWhereDataList);
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLink<M, ML, MO, MC, MS, MG> or(Class<T> conditionClass, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        return or(conditionClass, null, condition);
    }

    public List<LinkWhereData> getLinkWhereDataList() {
        return linkWhereDataList;
    }
}
