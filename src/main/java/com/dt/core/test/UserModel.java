package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class UserModel implements Model<UserModel, UserModel.Column, UserModel.On, UserModel.Where, UserModel.Sort, UserModel.Group> {

    public static final String tableName = "user";
    public static final String alias = "User";
    public static final String id = "id";
    public static final String userId = "user_id";
    public static final String userName = "user_name";

    public UserModel() {
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public ColumnModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> getColumn() {
        return new Column();
    }

    public static final class Column extends ColumnModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> {

        private Column() {
        }

        public Column userId() {
            this.columns.add("user_id");
            return this;
        }
    }

    @Override
    public OnModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> getOn() {
        return new On();
    }

    public static final class On extends OnModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> {

        private On() {
        }

        public OnBuilder<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> userId() {
            return this.onBuilder.handler(UserModel.tableName, UserModel.alias, UserModel.userId);
        }
    }

    @Override
    public Where getWhere() {
        return new Where();
    }

    public static final class Where extends WhereModel<UserModel, Column, On, Where, Sort, Group> {

        private Where() {
        }

        public WhereBuilder<Where> userId() {
            this.whereBuilder.setHandler("User", "id", "ID", false, false);
            return whereBuilder;
        }

    }

    @Override
    public SortModel getSort() {
        return new Sort();
    }

    public static final class Sort extends SortModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> {

        public SortBuilder<Sort> userId() {
            return sortBuilder;
        }

    }

    @Override
    public GroupModel getGroup() {
        return new Group();
    }

    public static final class Group extends GroupModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> {

        private Group() {
        }

        public Group userId() {
            return this;
        }

    }

}