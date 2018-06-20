package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class StuModel implements Model<StuModel, StuModel.On, StuModel.Condition, StuModel.Sort, StuModel.Group> {

    public StuModel() {
    }

    private String tableName = "stu";

    private String alias = "Stu";

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public OnModel<StuModel, StuModel.On, StuModel.Condition, StuModel.Sort, StuModel.Group> getOn() {
        return on();
    }

    public static On on() {
        return new On();
    }

    public static final class On extends OnModel<StuModel, StuModel.On, StuModel.Condition, StuModel.Sort, StuModel.Group> {

        private On() {
        }

        public OnBuilder<On> stuId() {
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

    public static final class Condition extends ConditionModel<StuModel, StuModel.On, StuModel.Condition, StuModel.Sort, StuModel.Group> {

        private Condition() {
        }

        public ConditionBuilder<Condition> stuId() {
            this.conditionBuilder.setHandler("User", "id", "ID", false, false);
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

    public static final class Sort extends SortModel<StuModel, StuModel.On, StuModel.Condition, StuModel.Sort, StuModel.Group> {

        public SortBuilder<Sort> stuId() {
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

    public static final class Group extends GroupModel<StuModel, StuModel.On, StuModel.Condition, StuModel.Sort, StuModel.Group> {

        private Group() {
        }

        public GroupBuilder<Group> stuId() {
            return groupBuilder;
        }

    }

}