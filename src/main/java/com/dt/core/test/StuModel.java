package com.dt.core.test;

import com.dt.core.bean.*;
import com.dt.core.norm.Model;

public final class StuModel implements Model<StuModel, StuModel.Column, StuModel.On, StuModel.Where, StuModel.Sort, StuModel.Group> {

    public static final String tableName = "stu";
    public static final String tableAlias = "Stu";
    public static final String primaryKeyName = "id";
    public static final String primaryKeyAlias = "id";
    public static final String id = "id";
    public static final String id_alias = "id";
    public static final String stuId = "stu_id";
    public static final String stuId_alias = "stuId";
    public static final String stuName = "stu_name";
    public static final String stuName_alias = "stuName";

    public StuModel() {
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
    public ColumnModel<StuModel, Column, On, Where, Sort, Group> getColumn() {
        return new Column();
    }

    public static final class Column extends ColumnModel<StuModel, Column, On, Where, Sort, Group> {

        private Column() {
        }

        public Column stuId() {
            this.columns.put(StuModel.stuId, StuModel.stuId_alias);
            return this;
        }

        public Column stuId(String alias) {
            this.columns.put(StuModel.stuId, alias);
            return this;
        }
    }

    @Override
    public OnModel<StuModel, Column, On, Where, Sort, Group> getOn() {
        return new On();
    }

    public static final class On extends OnModel<StuModel, Column, On, Where, Sort, Group> {

        private On() {
        }

        public OnBuilder<StuModel, Column, On, Where, Sort, Group> stuId() {
            return this.onBuilder.handler(StuModel.tableName, StuModel.tableAlias, StuModel.stuId);
        }
    }

    @Override
    public Where getWhere() {
        return new Where();
    }

    public static final class Where extends WhereModel<StuModel, Column, On, Where, Sort, Group> {

        private Where() {
        }

        public WhereBuilder<StuModel, Column, On, Where, Sort, Group> stuId() {
            return this.whereBuilder.handler(StuModel.tableName, StuModel.tableAlias, StuModel.stuId);
        }

    }

    @Override
    public GroupModel getGroup() {
        return new Group();
    }

    public static final class Group extends GroupModel<StuModel, Column, On, Where, Sort, Group> {

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

    public static final class Sort extends SortModel<StuModel, Column, On, Where, Sort, Group> {

        public SortBuilder<StuModel, Column, On, Where, Sort, Group> stuId() {
            return this.sortBuilder.handler(StuModel.stuId);
        }

    }

}