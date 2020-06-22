package com.cyj;

import java.io.IOException;

public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 接收数据:
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("admin")&&password.equals("123456")){
            request.getSession().setAttribute("username", username);
//            session.setAttribute("name",username);
            response.sendRedirect("/hello/index.jsp");
        }else {
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
