package com.chatroom.utils;

import java.util.Properties;

public class JDBCUtil {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String passWord;
    static {
        Properties properties = CommUtils.loadProperties("db.properties");
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        passWord = properties.getProperty("password");
        //1.加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("加载驱动出错");
        }
        //2.关闭
        public static void getProperties(){

        }
    }
}
