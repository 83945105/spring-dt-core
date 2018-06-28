package com.dt.core.data;

import com.dt.core.bean.*;
import com.dt.core.exception.SelectToolException;
import com.dt.core.exception.TableDataException;
import com.dt.core.norm.Data;
import com.dt.core.norm.Model;

import java.util.*;

/**
 * Created by 白超 on 2018/6/18.
 */
public final class ToolData<M extends Model<M, ML, MO, MC, MS, MG>,
        ML extends ColumnModel<M, ML, MO, MC, MS, MG>,
        MO extends OnModel<M, ML, MO, MC, MS, MG>,
        MC extends WhereModel<M, ML, MO, MC, MS, MG>,
        MS extends SortModel<M, ML, MO, MC, MS, MG>,
        MG extends GroupModel<M, ML, MO, MC, MS, MG>> implements Data<M, ML, MO, MC, MS, MG> {

    private MainTableData<M, ML, MO, MC, MS, MG> mainMainTableData;

    private Map<String, JoinTableData> joinTableDataAliasMap = new HashMap<>();
    private Map<String, Boolean> alias = new HashMap<>();

    private Set<TableData> columnDataSet = new LinkedHashSet<>();

    private List<List<LinkWhereData>> linkWhereDataList = new ArrayList<>();

    private List<GroupData> groupDataList = new ArrayList<>();

    @Override
    public MainTableData<M, ML, MO, MC, MS, MG> getMainMainTableData() {
        return this.mainMainTableData;
    }

    @Override
    public void setMainMainTableData(MainTableData<M, ML, MO, MC, MS, MG> mainMainTableData) {
        this.mainMainTableData = mainMainTableData;
    }

    @Override
    public <J extends Model<J, JL, JO, JC, JS, JG>,
            JL extends ColumnModel<J, JL, JO, JC, JS, JG>,
            JO extends OnModel<J, JL, JO, JC, JS, JG>,
            JC extends WhereModel<J, JL, JO, JC, JS, JG>,
            JS extends SortModel<J, JL, JO, JC, JS, JG>,
            JG extends GroupModel<J, JL, JO, JC, JS, JG>> JoinTableData<J, JL, JO, JC, JS, JG> getJoinTableData(String alias, Class<J> joinClass) {
        if (alias == null || alias.trim() == "") {
            try {
                alias = joinClass.newInstance().getAlias();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (alias == null || alias.trim() == "") {
            throw new TableDataException("alias can not be null or empty.");
        }
        if (this.alias.get(alias) == null) {
            throw new TableDataException("the alias table [" + alias + "] is not join");
        }
        return this.joinTableDataAliasMap.get(alias);
    }

    @Override
    public void setJoinTableData(JoinTableData joinTableData) {
        if (this.alias.get(joinTableData.getAlias()) != null) {
            throw new TableDataException("alias table [" + joinTableData.getAlias() + "] is already join, you can not join it two times, please change another alias.");
        }
        this.joinTableDataAliasMap.put(joinTableData.getAlias(), joinTableData);
        this.alias.put(joinTableData.getAlias(), true);
    }

    @Override
    public Set<TableData> getColumnDataSet() {
        return this.columnDataSet;
    }

    @Override
    public void addColumnDataSet(TableData columnData) {
        this.columnDataSet.add(columnData);
    }

    @Override
    public List<GroupData> getGroupDataList() {
        return this.groupDataList;
    }

    @Override
    public void addGroupDataList(GroupData groupData) {
        this.groupDataList.add(groupData);
    }

    @Override
    public List<List<LinkWhereData>> getLinkWhereDataList() {
        return linkWhereDataList;
    }

    @Override
    public void addLinkWhereDataList(List<LinkWhereData> linkWhereDataList) {
        if (linkWhereDataList == null || linkWhereDataList.size() == 0) {
            return;
        }
        this.linkWhereDataList.add(linkWhereDataList);
    }
}
