package com;

import com.dt.core.DataTool;
import com.dt.core.bean.ConditionLink;
import com.dt.core.bean.JoinType;
import com.dt.core.bean.OnLink;
import com.dt.core.test.AdminModel;
import com.dt.core.test.StuModel;
import com.dt.core.test.UserModel;

public class ApplicationTests {

    public static void main(String[] args) {
        Long tst = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {

            Long startTime = System.currentTimeMillis();
            DataTool.select(UserModel.class)

                    .join(AdminModel.class, JoinType.INNER, (on, joinTable, mainTable) -> on
                            .and(joinTable.adminId().equalTo("")
                                    .adminId().equalTo(""))
                            .and(mainTable.userId().equalTo(joinTable.adminId())))

                    .condition((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo()
                                    .userId().equalTo())
                            .or(mainTable.userId().equalTo())
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo()))
                            .and(UserModel.class, (c1, t1, mt1) -> c1.and(t1.userId().equalTo())
                                    .and(mt1.userId().equalTo())))

                    .condition((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo()))

                    .condition(AdminModel.class, (condition, table, mainTable) -> condition
                            .and(StuModel.class, (c1, t1, mt1) -> c1.and(t1.stuId().equalTo()))
                            .and(table.adminId().equalTo().adminId().equalTo())
                            .and(mainTable.userId().equalTo())
                            .or(mainTable.userId().equalTo())
                            .or(table.adminId().equalTo())
                            .and((c1, t1) -> c1.and((c2, t2) -> c2.and(t2.userId().equalTo())))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and(t1.adminId().equalTo()).and(mt1.userId().equalTo()))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and((c2, mt2) -> c2.and(mt2.userId().equalTo())))
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo())
                                    .or(AdminModel.class, "Admin2", (c2, t2, mt2) -> c2.and(t2.adminId().equalTo()))
                                    .or(StuModel.class, (c2, t2, mt2) -> c2.and(t2))))


                    .group(table -> table.userId().add())

                    .group(AdminModel.class, table -> table.adminId().add())

                    .group(AdminModel.class, "Admin2", table -> table.adminId().add())

                    .sort(table -> table.userId().asc().userId().desc())

                    .sort(AdminModel.class, table -> table.adminId().desc())

                    .sort(AdminModel.class, "Admin2", table -> table.adminId().desc())

                    .limit(1);

            Long endTime = System.currentTimeMillis();

            System.out.println(endTime - startTime);
        }

        Long tse = System.currentTimeMillis();
        System.out.println("总计:" + (tse - tst));
    }

}
