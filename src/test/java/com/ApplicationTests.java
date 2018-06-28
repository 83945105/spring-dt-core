package com;

import com.dt.core.MySqlTool;
import com.dt.core.bean.JoinType;
import com.dt.core.norm.Data;
import com.dt.core.norm.DataTool;
import com.dt.core.test.AdminModel;
import com.dt.core.test.StuModel;
import com.dt.core.test.UserModel;

public class ApplicationTests {

    public static void main(String[] args) throws Exception {
        Long tst = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            Long startTime = System.nanoTime();

            DataTool dataTool = MySqlTool.SELECT(UserModel.class)

                    .innerJoin(StuModel.class, "stu2", (on, joinTable, mainTable) -> on
                            .and(joinTable.stuId().equalTo(mainTable.userId())))

                    .join("admin_10086", AdminModel.class, "Admin", JoinType.INNER, (on, joinTable, mainTable) -> on
                            .and(joinTable.adminId().equalTo(""))
                            .and(joinTable.adminId().equalTo(mainTable.userId()))
                            .and(joinTable.adminId().equalTo("stu2", StuModel.class, StuModel.On::stuId)))

                    .column(AdminModel.id, AdminModel.adminName)

                    .column(UserModel.id, UserModel.userName)

                    .column("stu2", StuModel.class, StuModel.id)

                    .column(table -> table.userId().userId().userId())

                    .column(AdminModel.class, table -> table.adminId().adminId())

                    .where((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo("")
                                    .userId().equalTo(""))
                            .or(mainTable.userId().equalTo(""))
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo("")))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and(t1.adminId().equalTo(""))
                                    .and(mt1.userId().equalTo(""))))

                    .where((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo("")))

                    .where(AdminModel.class, (condition, table, mainTable) -> condition
                            .and(StuModel.class, "stu2", (c1, t1, mt1) -> c1.and(t1.stuId().equalTo("")))
                            .and(table.adminId().equalTo("").adminId().equalTo(""))
                            .and(mainTable.userId().equalTo(""))
                            .or(mainTable.userId().equalTo(""))
                            .or(table.adminId().equalTo(""))
                            .and((c1, t1) -> c1.and((c2, t2) -> c2.and(t2.userId().equalTo(""))))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and(t1.adminId().equalTo("")).and(mt1.userId().equalTo("")))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and((c2, mt2) -> c2.and(mt2.userId().equalTo(""))))
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo(""))
                                    .or(AdminModel.class, "Admin", (c2, t2, mt2) -> c2.and(t2.adminId().equalTo("666")))
                                    .or(StuModel.class, "stu2", (c2, t2, mt2) -> c2.and(t2))))

                    .group(table -> table.userId().userId().userId())

                    .group(AdminModel.class, table -> table.adminId())

                    .group(AdminModel.class, "Admin", table -> table.adminId())

                    .sort(table -> table.userId().asc().userId().desc())

                    .sort(AdminModel.class, table -> table.adminId().desc())

                    .sort(AdminModel.class, "Admin", table -> table.adminId().desc())

                    .limit(1);

            Data data = dataTool.getData();

            Long endTime = System.nanoTime() - startTime;

            System.out.println(endTime + ":" + endTime / 1000000);
        }

        Long tse = System.nanoTime() - tst;
        System.out.println("总计:" + tse + ":" + tse / 1000000);
    }

}
