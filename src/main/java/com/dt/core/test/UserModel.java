package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class UserModel implements Model<UserModel, UserModel.Column, UserModel.On, UserModel.Where, UserModel.Sort, UserModel.Group> {

    public static final String tableName = "user";
    public static final String alias = "User";
    public static final String id = "id";
    public static final String id_alias = "id";
    public static final String userId = "user_id";
    public static final String userId_alias = "userId";
    public static final String userName = "user_name";
    public static final String userName_alias = "userName";

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
            this.columns.put(UserModel.userId, UserModel.userId_alias);
            return this;
        }

        public Column userId(String alias) {
            this.columns.put(UserModel.userId, alias);
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
            return this.whereBuilder.handler(UserModel.tableName, UserModel.alias, UserModel.userId);
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
            this.columns.add(UserModel.userId);
            return this;
        }

    }

    @Override
    public SortModel getSort() {
        return new Sort();
    }

    public static final class Sort extends SortModel<UserModel, UserModel.Column, UserModel.On, Where, UserModel.Sort, UserModel.Group> {

        public SortBuilder<Sort> userId() {
            return this.sortBuilder.handler(UserModel.tableName, UserModel.alias, UserModel.userId);
        }

    }

}