package test.test;

import org.junit.Test;
import test.dao.UserDao;
import test.domain.User;

import javax.jws.soap.SOAPBinding;

/*
    测试用户UserDao类
 */
public class UserDaoTest {

    @Test
    public void testdao(){
        User loginuser = new User();
        loginuser.setUsername("zhaiheran");
        loginuser.setPassword("123456");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
