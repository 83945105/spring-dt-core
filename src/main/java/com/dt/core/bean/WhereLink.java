package com.dt.core.bean;

import com.dt.core.data.JoinTableData;
import com.dt.core.data.LinkWhereData;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.ConditionA;
import com.dt.core.norm.ConditionB;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件连接器
 *
 * @author 白超
 * @version 1.0
 * @since 2018/7/10
 */
public class WhereLink<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    protected Data data;

    WhereLink(Data data) {
        this.data = data;
    }

    List<LinkWhereData> linkWhereDataList = new ArrayList<>();

    public List<LinkWhereData> getLinkWhereDataList() {
        List<LinkWhereData> list = this.linkWhereDataList;
        /*
          每次取走后重置集合
         */
        this.linkWhereDataList = new ArrayList<>();
        return list;
    }

    /**
     * 且
     * @param whereModel 目标条件连接器
     * @return 当前条件连接器
     */
    public WhereLinkIntact<M, ML, MO, MC, MS, MG> and(WhereModel<?, ?, ?, ?, ?, ?> whereModel) {
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.AND);
        linkWhereData.setWhereDataList(whereModel.whereBuilder.getWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return (WhereLinkIntact<M, ML, MO, MC, MS, MG>) this;
    }

    /**
     * 且
     * @param condition 条件
     * @return 当前条件连接器
     */
    @SuppressWarnings("unchecked")
    public WhereLinkIntact<M, ML, MO, MC, MS, MG> and(ConditionA<M, ML, MO, MC, MS, MG> condition) {
        MainTableData mainTableData = this.data.getMainTableData();
        MC mc = (MC) mainTableData.getTable().getWhere();
        mc.getWhereBuilder().setOwnerTableData(mainTableData);
        WhereLink<M, ML, MO, MC, MS, MG> whereLink = condition.apply(new WhereLinkIntact<>(this.data), mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.AND);
        linkWhereData.setLinkWhereDataList(whereLink.getLinkWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return (WhereLinkIntact<M, ML, MO, MC, MS, MG>) this;
    }

    /**
     * 且
     * @param conditionClass 目标条件类
     * @param alias 目标条件别名
     * @param condition 条件
     * @return 当前条件连接器
     */
    @SuppressWarnings("unchecked")
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLinkIntact<M, ML, MO, MC, MS, MG> and(Class<T> conditionClass,
                                                                                                     String alias,
                                                                                                     ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        MainTableData mainTableData = this.data.getMainTableData();
        JoinTableData joinTableData = this.data.getJoinTableData(alias, conditionClass);
        MC mc = (MC) mainTableData.getTable().getWhere();
        mc.getWhereBuilder().setOwnerTableData(mainTableData);
        TC tc = (TC) joinTableData.getTable().getWhere();
        tc.getWhereBuilder().setOwnerTableData(joinTableData);
        WhereLink<M, ML, MO, MC, MS, MG> whereLink = condition.apply(new WhereLinkIntact<>(this.data), tc, mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.AND);
        linkWhereData.setLinkWhereDataList(whereLink.getLinkWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return (WhereLinkIntact<M, ML, MO, MC, MS, MG>) this;
    }

    /**
     *
     * @param conditionClass 目标条件类
     * @param condition 条件
     * @return 当前条件连接器
     */
    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLinkIntact<M, ML, MO, MC, MS, MG> and(Class<T> conditionClass, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        return and(conditionClass, null, condition);
    }

}
