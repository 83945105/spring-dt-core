package com.dt.core.norm;

import com.dt.core.bean.*;
import com.dt.core.data.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by 白超 on 2018/6/19.
 */
public interface Data<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> {

    MainTableData<M, ML, MO, MC, MS, MG> getMainTableData();

    void setMainTableData(MainTableData<M, ML, MO, MC, MS, MG> mainMainTableData);

    <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTableData<J, JL, JO, JC, JS, JG> getJoinTableData(String alias, Class<J> joinClass);


    void setJoinTableData(JoinTableData joinTableData);

    default <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> void setJoinTableData(String alias, Class<J> joinClass) {
        JoinTableData<J, JL, JO, JC, JS, JG> joinTableData = new JoinTableData<>(joinClass);
        joinTableData.setAlias(alias);
        this.setJoinTableData(joinTableData);
    }

    Set<TableData> getColumnDataSet();

    void addColumnDataSet(TableData columnData);

    default void addColumnDataSet(Set<TableData> columnDataSet) {
        if (columnDataSet == null || columnDataSet.size() == 0) {
            return;
        }
        Iterator<TableData> iterator = columnDataSet.iterator();
        while (iterator.hasNext()) {
            this.addColumnDataSet(iterator.next());
        }
    }

    default void addColumnDataSet(TableData[] columnDatas) {
        if (columnDatas == null || columnDatas.length == 0) {
            return;
        }
        for (TableData columnData : columnDatas) {
            this.addColumnDataSet(columnData);
        }
    }

    List<List<LinkWhereData>> getLinkWhereDataList();

    void addLinkWhereDataList(List<LinkWhereData> linkWhereDataList);

    List<GroupData> getGroupDataList();

    void addGroupDataList(GroupData groupData);

    List<List<SortData>> getSortDataList();

    void addSortDataList(List<SortData> sortDataList);

}
