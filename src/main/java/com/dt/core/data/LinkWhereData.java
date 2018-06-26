package com.dt.core.data;

import com.dt.core.bean.LinkType;

import java.util.List;

/**
 * Created by 白超 on 2018/6/26.
 */
public class LinkWhereData {

    private LinkType linkType;

    private List<WhereData> whereDataList;

    private List<LinkWhereData> linkWhereDataList;

    public LinkWhereData(LinkType linkType) {
        this.linkType = linkType;
    }

    public List<WhereData> getWhereDataList() {
        return whereDataList;
    }

    public void setWhereDataList(List<WhereData> whereDataList) {
        this.whereDataList = whereDataList;
    }

    public List<LinkWhereData> getLinkWhereDataList() {
        return linkWhereDataList;
    }

    public void setLinkWhereDataList(List<LinkWhereData> linkWhereDataList) {
        this.linkWhereDataList = linkWhereDataList;
    }
}
