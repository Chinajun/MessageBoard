package servlet;

import msg.ConnectionUtil;
import msg.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String phone = request.getParameter("phone");
        Connection connection = ConnectionUtil.getConnection();
        String sql = "insert user set username = ? , password = ? , real_name = ? , phone = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,realName);
            preparedStatement.setString(4,phone);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                //TODO
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
