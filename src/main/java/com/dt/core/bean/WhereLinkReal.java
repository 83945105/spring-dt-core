package com.dt.core.bean;

import com.dt.core.data.JoinTableData;
import com.dt.core.data.LinkWhereData;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.ConditionA;
import com.dt.core.norm.ConditionB;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/7/2.
 */
public class WhereLinkReal<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends WhereLink<M, ML, MO, MC, MS, MG> {

    public WhereLinkReal(Data data) {
        super(data);
    }

    public WhereLinkReal<M, ML, MO, MC, MS, MG> or(WhereModel<?, ?, ?, ?, ?, ?> whereModel) {
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.OR);
        linkWhereData.setWhereDataList(whereModel.whereBuilder.getWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public WhereLinkReal<M, ML, MO, MC, MS, MG> or(ConditionA<M, ML, MO, MC, MS, MG> condition) {
        MainTableData mainTableData = this.data.getMainTableData();
        MC mc = (MC) mainTableData.getTable().getWhere();
        mc.getWhereBuilder().setOwnerTableData(mainTableData);
        WhereLink<M, ML, MO, MC, MS, MG> whereLink = condition.apply(new WhereLinkReal<>(this.data), mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.OR);
        linkWhereData.setLinkWhereDataList(whereLink.getLinkWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLinkReal<M, ML, MO, MC, MS, MG> or(Class<T> conditionClass,
                                                                                              String alias,
                                                                                              ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        MainTableData mainTableData = this.data.getMainTableData();
        JoinTableData joinTableData = this.data.getJoinTableData(alias, conditionClass);
        MC mc = (MC) mainTableData.getTable().getWhere();
        mc.getWhereBuilder().setOwnerTableData(mainTableData);
        TC tc = (TC) joinTableData.getTable().getWhere();
        tc.getWhereBuilder().setOwnerTableData(joinTableData);
        WhereLink<M, ML, MO, MC, MS, MG> whereLink = condition.apply(new WhereLinkReal<>(this.data), tc, mc);
        LinkWhereData linkWhereData = new LinkWhereData(LinkType.OR);
        linkWhereData.setLinkWhereDataList(whereLink.getLinkWhereDataList());
        this.linkWhereDataList.add(linkWhereData);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereLinkReal<M, ML, MO, MC, MS, MG> or(Class<T> conditionClass, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        return or(conditionClass, null, condition);
    }

}
