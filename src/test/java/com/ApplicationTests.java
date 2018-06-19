package com;

import com.dt.core.DataTool;
import com.dt.core.bean.ConditionLink;
import com.dt.core.bean.JoinType;
import com.dt.core.bean.OnLink;
import com.dt.core.test.AdminModel;
import com.dt.core.test.UserModel;

public class ApplicationTests {

    public static void main(String[] args) {
        Long tst = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {

            Long startTime = System.currentTimeMillis();
            DataTool.select(UserModel.class)

                    .join(AdminModel.class, JoinType.INNER, (on, joinTable, mainTable) -> on
                            .and(joinTable.username().equalTo("")
                                    .username().equalTo(""))
                            .and(mainTable.username().equalTo(joinTable.username())))

                    .condition((condition, table) -> condition
                            .and(table.modelId().equalTo()
                                    .id().equalTo())
                            .or(table.id().equalTo()))

                    .condition((condition, table) -> condition
                            .and(table.id().equalTo()))

                    .condition(AdminModel.class, (condition, table) -> condition
                            .and(table.modelId().equalTo()))

                    .group()

                    .sort(table -> table.name().asc().name().desc())

                    .sort(AdminModel.class, table -> table.id().desc())

                    .sort((sort, table) -> sort
                            .and(table.name().asc().name().desc())
                            .and(AdminModel.class, table1 -> table1))

                    .limit(1);

            Long endTime = System.currentTimeMillis();

            System.out.println(endTime - startTime);
        }

        Long tse = System.currentTimeMillis();
        System.out.println("总计:" + (tse - tst));
    }

}
