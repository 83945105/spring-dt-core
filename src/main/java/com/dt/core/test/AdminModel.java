package com.dt.core.test;

import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.ConditionBuilder;
import com.dt.core.bean.OnBuilder;
import com.dt.core.bean.OnModel;
import com.dt.core.norm.Model;

public final class AdminModel implements Model<AdminModel, AdminModel.AdminOn, AdminModel.AdminCondition> {

    private AdminModel() {
    }

    private static AdminModel userModel = new AdminModel();

    @Override
    public String getTableName() {
        return "admin";
    }

    @Override
    public OnModel<AdminOn, AdminModel> getOn() {
        return on();
    }

    public static AdminOn on() {
        return new AdminOn();
    }

    public static final class AdminOn extends OnModel<AdminOn, AdminModel> {
        private AdminOn() {
        }

        public OnBuilder<AdminOn> username() {
            return onBuilder;
        }
    }

    @Override
    public AdminCondition getCondition() {
        return condition();
    }

    public static AdminCondition condition() {
        return new AdminCondition();
    }

    public static final class AdminCondition extends ConditionModel<AdminCondition, AdminModel> {

        private AdminCondition() {
        }

        public ConditionBuilder<AdminCondition> id() {
            this.conditionBuilder.setHandler("Admin", "id", "ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> modelId() {
            this.conditionBuilder.setHandler("Admin", "modelId", "MODEL_ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> text() {
            this.conditionBuilder.setHandler("Admin", "text", "TEXT", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> value() {
            this.conditionBuilder.setHandler("Admin", "value", "VALUE", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> width() {
            this.conditionBuilder.setHandler("Admin", "width", "WIDTH", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> requiredInExcel() {
            this.conditionBuilder.setHandler("Admin", "requiredInExcel", "REQUIRED_IN_EXCEL", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> visible() {
            this.conditionBuilder.setHandler("Admin", "visible", "VISIBLE", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> userId() {
            this.conditionBuilder.setHandler("Admin", "userId", "USER_ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> userName() {
            this.conditionBuilder.setHandler("Admin", "userName", "USER_NAME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> sortIndex() {
            this.conditionBuilder.setHandler("Admin", "sortIndex", "SORT_INDEX", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> status() {
            this.conditionBuilder.setHandler("Admin", "status", "STATUS", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> createTime() {
            this.conditionBuilder.setHandler("Admin", "createTime", "CREATE_TIME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> modTime() {
            this.conditionBuilder.setHandler("Admin", "modTime", "MOD_TIME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> delTime() {
            this.conditionBuilder.setHandler("Admin", "delTime", "DEL_TIME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> createTimeStamp() {
            this.conditionBuilder.setHandler("Admin", "createTimeStamp", "CREATE_TIME_STAMP", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> modTimeStamp() {
            this.conditionBuilder.setHandler("Admin", "modTimeStamp", "MOD_TIME_STAMP", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<AdminCondition> delTimeStamp() {
            this.conditionBuilder.setHandler("Admin", "delTimeStamp", "DEL_TIME_STAMP", false, false);
            return conditionBuilder;
        }

    }

/*    public static AdminSort Sort() {
        return ptActivityColumnQuery.new AdminSort();
    }*/

    /*public class AdminSort extends BaseSort<AdminSort> {

        private AdminSort() {
            this.sort = this.sort == null ? new Sort<AdminSort>(this) : this.sort;
            this.owner = Admin.class;
        }

        public AdminSort clear() {
            this.sort.clear();
            return this;
        }

        public Sort<AdminSort> id() {
            this.sort.setHandler("Admin", "id", "Admin", "ID", false, false);
            return sort;
        }

        public Sort<AdminSort> modelId() {
            this.sort.setHandler("Admin", "modelId", "Admin", "MODEL_ID", false, false);
            return sort;
        }

        public Sort<AdminSort> text() {
            this.sort.setHandler("Admin", "text", "Admin", "TEXT", false, false);
            return sort;
        }

        public Sort<AdminSort> value() {
            this.sort.setHandler("Admin", "value", "Admin", "VALUE", false, false);
            return sort;
        }

        public Sort<AdminSort> width() {
            this.sort.setHandler("Admin", "width", "Admin", "WIDTH", false, false);
            return sort;
        }

        public Sort<AdminSort> requiredInExcel() {
            this.sort.setHandler("Admin", "requiredInExcel", "Admin", "REQUIRED_IN_EXCEL", false, false);
            return sort;
        }

        public Sort<AdminSort> visible() {
            this.sort.setHandler("Admin", "visible", "Admin", "VISIBLE", false, false);
            return sort;
        }

        public Sort<AdminSort> userId() {
            this.sort.setHandler("Admin", "userId", "Admin", "USER_ID", false, false);
            return sort;
        }

        public Sort<AdminSort> userName() {
            this.sort.setHandler("Admin", "userName", "Admin", "USER_NAME", false, false);
            return sort;
        }

        public Sort<AdminSort> sortIndex() {
            this.sort.setHandler("Admin", "sortIndex", "Admin", "SORT_INDEX", false, false);
            return sort;
        }

        public Sort<AdminSort> status() {
            this.sort.setHandler("Admin", "status", "Admin", "STATUS", false, false);
            return sort;
        }

        public Sort<AdminSort> createTime() {
            this.sort.setHandler("Admin", "createTime", "Admin", "CREATE_TIME", false, false);
            return sort;
        }

        public Sort<AdminSort> modTime() {
            this.sort.setHandler("Admin", "modTime", "Admin", "MOD_TIME", false, false);
            return sort;
        }

        public Sort<AdminSort> delTime() {
            this.sort.setHandler("Admin", "delTime", "Admin", "DEL_TIME", false, false);
            return sort;
        }

        public Sort<AdminSort> createTimeStamp() {
            this.sort.setHandler("Admin", "createTimeStamp", "Admin", "CREATE_TIME_STAMP", false, false);
            return sort;
        }

        public Sort<AdminSort> modTimeStamp() {
            this.sort.setHandler("Admin", "modTimeStamp", "Admin", "MOD_TIME_STAMP", false, false);
            return sort;
        }

        public Sort<AdminSort> delTimeStamp() {
            this.sort.setHandler("Admin", "delTimeStamp", "Admin", "DEL_TIME_STAMP", false, false);
            return sort;
        }

    }*/

/*    public static AdminDivide Divide() {
        return ptActivityColumnQuery.new AdminDivide();
    }*/

    /*public class AdminDivide extends BaseDivide<AdminDivide> {

        private AdminDivide() {
            this.divide = this.divide == null ? new Divide<AdminDivide>(this) : this.divide;
            this.owner = Admin.class;
        }

        public AdminDivide clear() {
            this.divide.clear();
            return this;
        }

        public Divide<AdminDivide> id() {
            this.divide.setHandler("Admin", "id", "Admin", "ID", false, false);
            return divide;
        }

        public Divide<AdminDivide> modelId() {
            this.divide.setHandler("Admin", "modelId", "Admin", "MODEL_ID", false, false);
            return divide;
        }

        public Divide<AdminDivide> text() {
            this.divide.setHandler("Admin", "text", "Admin", "TEXT", false, false);
            return divide;
        }

        public Divide<AdminDivide> value() {
            this.divide.setHandler("Admin", "value", "Admin", "VALUE", false, false);
            return divide;
        }

        public Divide<AdminDivide> width() {
            this.divide.setHandler("Admin", "width", "Admin", "WIDTH", false, false);
            return divide;
        }

        public Divide<AdminDivide> requiredInExcel() {
            this.divide.setHandler("Admin", "requiredInExcel", "Admin", "REQUIRED_IN_EXCEL", false, false);
            return divide;
        }

        public Divide<AdminDivide> visible() {
            this.divide.setHandler("Admin", "visible", "Admin", "VISIBLE", false, false);
            return divide;
        }

        public Divide<AdminDivide> userId() {
            this.divide.setHandler("Admin", "userId", "Admin", "USER_ID", false, false);
            return divide;
        }

        public Divide<AdminDivide> userName() {
            this.divide.setHandler("Admin", "userName", "Admin", "USER_NAME", false, false);
            return divide;
        }

        public Divide<AdminDivide> sortIndex() {
            this.divide.setHandler("Admin", "sortIndex", "Admin", "SORT_INDEX", false, false);
            return divide;
        }

        public Divide<AdminDivide> status() {
            this.divide.setHandler("Admin", "status", "Admin", "STATUS", false, false);
            return divide;
        }

        public Divide<AdminDivide> createTime() {
            this.divide.setHandler("Admin", "createTime", "Admin", "CREATE_TIME", false, false);
            return divide;
        }

        public Divide<AdminDivide> modTime() {
            this.divide.setHandler("Admin", "modTime", "Admin", "MOD_TIME", false, false);
            return divide;
        }

        public Divide<AdminDivide> delTime() {
            this.divide.setHandler("Admin", "delTime", "Admin", "DEL_TIME", false, false);
            return divide;
        }

        public Divide<AdminDivide> createTimeStamp() {
            this.divide.setHandler("Admin", "createTimeStamp", "Admin", "CREATE_TIME_STAMP", false, false);
            return divide;
        }

        public Divide<AdminDivide> modTimeStamp() {
            this.divide.setHandler("Admin", "modTimeStamp", "Admin", "MOD_TIME_STAMP", false, false);
            return divide;
        }

        public Divide<AdminDivide> delTimeStamp() {
            this.divide.setHandler("Admin", "delTimeStamp", "Admin", "DEL_TIME_STAMP", false, false);
            return divide;
        }

    }*/

}