package com.dt.core.bean;

/**
 * Created by 白超 on 2018/6/19.
 */
public final class GroupBuilder<G extends GroupModel> {

    private G handleModel;

    public GroupBuilder(G handleModel) {
        this.handleModel = handleModel;
    }

    public G add() {
        return handleModel;
    }

}
