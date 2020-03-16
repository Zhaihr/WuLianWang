package test.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.domain.User;
import test.utils.JDBCUtils;

import java.util.List;

/**
 * 操作数据库中Userinfo表的类
 */
public class UserDao {
    //声明JDBCTemplate，让所有方法可以共用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户的全部信息
     */
    public User login(User loginUser){
        try {//编写sql语句，查询用户名和密码
            String sql = "select * from userinfo where username = ? and password = ?";
            //调用query方法，返回user对象
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
