package com;

import com.dt.core.data.MainTableData;
import com.dt.core.test.AdminModel;

/**
 * Created by 白超 on 2018/6/24.
 */
public class Test {

    public static void main(String[] args) {
        MainTableData data1 = new MainTableData(AdminModel.class);
        MainTableData data2 = new MainTableData(AdminModel.class);
        System.out.println(data1 == data2);
        System.out.println(data1.equals(data2));
    }

}
