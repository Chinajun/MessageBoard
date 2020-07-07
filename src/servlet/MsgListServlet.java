package servlet;

import msg.ConnectionUtil;
import msg.Msg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息列表Servlet
 */
public class MsgListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        String sql = "select * from message";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Msg> list = new ArrayList<>();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Msg(resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getTime("create_time")));
            }
            req.setAttribute("list",list);
            req.getRequestDispatcher("/message.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
