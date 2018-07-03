package com.dt.core.parser;

import com.dt.core.data.SortData;
import com.dt.core.data.TableData;
import com.dt.core.exception.DtException;

import java.util.List;

/**
 * Created by 白超 on 2018/7/2.
 */
public class SortParser {

    private SortParser() {
    }

    private static final SortParser SORT_PARSER = new SortParser();

    public static SortParser getInstance() {
        return SORT_PARSER;
    }

    public String parse(List<List<SortData>> sortDataList) {
        if (sortDataList == null || sortDataList.size() == 0) {
            return null;
        }
        StringBuilder sql = new StringBuilder(64);
        TableData tableData;
        for (List<SortData> sortData : sortDataList) {
            for (SortData data : sortData) {
                tableData = data.getTableData();
                sql.append(", ")
                        .append(tableData.getTableAlias())
                        .append(".")
                        .append(data.getColumnName());
                switch (data.getSortType()) {
                    case ASC:
                        sql.append(" asc");
                        continue;
                    case DESC:
                        sql.append(" desc");
                        continue;
                    default:
                        throw new DtException("the SortType is wrong.");
                }
            }
        }
        return sql.length() > 2 ? sql.replace(0, 2, "order by ").toString() : null;
    }
}
