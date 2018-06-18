package com.dt.core.data;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnModel;
import com.dt.core.norm.Model;

/**
 * Created by 白超 on 2018/6/18.
 */
public class Data<T extends Model<T, TO, TC>, TO extends OnModel<TO, T>, TC extends ConditionModel<TC, T>> {

    protected Data ownerData;

    protected Class<T> targetClass;

    protected T target;

    protected String tableName;

    public <O extends Model<O, OO, OC>,
            OO extends OnModel<OO, O>,
            OC extends ConditionModel<OC, O>> Data(Data<O, OO, OC> ownerData, Class<T> targetClass) {
        this.ownerData = ownerData;
        this.targetClass = targetClass;
        try {
            this.target = targetClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Class<T> getTargetClass() {
        return targetClass;
    }

    public T getTarget() {
        return target;
    }

    public String getTableName() {
        return tableName == null ? getTarget().getTableName() : tableName;
    }

    public void setTableName(String tableName) {
        if (tableName != null) {
            this.tableName = tableName;
        }
    }

    public TO getTargetOn() {
        return (TO) getTarget().getOn();
    }

    public TC getTargetCondition() {
        return (TC) getTarget().getCondition();
    }

}
