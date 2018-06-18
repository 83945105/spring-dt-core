package com.dt.core.test;

import com.dt.core.bean.ConditionBuilder;
import com.dt.core.bean.ConditionModel;
import com.dt.core.bean.OnBuilder;
import com.dt.core.bean.OnModel;
import com.dt.core.norm.Model;

public final class UserModel implements Model<UserModel, UserModel.UserOn, UserModel.UserCondition> {

    private UserModel() {
    }

    private static UserModel userModel = new UserModel();

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public OnModel<UserOn, UserModel> getOn() {
        return new UserOn();
    }

    public class UserOn extends OnModel<UserOn, UserModel> {
        private UserOn() {
        }

        public OnBuilder<UserOn> username() {
            return onBuilder;
        }
    }

    @Override
    public UserCondition getCondition() {
        return new UserCondition();
    }

    public static UserCondition condition() {
        return userModel.getCondition();
    }

    public class UserCondition extends ConditionModel<UserCondition, UserModel> {

        private UserCondition() {
        }

        public ConditionBuilder<UserCondition> id() {
            this.conditionBuilder.setHandler("User", "id", "ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> modelId() {
            this.conditionBuilder.setHandler("User", "modelId", "MODEL_ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> text() {
            this.conditionBuilder.setHandler("User", "text", "TEXT", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> value() {
            this.conditionBuilder.setHandler("User", "value", "VALUE", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> width() {
            this.conditionBuilder.setHandler("User", "width", "WIDTH", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> requiredInExcel() {
            this.conditionBuilder.setHandler("User", "requiredInExcel", "REQUIRED_IN_EXCEL", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> visible() {
            this.conditionBuilder.setHandler("User", "visible", "VISIBLE", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> userId() {
            this.conditionBuilder.setHandler("User", "userId", "USER_ID", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> userName() {
            this.conditionBuilder.setHandler("User", "userName", "USER_NAME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> sortIndex() {
            this.conditionBuilder.setHandler("User", "sortIndex", "SORT_INDEX", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> status() {
            this.conditionBuilder.setHandler("User", "status", "STATUS", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> createTime() {
            this.conditionBuilder.setHandler("User", "createTime", "CREATE_TIME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> modTime() {
            this.conditionBuilder.setHandler("User", "modTime", "MOD_TIME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> delTime() {
            this.conditionBuilder.setHandler("User", "delTime", "DEL_TIME", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> createTimeStamp() {
            this.conditionBuilder.setHandler("User", "createTimeStamp", "CREATE_TIME_STAMP", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> modTimeStamp() {
            this.conditionBuilder.setHandler("User", "modTimeStamp", "MOD_TIME_STAMP", false, false);
            return conditionBuilder;
        }

        public ConditionBuilder<UserCondition> delTimeStamp() {
            this.conditionBuilder.setHandler("User", "delTimeStamp", "DEL_TIME_STAMP", false, false);
            return conditionBuilder;
        }

    }

/*    public static UserSort Sort() {
        return ptActivityColumnQuery.new UserSort();
    }*/

    /*public class UserSort extends BaseSort<UserSort> {

        private UserSort() {
            this.sort = this.sort == null ? new Sort<UserSort>(this) : this.sort;
            this.owner = User.class;
        }

        public UserSort clear() {
            this.sort.clear();
            return this;
        }

        public Sort<UserSort> id() {
            this.sort.setHandler("User", "id", "User", "ID", false, false);
            return sort;
        }

        public Sort<UserSort> modelId() {
            this.sort.setHandler("User", "modelId", "User", "MODEL_ID", false, false);
            return sort;
        }

        public Sort<UserSort> text() {
            this.sort.setHandler("User", "text", "User", "TEXT", false, false);
            return sort;
        }

        public Sort<UserSort> value() {
            this.sort.setHandler("User", "value", "User", "VALUE", false, false);
            return sort;
        }

        public Sort<UserSort> width() {
            this.sort.setHandler("User", "width", "User", "WIDTH", false, false);
            return sort;
        }

        public Sort<UserSort> requiredInExcel() {
            this.sort.setHandler("User", "requiredInExcel", "User", "REQUIRED_IN_EXCEL", false, false);
            return sort;
        }

        public Sort<UserSort> visible() {
            this.sort.setHandler("User", "visible", "User", "VISIBLE", false, false);
            return sort;
        }

        public Sort<UserSort> userId() {
            this.sort.setHandler("User", "userId", "User", "USER_ID", false, false);
            return sort;
        }

        public Sort<UserSort> userName() {
            this.sort.setHandler("User", "userName", "User", "USER_NAME", false, false);
            return sort;
        }

        public Sort<UserSort> sortIndex() {
            this.sort.setHandler("User", "sortIndex", "User", "SORT_INDEX", false, false);
            return sort;
        }

        public Sort<UserSort> status() {
            this.sort.setHandler("User", "status", "User", "STATUS", false, false);
            return sort;
        }

        public Sort<UserSort> createTime() {
            this.sort.setHandler("User", "createTime", "User", "CREATE_TIME", false, false);
            return sort;
        }

        public Sort<UserSort> modTime() {
            this.sort.setHandler("User", "modTime", "User", "MOD_TIME", false, false);
            return sort;
        }

        public Sort<UserSort> delTime() {
            this.sort.setHandler("User", "delTime", "User", "DEL_TIME", false, false);
            return sort;
        }

        public Sort<UserSort> createTimeStamp() {
            this.sort.setHandler("User", "createTimeStamp", "User", "CREATE_TIME_STAMP", false, false);
            return sort;
        }

        public Sort<UserSort> modTimeStamp() {
            this.sort.setHandler("User", "modTimeStamp", "User", "MOD_TIME_STAMP", false, false);
            return sort;
        }

        public Sort<UserSort> delTimeStamp() {
            this.sort.setHandler("User", "delTimeStamp", "User", "DEL_TIME_STAMP", false, false);
            return sort;
        }

    }*/

/*    public static UserDivide Divide() {
        return ptActivityColumnQuery.new UserDivide();
    }*/

    /*public class UserDivide extends BaseDivide<UserDivide> {

        private UserDivide() {
            this.divide = this.divide == null ? new Divide<UserDivide>(this) : this.divide;
            this.owner = User.class;
        }

        public UserDivide clear() {
            this.divide.clear();
            return this;
        }

        public Divide<UserDivide> id() {
            this.divide.setHandler("User", "id", "User", "ID", false, false);
            return divide;
        }

        public Divide<UserDivide> modelId() {
            this.divide.setHandler("User", "modelId", "User", "MODEL_ID", false, false);
            return divide;
        }

        public Divide<UserDivide> text() {
            this.divide.setHandler("User", "text", "User", "TEXT", false, false);
            return divide;
        }

        public Divide<UserDivide> value() {
            this.divide.setHandler("User", "value", "User", "VALUE", false, false);
            return divide;
        }

        public Divide<UserDivide> width() {
            this.divide.setHandler("User", "width", "User", "WIDTH", false, false);
            return divide;
        }

        public Divide<UserDivide> requiredInExcel() {
            this.divide.setHandler("User", "requiredInExcel", "User", "REQUIRED_IN_EXCEL", false, false);
            return divide;
        }

        public Divide<UserDivide> visible() {
            this.divide.setHandler("User", "visible", "User", "VISIBLE", false, false);
            return divide;
        }

        public Divide<UserDivide> userId() {
            this.divide.setHandler("User", "userId", "User", "USER_ID", false, false);
            return divide;
        }

        public Divide<UserDivide> userName() {
            this.divide.setHandler("User", "userName", "User", "USER_NAME", false, false);
            return divide;
        }

        public Divide<UserDivide> sortIndex() {
            this.divide.setHandler("User", "sortIndex", "User", "SORT_INDEX", false, false);
            return divide;
        }

        public Divide<UserDivide> status() {
            this.divide.setHandler("User", "status", "User", "STATUS", false, false);
            return divide;
        }

        public Divide<UserDivide> createTime() {
            this.divide.setHandler("User", "createTime", "User", "CREATE_TIME", false, false);
            return divide;
        }

        public Divide<UserDivide> modTime() {
            this.divide.setHandler("User", "modTime", "User", "MOD_TIME", false, false);
            return divide;
        }

        public Divide<UserDivide> delTime() {
            this.divide.setHandler("User", "delTime", "User", "DEL_TIME", false, false);
            return divide;
        }

        public Divide<UserDivide> createTimeStamp() {
            this.divide.setHandler("User", "createTimeStamp", "User", "CREATE_TIME_STAMP", false, false);
            return divide;
        }

        public Divide<UserDivide> modTimeStamp() {
            this.divide.setHandler("User", "modTimeStamp", "User", "MOD_TIME_STAMP", false, false);
            return divide;
        }

        public Divide<UserDivide> delTimeStamp() {
            this.divide.setHandler("User", "delTimeStamp", "User", "DEL_TIME_STAMP", false, false);
            return divide;
        }

    }*/

}