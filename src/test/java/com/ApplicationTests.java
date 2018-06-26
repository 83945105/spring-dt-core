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
        Long tst = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            Long startTime = System.currentTimeMillis();

            DataTool dataTool = MySqlTool.SELECT("user_10086", UserModel.class)

                    .column(AdminModel.id, AdminModel.adminName)

                    .column(UserModel.class, UserModel.id, UserModel.userName)

                    .column("Stu2", StuModel.class, StuModel.id)

                    .column(table -> table.userId().userId().userId())

                    .column(AdminModel.class, table -> table.adminId().adminId())

                    .join("admin_10086", AdminModel.class, "admin2", JoinType.INNER, (on, joinTable, mainTable) -> on
                            .and(joinTable.adminId().equalTo(""))
                            .and(joinTable.adminId().equalTo(mainTable.userId()))
                            .and(joinTable.adminId().equalTo("stu2", StuModel.class, StuModel.On::stuId)))

                    .where((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo("")
                                    .userId().equalTo(""))
                            .or(mainTable.userId().equalTo(""))
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo("")))
                            .and(UserModel.class, (c1, t1, mt1) -> c1.and(t1.userId().equalTo(""))
                                    .and(mt1.userId().equalTo(""))))

                    .where((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo("")))

                    .where(AdminModel.class, (condition, table, mainTable) -> condition
                            .and(StuModel.class, (c1, t1, mt1) -> c1.and(t1.stuId().equalTo("")))
                            .and(table.adminId().equalTo("").adminId().equalTo(""))
                            .and(mainTable.userId().equalTo(""))
                            .or(mainTable.userId().equalTo(""))
                            .or(table.adminId().equalTo(""))
                            .and((c1, t1) -> c1.and((c2, t2) -> c2.and(t2.userId().equalTo(""))))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and(t1.adminId().equalTo("")).and(mt1.userId().equalTo("")))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and((c2, mt2) -> c2.and(mt2.userId().equalTo(""))))
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo(""))
                                    .or(AdminModel.class, "Admin2", (c2, t2, mt2) -> c2.and(t2.adminId().equalTo("666")))
                                    .or(StuModel.class, (c2, t2, mt2) -> c2.and(t2))))

                    .group(table -> table.userId().userId().userId())

                    .group(AdminModel.class, table -> table.adminId())

                    .group(AdminModel.class, "Admin2", table -> table.adminId())

                    .sort(table -> table.userId().asc().userId().desc())

                    .sort(AdminModel.class, table -> table.adminId().desc())

                    .sort(AdminModel.class, "Admin2", table -> table.adminId().desc())

                    .limit(1);


            Data data = dataTool.getData();

            Long endTime = System.currentTimeMillis();

            System.out.println(endTime - startTime);
        }

        Long tse = System.currentTimeMillis();
        System.out.println("总计:" + (tse - tst));
    }

}
