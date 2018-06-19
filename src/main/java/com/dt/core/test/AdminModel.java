package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class AdminModel implements Model<AdminModel, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

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
    public OnModel<AdminModel, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> getOn() {
        return on();
    }

    public static On on() {
        return new On();
    }

    public static final class On extends OnModel<AdminModel, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private On() {
        }

        public OnBuilder<On> username() {
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

    public static final class Condition extends ConditionModel<AdminModel, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private Condition() {
        }

        public ConditionBuilder<Condition> id() {
            this.conditionBuilder.setHandler("Admin", "id", "ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<Condition> modelId() {
            this.conditionBuilder.setHandler("Admin", "modelId", "MODEL_ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<Condition> text() {
            this.conditionBuilder.setHandler("Admin", "text", "TEXT", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<Condition> value() {
            this.conditionBuilder.setHandler("Admin", "value", "VALUE", false, false);
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

    public static final class Sort extends SortModel<AdminModel, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        public SortBuilder<Sort> id() {
            return sortBuilder;
        }

        public SortBuilder<Sort> modelId() {
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

    public static final class Group extends GroupModel<AdminModel, AdminModel.On, AdminModel.Condition, AdminModel.Sort, AdminModel.Group> {

        private Group() {
        }

        public GroupBuilder<Group> id() {
            return groupBuilder;
        }

    }

}