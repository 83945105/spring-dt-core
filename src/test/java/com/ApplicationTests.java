package com;

import com.dt.core.engine.ColumnEngine;
import com.dt.core.engine.MySqlEngine;
import com.dt.core.bean.ComparisonRule;
import com.dt.core.bean.JoinType;
import com.dt.core.engine.SelectEngine;
import com.dt.core.engine.SqlEngine;
import com.dt.core.test.AdminModel;
import com.dt.core.test.StuModel;
import com.dt.core.test.UserModel;

public class ApplicationTests {

    public static void main(String[] args) throws Exception {
        ApplicationTests.method2();
    }

    public static void method2() {
        ColumnEngine engine = MySqlEngine.column(UserModel.class)
                .column(table -> table.userId());

        System.out.println(engine.getColumnSql());

        SelectEngine selectEngine = new SelectEngine();

        for (int i = 0; i < 1; i++) {
            Long startTime = System.nanoTime();

            System.out.println(selectEngine.selectByPrimaryKey(engine));
            Long tse = System.nanoTime() - startTime;
            System.out.println("总计:" + tse + ":" + tse / 1000000);
        }
    }

    public static void method1() {
        String null_param = null;

        Long tst = System.nanoTime();

        for (int i = 0; i < 1; i++) {
            Long startTime = System.nanoTime();

            SqlEngine engine = MySqlEngine.main(UserModel.class)

                    .innerJoin(StuModel.class, "stu2", (on, joinTable, mainTable) -> on
                            .and(joinTable.stuId().equalTo(mainTable.userId())))

                    .join("admin_10086", AdminModel.class, "Admin", JoinType.INNER, (on, joinTable, mainTable) -> on
                            .and(joinTable.adminId().equalTo(null_param))
                            .and(joinTable.adminId().equalTo(mainTable.userId()))
                            .and(joinTable.adminId().equalTo("stu2", StuModel.class, StuModel.On::stuId))
                            .and(joinTable.adminId().in(ComparisonRule.NULL_SKIP, "1", "2", "3", "4", "5")))

                    .leftJoin(UserModel.class, "User2", (on, joinTable, mainTable) -> on
                            .and(joinTable.userId().equalTo(mainTable.userId())))

                    .column(table -> table.userId().userId().userId())

                    .column(AdminModel.class, table -> table.adminId().adminId())

                    .column(UserModel.class, "User2", table -> table.userId("userId2"))

                    .where((condition, mainTable) -> condition
                            .and(mainTable.userId().equalTo("")
                                    .userId().greaterThan(""))
                            .or(mainTable.userId().between("", "").userId().isNull())
                            .and((c1, mt1) -> c1.and(mt1.userId().equalTo("")).or(mt1.userId().like("")))
                            .and(AdminModel.class, (c1, t1, mt1) -> c1.and(t1.adminId().equalTo(""))
                                    .and(mt1.userId().equalTo(""))))

                    .where((condition, mainTable) -> condition
                            .and(mainTable.userId().lessThan("")))

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
                                    .or(AdminModel.class, "Admin", (c2, t2, mt2) -> c2.and(t2.adminId().equalTo("666").adminId().isNull()))
                                    .or(StuModel.class, "stu2", (c2, t2, mt2) -> c2.and(t2))
                            ))

                    .group(table -> table.userId().userId().userId())

                    .group(AdminModel.class, table -> table.adminId())

                    .group(StuModel.class, "stu2", table -> table.stuId())

                    .sort(table -> table.userId().asc().userId().desc())

                    .sort(AdminModel.class, table -> table.adminId().desc())

                    .sort(AdminModel.class, "Admin", table -> table.adminId().desc())

                    .sort(StuModel.class, "stu2", table -> table.stuId().desc())

                    .limit(1);

            System.out.println(engine.getColumnSql());
            System.out.println(engine.getJoinSql());
            System.out.println(engine.getWhereSql());
            System.out.println(engine.getGroupSql());
            System.out.println(engine.getSortSql());

            Long endTime = System.nanoTime() - startTime;

            System.out.println(endTime + ":" + endTime / 1000000);
        }

        Long tse = System.nanoTime() - tst;
        System.out.println("总计:" + tse + ":" + tse / 1000000);
    }

}
