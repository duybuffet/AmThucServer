/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.view;

import com.amthuc.dao.CategoryDAO;
import com.amthuc.dao.DishDAO;
import com.amthuc.dao.OrderDAO;
import com.amthuc.dao.TableDAO;
import com.amthuc.dao.UserDAO;
import com.amthuc.model.User;
import com.amthuc.server.Client;
import com.amthuc.server.Message;
import com.amthuc.server.Server;
import com.amthuc.utils.GLOBAL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

/**
 *
 * @author Pia
 */
public class ServerFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public ServerFrame() {
        initComponents();
        menuPanel = new MenuPanel(this);
        try {
            myServer = new ServerSocket(port);

            // Fake danh sách người dung
            for (int i = 1; i <= 5; i++) {
                User user = new User(i, "Player0" + i, "123456", 1, 1);
                this.arrUsers.add(user);
            }
            System.out.print("Server is running ... ");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int port = 2015;
    private ServerSocket myServer;
    private ArrayList<Client> arrClients = new ArrayList<Client>();
    private ArrayList<User> arrUsers = new ArrayList<User>();
    private UserDAO userDao = new UserDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private DishDAO dishDAO = new DishDAO();
    private TableDAO tableDAO = new TableDAO();
    private OrderDAO orderDAO = new OrderDAO();
    

    public void listening() throws NullPointerException, IOException {
        while (true) {
            Socket socket = myServer.accept();
            System.out.println(socket.getInetAddress() + " connected");
            UUID uuid = UUID.randomUUID();
            Client client = new Client(this, socket, new ProcessMessage(),
                    uuid);
            client.start();
            arrClients.add(client);
        }
    }

    public void ProcessMessage(String msg, Client client) throws SQLException, ClassNotFoundException {
        System.out.println("Dữ liệu từ client : ");
        System.out.println(msg);
        Gson gson = new GsonBuilder().create();
        Message message = gson.fromJson(msg, Message.class);
        switch (message.getMsgID()) {
            case GLOBAL.FROM_CLIENT.CONNECT:
                confirmConnection(message, client);
                break;
            case GLOBAL.FROM_CLIENT.LOGIN:
                checkLogin(message, client);
                updatePlayersList();
                break;

            case GLOBAL.FROM_CLIENT.LOGOUT:
                doLogout(message, client);
                updatePlayersList();
                break;
            case GLOBAL.FROM_CLIENT.CHAT:
                sendChatMessage(message, client);
                break;
            
            case GLOBAL.FROM_CLIENT.LIST_CATEGORY:
                sendListCategory(message, client);
                break;
            
            case GLOBAL.FROM_CLIENT.LOAD_TABLES:
                sendListTable(message, client);
                break;
                
            case GLOBAL.FROM_CLIENT.ADD_ORDER:
                addOrder(message, client);
                break;
        }
    }

    public void sendChatMessage(Message message, Client client) {
        try {
            System.out.println(message.getUser().getUsername() + " Gửi tin nhắn đến người chơi "
                    + message.getTarget().getUsername());
            for (Client cl : arrClients) {
                if (cl.getUser().getUsername().equals(message.getTarget().getUsername())) {
                    message.setMsgID(GLOBAL.TO_CLIENT.RECEIVED_CHAT_MESSAGE);
                    cl.sendMessage(message);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkLogin(Message msg, Client client) throws SQLException, ClassNotFoundException {
        Message rs = new Message();
        User user = userDao.login(msg.getUser());
        rs.setMsgID(GLOBAL.TO_CLIENT.LOGIN);
        if (user != null) {
            rs.setMsg("SUCCESS");
            user.setStatus(1);
            user.setPassword("");
            rs.setUser(user);
            client.setUser(user);
            this.arrUsers.add(user);
            System.out.println("Them nguoi choi " + arrUsers.size());
        } else {
            rs.setMsg("FAIL");
            rs.setUser(user);
        }
        sendMessageToClient(rs, client);
    }

    public void doLogout(Message msg, Client client) {
        System.out.println("Người chơi đăng xuất");
        System.out.println(client.getUser().toString());
        for (User user : arrUsers) {
            if (user.getUsername().equals(client.getUser().getUsername())) {
                arrUsers.remove(user);
                break;
            }
        }
    }

    public void removeDisconnectedClient(Client client) {
        System.out.println("Disconneted " + client.getClient().getInetAddress()
                + " - " + client.getClient().getPort());
        for (User user : arrUsers) {
            if (user.getUsername().equals(client.getUser().getUsername())) {
                arrUsers.remove(user);
                break;
            }
        }
        this.arrClients.remove(client);
        updatePlayersList();
    }

    public void updatePlayersList() {
        System.out.println("Cập nhật danh sách người chơi ( "
                + arrUsers.size() + " ) : ");
        for (User player : arrUsers) {
            System.out.println(" ► " + player.getId() + " - "
                    + player.getUsername());
        }
        System.out.println("Cập nhật số kết nối ( " + arrClients.size()
                + ") : ");
        for (Client client : arrClients) {
            System.out.println(" ► " + client.getClient().getInetAddress()
                    + " - " + client.getClient().getPort());
            Message msg = new Message();
            msg.setArrUsers(arrUsers);
            msg.setMsgID(GLOBAL.TO_CLIENT.UPDATE_USERS);
            sendMessageToClient(msg, client);
        }
    }

    public void confirmConnection(Message msg, Client client) {
        sendMessageToClient(new Message(GLOBAL.TO_CLIENT.CONNECT, "SUCCESS"),
                client);
    }

    public void sendMessageToClient(Message msg, Client client) {
        client.sendMessage(msg);
    }

    private void sendListCategory(Message message, Client client) throws ClassNotFoundException, SQLException {
        Message mes = new Message();
        mes.setMsgID(GLOBAL.TO_CLIENT.LIST_CATEGORY);
        mes.setArrCategories(categoryDAO.getAll());
        sendMessageToClient(mes, client);
    }

    private void sendListTable(Message message, Client client) throws ClassNotFoundException, SQLException {
        Message mes = new Message();
        mes.setMsgID(GLOBAL.TO_CLIENT.LOAD_TABLES);
        mes.setArrTables(tableDAO.getAll());
        sendMessageToClient(mes, client);
    }

    private void addOrder(Message message, Client client) {
        Message mes = new Message();
        mes.setMsgID(GLOBAL.TO_CLIENT.ADD_ORDER);
        try {
            orderDAO.insert(message.getOrder());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            mes.setMsg("FAIL");
        } catch (SQLException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            mes.setMsg("FAIL");
        } finally {
            sendMessageToClient(mes, client);
        }                
    }

    public class ProcessMessage implements Client.onMessageReceived {

        public void MessageReceived(String msg, Client uuid) {
            try {
                ProcessMessage(msg, uuid);
            } catch (SQLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainSplitPane = new javax.swing.JSplitPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        mainSplitPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        try {
//            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            ServerFrame server = null;
            server = new ServerFrame();
            server.setVisible(true);
            server.setDefaultCloseOperation(EXIT_ON_CLOSE);
            server.setResizable(false);
            server.setLocationRelativeTo(null);
            server.listening();
        } catch (NullPointerException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                public void run() {
//                    
//                }
//            });
        //</editor-fold>
        //</editor-fold>
    }

    public JSplitPane getMainSplitPane() {
        return mainSplitPane;
    }

    public void setMainSplitPane(JSplitPane mainSplitPane) {
        this.mainSplitPane = mainSplitPane;
    }

    private MenuPanel menuPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane mainSplitPane;
    // End of variables declaration//GEN-END:variables
}
