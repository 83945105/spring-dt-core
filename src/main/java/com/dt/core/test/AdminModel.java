package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class AdminModel implements Model<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Where, AdminModel.Sort, AdminModel.Group> {

    public static final String tableName = "admin";
    public static final String alias = "Admin";
    public static final String id = "id";
    public static final String id_alias = "id";
    public static final String adminId = "admin_id";
    public static final String adminId_alias = "adminId";
    public static final String adminName = "admin_name";
    public static final String adminName_alias = "adminName";

    public AdminModel() {
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
    public ColumnModel<AdminModel, Column, On, Where, Sort, Group> getColumn() {
        return new Column();
    }

    public static final class Column extends ColumnModel<AdminModel, AdminModel.Column, AdminModel.On, Where, AdminModel.Sort, AdminModel.Group> {

        private Column() {
        }

        public Column adminId() {
            this.columns.put(AdminModel.adminId, AdminModel.adminId_alias);
            return this;
        }

        public Column adminId(String alias) {
            this.columns.put(AdminModel.adminId, alias);
            return this;
        }
    }

    @Override
    public OnModel<AdminModel, AdminModel.Column, AdminModel.On, Where, AdminModel.Sort, AdminModel.Group> getOn() {
        return new On();
    }

    public static final class On extends OnModel<AdminModel, AdminModel.Column, AdminModel.On, Where, AdminModel.Sort, AdminModel.Group> {

        private On() {
        }

        public OnBuilder<AdminModel, AdminModel.Column, AdminModel.On, Where, AdminModel.Sort, AdminModel.Group> adminId() {
            return this.onBuilder.handler(AdminModel.tableName, AdminModel.alias, AdminModel.adminId);
        }
    }

    @Override
    public Where getWhere() {
        return new Where();
    }

    public static final class Where extends WhereModel<AdminModel, Column, On, Where, Sort, Group> {

        private Where() {
        }

        public WhereBuilder<Where> adminId() {
            return this.whereBuilder.handler(AdminModel.tableName, AdminModel.alias, AdminModel.adminId);
        }

    }

    @Override
    public GroupModel getGroup() {
        return new Group();
    }

    public static final class Group extends GroupModel<AdminModel, AdminModel.Column, AdminModel.On, Where, AdminModel.Sort, AdminModel.Group> {

        private Group() {
        }

        public Group adminId() {
            this.columns.add(AdminModel.adminId);
            return this;
        }

    }

    @Override
    public SortModel getSort() {
        return new Sort();
    }

    public static final class Sort extends SortModel<AdminModel, AdminModel.Column, AdminModel.On, Where, AdminModel.Sort, AdminModel.Group> {

        public SortBuilder<Sort> adminId() {
            return this.sortBuilder.handler(AdminModel.tableName, AdminModel.alias, AdminModel.adminId);
        }

    }

}