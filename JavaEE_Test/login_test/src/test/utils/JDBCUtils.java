package test.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBCUtils工具类 使用Druid数据库连接池
 */
public class JDBCUtils {
    //定义数据库资源datasource
    private static DataSource dataSource;

    //静态代码块加载properties文件
    static{
        Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象connection
     * 抛出异常让使用者知道需要处理异常
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     *  获取数据库连接池资源datasource
     */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
