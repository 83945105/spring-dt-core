package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class AdminModel implements Model<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

    public static final String id = "id";
    public static final String adminName = "admin_name";

    public AdminModel() {
    }

    private String tableName = "admin";

    private String alias = "Admin";

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public ColumnModel<AdminModel, Column, On, Condition, Sort, Group> getColumn() {
        return column();
    }

    public static Column column() {
        return new Column();
    }

    public static final class Column extends ColumnModel<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private Column() {
        }

        public Column adminId() {
            return this;
        }
    }

    @Override
    public OnModel<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> getOn() {
        return on();
    }

    public static On on() {
        return new On();
    }

    public static final class On extends OnModel<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private On() {
        }

        public OnBuilder<On> adminId() {
            return onBuilder;
        }
    }

    @Override
    public Condition getCondition() {
        return condition();
    }

    public static Condition condition() {
        return new Condition();
    }

    public static final class Condition extends ConditionModel<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private Condition() {
        }

        public ConditionBuilder<Condition> adminId() {
            this.conditionBuilder.setHandler("Admin", "id", "ID", false, false);
            return conditionBuilder;
        }

    }

    @Override
    public SortModel getSort() {
        return sort();
    }

    public static Sort sort() {
        return new Sort();
    }

    public static final class Sort extends SortModel<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        public SortBuilder<Sort> adminId() {
            return sortBuilder;
        }

    }

    @Override
    public GroupModel getGroup() {
        return group();
    }

    public static Group group() {
        return new Group();
    }

    public static final class Group extends GroupModel<AdminModel, AdminModel.Column, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private Group() {
        }

        public Group adminId() {
            return this;
        }

    }

}