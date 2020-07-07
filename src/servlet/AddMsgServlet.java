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

public class AddMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        if(username.equals("")||title.equals("")||content.equals("")){
            request.setAttribute("msg","发布失败，标题和内容不能为空");
            request.getRequestDispatcher("/addMsg.jsp").forward(request,response);
        }else{
            Connection connection = null;
            String sql = "insert message set title = '"+title+"' , content = '"+content+"' , username = '"+username+"';";
            PreparedStatement preparedStatement = null;
            try{
                connection = ConnectionUtil.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                int n = preparedStatement.executeUpdate();
                if(n>0){
                    System.out.println("发布成功");
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }else{
                    System.out.println("发布失败");
                }
            }catch (Exception e){
                System.out.println("出现错误");
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
