package com.sjzxy.fwpt.util.codeAuto;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC连接数据库工具类
 */
@Slf4j
public class DBConnectionUtil {

    /**
     * 数据连接相关
     */
    private static final String URL = "jdbc:mysql://localhost:3306/fwpt?serverTimezone=GMT%2B8&characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";

    static {
        // 1、加载驱动
        try {
            Class.forName(DRIVER_CLASSNAME);
        } catch (ClassNotFoundException e) {
            //输出到日志文件中
            log.error(e.getMessage());
        }
    }

    /**
     * 返回一个Connection连接
     */
    static Connection getConnection() {
        Connection conn = null;
        // 2、连接数据库
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            //输出到日志文件中
            log.error(e.getMessage());
        }
        return conn;
    }

    /**
     * 关闭Connection，Statement连接
     */
    public static void close(Connection conn, Statement stmt) {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException e) {
            //输出到日志文件中
            log.error(e.getMessage());
        }
    }

    /**
     * 关闭Connection，Statement，ResultSet连接
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            close(conn, stmt);
            rs.close();
        } catch (SQLException e) {
            //输出到日志文件中
            log.error(e.getMessage());
        }
    }

}
