package test.web.servlet;

import test.dao.UserDao;
import test.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置格式utf-8
        req.setCharacterEncoding("utf-8");
        //创建loginUser对象
        User loginUser = new User();
        //获取请求参数中的username，password
        loginUser.setUsername(req.getParameter("username"));
        loginUser.setPassword(req.getParameter("password"));
        //创建UserDao对象，使用login的方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //判断返回的user是否为null
        if(user != null){
            //不为null，跳转到successServlet
            //存储req数据，实现共享
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }else{
            //为null查询失败，跳转到failServlet
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }

    }
}
