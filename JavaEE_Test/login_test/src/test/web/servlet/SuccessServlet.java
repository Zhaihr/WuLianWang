package test.web.servlet;

import test.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response格式
        response.setContentType("text/html;charset=utf-8");
        //获取request中的user对象
        User user = (User)request.getAttribute("user");
        if(user != null){
            response.getWriter().write("登陆成功，" + user.getUsername() + "欢迎您！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
