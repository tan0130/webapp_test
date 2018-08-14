package dbconnection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * create by 1311230692@qq.com on 2018/8/14 14:13
 * 日志写入数据库时需要连接数据库
 **/
public class ConnectionFactory {
    public static Connection getDatabaseConnection() throws SQLException {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/manage?characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("liuke666");
        return ds.getConnection();
    }
}
