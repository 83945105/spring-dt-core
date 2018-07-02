package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class UserModel implements Model<UserModel, UserModel.Column, UserModel.On, UserModel.Where, UserModel.Sort, UserModel.Group> {

    public static final String tableName = "user";
    public static final String tableAlias = "User";
    public static final String primaryKeyName = "id";
    public static final String primaryKeyAlias = "id";
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
    public String getTableAlias() {
        return tableAlias;
    }

    @Override
    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    @Override
    public String getPrimaryKeyAlias() {
        return primaryKeyAlias;
    }

    @Override
    public ColumnModel<UserModel, Column, On, Where, Sort, Group> getColumn() {
        return new Column();
    }

    public static final class Column extends ColumnModel<UserModel, Column, On, Where, Sort, Group> {

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
    public OnModel<UserModel, Column, On, Where, Sort, Group> getOn() {
        return new On();
    }

    public static final class On extends OnModel<UserModel, Column, On, Where, Sort, Group> {

        private On() {
        }

        public OnBuilder<UserModel, Column, On, Where, Sort, Group> userId() {
            return this.onBuilder.handler(UserModel.tableName, UserModel.tableAlias, UserModel.userId);
        }
    }

    @Override
    public Where getWhere() {
        return new Where();
    }

    public static final class Where extends WhereModel<UserModel, Column, On, Where, Sort, Group> {

        private Where() {
        }

        public WhereBuilder<UserModel, Column, On, Where, Sort, Group> userId() {
            return this.whereBuilder.handler(UserModel.tableName, UserModel.tableAlias, UserModel.userId);
        }

    }

    @Override
    public GroupModel getGroup() {
        return new Group();
    }

    public static final class Group extends GroupModel<UserModel, Column, On, Where, Sort, Group> {

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

    public static final class Sort extends SortModel<UserModel, Column, On, Where, Sort, Group> {

        public SortBuilder<UserModel, Column, On, Where, Sort, Group> userId() {
            return this.sortBuilder.handler(UserModel.userId);
        }

    }

}