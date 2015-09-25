package com.amthuc.server;

import com.amthuc.model.User;
import java.util.ArrayList;

public class Message {

    private int msgID;
    private String msg;
    private User user;
    private ArrayList<User> arrUsers;
    private User target;

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public Message() {
        super();
    }

    public Message(int msgID, ArrayList<User> arrUsers) {
        super();
        this.msgID = msgID;
        this.arrUsers = arrUsers;
    }

    public ArrayList<User> getArrUsers() {
        return arrUsers;
    }

    public void setArrUsers(ArrayList<User> arrUsers) {
        this.arrUsers = arrUsers;
    }

    public Message(int msgID, String msg, User user,
            ArrayList<User> arrUsers) {
        super();
        this.msgID = msgID;
        this.msg = msg;
        this.user = user;
        this.arrUsers = arrUsers;
    }

    public Message(int msgID, String msg, ArrayList<User> arrUsers) {
        super();
        this.msgID = msgID;
        this.msg = msg;
        this.arrUsers = arrUsers;
    }

    public Message(int msgID, String msg) {
        super();
        this.msgID = msgID;
        this.msg = msg;
    }

    public Message(int msgID, String msg, User user) {
        super();
        this.msgID = msgID;
        this.msg = msg;
        this.user = user;
    }

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
