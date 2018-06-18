package com;

import com.dt.core.DataTool;
import com.dt.core.bean.ConditionLink;
import com.dt.core.bean.JoinType;
import com.dt.core.bean.OnLink;
import com.dt.core.test.AdminModel;
import com.dt.core.test.UserModel;

public class ApplicationTests {

    public static void main(String[] args) {
        DataTool.select(UserModel.class)
                .join(AdminModel.class, JoinType.INNER, (on, joinTable, mainTable) -> on
                        .and(joinTable.username().equalTo("")
                                .username().equalTo(""))
                        .and(mainTable.username().equalTo(joinTable.username())))
                .condition((condition, mainTable) -> condition
                        .and(mainTable.modelId().equalTo()
                                .createTime().equalTo())
                        .or(mainTable.id().equalTo()))
                .condition((condition, mainTable) -> condition
                        .and(mainTable.id().equalTo()))
                .condition(AdminModel.class, (condition, mainTable) -> condition
                        .and(mainTable.modelId().equalTo()))
                .group()
                .sort()
                .limit();
    }

}
