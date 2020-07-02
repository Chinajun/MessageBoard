package servlet;

import service.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 消息列表Servlet
 */
//@WebServlet(name = "msgListServlet")
public class MsgListServlet extends HttpServlet {
    private MsgService msgService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        int page = 1;
        if(pageStr!=null&&"".equals(pageStr)){
            page = Integer.parseInt(pageStr);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        msgService = null;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        msgService = new MsgService();
    }
}
