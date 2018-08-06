package com.dt.core.norm;

import com.dt.core.bean.*;
import com.dt.core.data.*;

import java.util.*;

/**
 * 数据
 *
 * @author 白超
 * @version 1.0
 * @since 2018/7/10
 */
public interface Data<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTableData<J, JL, JO, JC, JS, JG> getJoinTableData(String alias, Class<J> joinClass);

    default <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> void setJoinTableData(String alias, Class<J> joinClass) {
        JoinTableData<J, JL, JO, JC, JS, JG> joinTableData = new JoinTableData<>(joinClass);
        joinTableData.setTableAlias(alias);
        this.setJoinTableData(joinTableData);
    }

    MainTableData<M, ML, MO, MC, MS, MG> getMainTableData();

    void setMainTableData(MainTableData<M, ML, MO, MC, MS, MG> mainMainTableData);

    Map<String, JoinTableData> getJoinTableDataAliasMap();

    void setJoinTableData(JoinTableData joinTableData);

    Set<AbstractTableData> getColumnDataSet();

    void addColumnData(AbstractTableData columnData);

    Set<VirtualFieldData> getVirtualFieldDataSet();

    void addVirtualFieldData(VirtualFieldData virtualFieldData);

    Set<FunctionColumnData> getFunctionColumnDataSet();

    void addFunctionColumnData(FunctionColumnData functionColumnData);

    List<List<LinkWhereData>> getLinkWhereDataList();

    void addLinkWhereDataList(List<LinkWhereData> linkWhereDataList);

    List<GroupData> getGroupDataList();

    void addGroupData(GroupData groupData);

    List<List<SortData>> getSortDataList();

    void addSortDataList(List<SortData> sortDataList);

    Integer getLimitStart();

    void setLimitStart(Integer limitStart);

    Integer getLimitEnd();

    void setLimitEnd(Integer limitEnd);

}
