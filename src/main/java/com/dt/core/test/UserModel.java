package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class UserModel implements Model<UserModel, UserModel.On, UserModel.Condition, UserModel.Sort, UserModel.Group> {

    public UserModel() {
    }

    private String tableName = "user";

    private String alias = "User";

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public OnModel<UserModel, UserModel.On, UserModel.Condition, UserModel.Sort, UserModel.Group> getOn() {
        return on();
    }

    public static On on() {
        return new On();
    }

    public static final class On extends OnModel<UserModel, UserModel.On, UserModel.Condition, UserModel.Sort, UserModel.Group> {

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

    public static final class Condition extends ConditionModel<UserModel, UserModel.On, UserModel.Condition, UserModel.Sort, UserModel.Group> {

        private Condition() {
        }

        public ConditionBuilder<Condition> id() {
            this.conditionBuilder.setHandler("User", "id", "ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<Condition> modelId() {
            this.conditionBuilder.setHandler("User", "modelId", "MODEL_ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<Condition> text() {
            this.conditionBuilder.setHandler("User", "text", "TEXT", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<Condition> value() {
            this.conditionBuilder.setHandler("User", "value", "VALUE", false, false);
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

    public static final class Sort extends SortModel<UserModel, UserModel.On, UserModel.Condition, UserModel.Sort, UserModel.Group> {

        public SortBuilder<Sort> name() {
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

    public static final class Group extends GroupModel<UserModel, UserModel.On, UserModel.Condition, UserModel.Sort, UserModel.Group> {

        private Group() {
        }

        public GroupBuilder<Group> id() {
            return groupBuilder;
        }

    }

}