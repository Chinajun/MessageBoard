package servlet;

import msg.ConnectionUtil;
import msg.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = null;
        String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(username);
                user.setPassword(password);
                user.setRealName(resultSet.getString("real_name"));
                user.setPhone(resultSet.getString("phone"));
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else{
                System.out.println("登陆失败");
                request.setAttribute("msg","登陆失败，用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.release(resultSet,preparedStatement,connection);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
