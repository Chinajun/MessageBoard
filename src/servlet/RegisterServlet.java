package servlet;

import msg.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String phone = request.getParameter("phone");
        if(username.equals("")||password.equals("")||realName.equals("")||phone.equals("")){
            System.out.println("请完善个人信息");
        }else{
            Connection connection = null;
            String sql = "insert user (username,password,real_name,phone) values ('"+username+"','"+password+"','"+realName+"','"+phone+"')";
            PreparedStatement preparedStatement = null;
            try{
                connection = ConnectionUtil.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                int n = preparedStatement.executeUpdate(sql);
                if(n>0){
                    request.getRequestDispatcher("/registerSuccess.jsp").forward(request,response);
                }else{
                    System.out.println("注册失败，用户名已被注册");
                    request.setAttribute("msg","注册失败，用户名已被注册");
                    request.getRequestDispatcher("/register.jsp").forward(request,response);
                }
            }catch (Exception e){
                System.out.println("注册失败");
                request.setAttribute("msg","注册失败，用户名已被注册");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
                e.printStackTrace();
            }finally {
                ConnectionUtil.release(preparedStatement,connection);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
