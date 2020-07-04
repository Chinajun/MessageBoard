package service;

import dao.MsgDAO;
import msg.Msg;

import java.util.List;

public class MsgService {
    private MsgDAO msgDAO;
    public MsgService(){
        msgDAO = new MsgDAO();
    }


}
