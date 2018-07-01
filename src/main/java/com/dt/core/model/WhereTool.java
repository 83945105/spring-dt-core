package com.dt.core.model;

import com.dt.core.bean.*;
import com.dt.core.data.JoinTableData;
import com.dt.core.data.LinkWhereData;
import com.dt.core.data.MainTableData;
import com.dt.core.norm.ConditionA;
import com.dt.core.norm.ConditionB;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;
import com.dt.core.parser.WhereParser;

import java.util.List;

/**
 * Created by 白超 on 2018/6/18.
 */
public abstract class WhereTool<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> extends GroupTool<M, ML, MO, MC, MS, MG> {

    private WhereParser whereParser = WhereParser.getInstance();

    public WhereTool(Data<M, ML, MO, MC, MS, MG> data) {
        super(data);
    }

    public WhereTool<M, ML, MO, MC, MS, MG> where(ConditionA<M, ML, MO, MC, MS, MG> condition) {
        MainTableData mainTableData = this.data.getMainTableData();
        MC mc = (MC) mainTableData.getTable().getWhere();
        mc.getWhereBuilder().setOwnerTableData(mainTableData);
        WhereLink<M, ML, MO, MC, MS, MG> whereLink = condition.apply(new WhereLink<>(this.data), mc);
        List<LinkWhereData> linkWhereDataList = whereLink.getLinkWhereDataList();
        mainTableData.addLinkWhereDataList(linkWhereDataList);
        this.data.addLinkWhereDataList(linkWhereDataList);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereTool<M, ML, MO, MC, MS, MG> where(Class<T> conditionClass, String alias, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        MainTableData mainTableData = this.data.getMainTableData();
        JoinTableData joinTableData = this.data.getJoinTableData(alias, conditionClass);
        MC mc = (MC) mainTableData.getTable().getWhere();
        mc.getWhereBuilder().setOwnerTableData(mainTableData);
        TC tc = (TC) joinTableData.getTable().getWhere();
        tc.getWhereBuilder().setOwnerTableData(joinTableData);
        WhereLink<M, ML, MO, MC, MS, MG> whereLink = condition.apply(new WhereLink<>(this.data), tc, mc);
        List<LinkWhereData> linkWhereDataList = whereLink.getLinkWhereDataList();
        joinTableData.addLinkWhereDataList(linkWhereDataList);
        this.data.addLinkWhereDataList(linkWhereDataList);
        return this;
    }

    public <T extends Model<T, TL, TO, TC, TS, TG>,
            TL extends ColumnModel<T, TL, TO, TC, TS, TG>,
            TO extends OnModel<T, TL, TO, TC, TS, TG>,
            TC extends WhereModel<T, TL, TO, TC, TS, TG>,
            TS extends SortModel<T, TL, TO, TC, TS, TG>,
            TG extends GroupModel<T, TL, TO, TC, TS, TG>> WhereTool<M, ML, MO, MC, MS, MG> where(Class<T> conditionClass, ConditionB<M, ML, MO, MC, MS, MG, T, TL, TO, TC, TS, TG> condition) {
        return where(conditionClass, null, condition);
    }

    @Override
    public String getWhereSql() {
        return this.whereParser.parse(this.getData().getLinkWhereDataList());
    }

}
