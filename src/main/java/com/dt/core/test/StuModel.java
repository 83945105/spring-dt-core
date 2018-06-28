package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class StuModel implements Model<StuModel, StuModel.Column, StuModel.On, StuModel.Where, StuModel.Sort, StuModel.Group> {

    public static final String tableName = "stu";
    public static final String alias = "Stu";
    public static final String id = "id";
    public static final String stuId = "stu_id";
    public static final String stuName = "stu_name";

    public StuModel() {
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
    public ColumnModel<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> getColumn() {
        return new Column();
    }

    public static final class Column extends ColumnModel<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> {

        private Column() {
        }

        public Column stuId() {
            this.columns.add(StuModel.stuId);
            return this;
        }
    }

    @Override
    public OnModel<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> getOn() {
        return new On();
    }

    public static final class On extends OnModel<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> {

        private On() {
        }

        public OnBuilder<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> stuId() {
            return this.onBuilder.handler(StuModel.tableName, StuModel.alias, StuModel.stuId);
        }
    }

    @Override
    public Where getWhere() {
        return new Where();
    }

    public static final class Where extends WhereModel<StuModel, Column, On, Where, Sort, Group> {

        private Where() {
        }

        public WhereBuilder<Where> stuId() {
            return this.whereBuilder.handler(StuModel.tableName, StuModel.alias, StuModel.stuId);
        }

    }

    @Override
    public GroupModel getGroup() {
        return new Group();
    }

    public static final class Group extends GroupModel<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> {

        private Group() {
        }

        public Group stuId() {
            this.columns.add(StuModel.stuId);
            return this;
        }

    }

    @Override
    public SortModel getSort() {
        return new Sort();
    }

    public static final class Sort extends SortModel<StuModel, StuModel.Column, StuModel.On, Where, StuModel.Sort, StuModel.Group> {

        public SortBuilder<Sort> stuId() {
            return this.sortBuilder.handler(StuModel.tableName, StuModel.alias, StuModel.stuId);
        }

    }

}