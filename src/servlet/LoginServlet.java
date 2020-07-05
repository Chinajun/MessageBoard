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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = ConnectionUtil.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(username);
                user.setPassword(password);
                user.setRealName(resultSet.getString("real_name"));
                user.setPhone(resultSet.getString("phone"));
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }
        }catch (Exception e){
            System.out.println("登陆失败");
            request.setAttribute("msg","登陆失败，用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            e.printStackTrace();
        }finally {
            ConnectionUtil.release(resultSet,preparedStatement,connection);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
