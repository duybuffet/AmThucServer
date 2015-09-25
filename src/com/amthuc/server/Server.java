/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.server;

import com.amthuc.dao.UserDAO;
import com.amthuc.model.User;
import com.amthuc.utils.GLOBAL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pia
 */
public class Server {

//    private int port = 2015;
//    private ServerSocket myServer;
//    private ArrayList<Client> arrClients = new ArrayList<Client>();
//    private ArrayList<User> arrUsers = new ArrayList<User>();
//    private UserDAO userDao = new UserDAO();
//
//    public Server() {
//        try {
//            myServer = new ServerSocket(port);
//
//            // Fake danh sách người dung
//            for (int i = 1; i <= 5; i++) {
//                User user = new User(i, "Player0" + i, "123456", 1, 1);
//                this.arrUsers.add(user);
//            }
//            System.out.print("Server is running ... ");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void listening() throws NullPointerException, IOException {
//        while (true) {
//            Socket socket = myServer.accept();
//            System.out.println(socket.getInetAddress() + " connected");
//            UUID uuid = UUID.randomUUID();
//            Client client = new Client(this, socket, new ProcessMessage(),
//                    uuid);
//            client.start();
//            arrClients.add(client);
//        }
//    }
//
//    public void ProcessMessage(String msg, Client client) throws SQLException, ClassNotFoundException {
//        System.out.println("Dữ liệu từ client : ");
//        System.out.println(msg);
//        Gson gson = new GsonBuilder().create();
//        Message message = gson.fromJson(msg, Message.class);
//        switch (message.getMsgID()) {
//            case GLOBAL.FROM_CLIENT.CONNECT:
//                confirmConnection(message, client);
//                break;
//            case GLOBAL.FROM_CLIENT.LOGIN:
//                checkLogin(message, client);
//                updatePlayersList();
//                break;
//
//            case GLOBAL.FROM_CLIENT.LOGOUT:
//                doLogout(message, client);
//                updatePlayersList();
//                break;
//            case GLOBAL.FROM_CLIENT.CHAT:
//                sendChatMessage(message, client);
//                break;
//
//        }
//    }
//
//    public void sendChatMessage(Message message, Client client) {
//        try {
//            System.out.println(message.getUser().getUsername() + " Gửi tin nhắn đến người chơi "
//                    + message.getTarget().getUsername());
//            for (Client cl : arrClients) {
//                if (cl.getUser().getUsername().equals(message.getTarget().getUsername())) {
//                    message.setMsgID(GLOBAL.TO_CLIENT.RECEIVED_CHAT_MESSAGE);
//                    cl.sendMessage(message);
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void checkLogin(Message msg, Client client) throws SQLException, ClassNotFoundException {
//        Message rs = new Message();
//        User user = userDao.login(msg.getUser());        
//        rs.setMsgID(GLOBAL.TO_CLIENT.LOGIN);
//        if (user != null) {
//            rs.setMsg("SUCCESS");
//            user.setStatus(1);
//            user.setPassword("");
//            rs.setUser(user);
//            client.setUser(user);
//            this.arrUsers.add(user);
//            System.out.println("Them nguoi choi " + arrUsers.size());
//        } else {
//            rs.setMsg("FAIL");
//            rs.setUser(user);
//        }
//        sendMessageToClient(rs, client);
//    }
//
//    public void doLogout(Message msg, Client client) {
//        System.out.println("Người chơi đăng xuất");
//        System.out.println(client.getUser().toString());
//        for (User user : arrUsers) {
//            if (user.getUsername().equals(client.getUser().getUsername())) {
//                arrUsers.remove(user);
//                break;
//            }
//        }
//    }
//
//    public void removeDisconnectedClient(Client client) {
//        System.out.println("Disconneted " + client.getClient().getInetAddress()
//                + " - " + client.getClient().getPort());
//        for (User user : arrUsers) {
//            if (user.getUsername().equals(client.getUser().getUsername())) {
//                arrUsers.remove(user);
//                break;
//            }
//        }
//        this.arrClients.remove(client);
//        updatePlayersList();
//    }
//
//    public void updatePlayersList() {
//        System.out.println("Cập nhật danh sách người chơi ( "
//                + arrUsers.size() + " ) : ");
//        for (User player : arrUsers) {
//            System.out.println(" ► " + player.getId() + " - "
//                    + player.getUsername());
//        }
//        System.out.println("Cập nhật số kết nối ( " + arrClients.size()
//                + ") : ");
//        for (Client client : arrClients) {
//            System.out.println(" ► " + client.getClient().getInetAddress()
//                    + " - " + client.getClient().getPort());
//            Message msg = new Message();
//            msg.setArrUsers(arrUsers);
//            msg.setMsgID(GLOBAL.TO_CLIENT.UPDATE_USERS);
//            sendMessageToClient(msg, client);
//        }
//    }
//
//    public void confirmConnection(Message msg, Client client) {
//        sendMessageToClient(new Message(GLOBAL.TO_CLIENT.CONNECT, "SUCCESS"),
//                client);
//    }
//
//    public void sendMessageToClient(Message msg, Client client) {
//        client.sendMessage(msg);
//    }
//
//    public class ProcessMessage implements Client.onMessageReceived {
//
//        public void MessageReceived(String msg, Client uuid) {
//            try {
//                ProcessMessage(msg, uuid);
//            } catch (SQLException ex) {
//                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public static void main(String arsg[]) {
//        try {
//            Server server = new Server();
//            server.listening();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.exit(0);
//        }
//    }
}
