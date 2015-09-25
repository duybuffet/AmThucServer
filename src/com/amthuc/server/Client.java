package com.amthuc.server;

import com.amthuc.model.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

import com.google.gson.Gson;
import com.amthuc.view.ServerFrame;

public class Client extends Thread {

    private Socket client;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private onMessageReceived mMessageListener;
    private ServerFrame server;
    private User user;
    private UUID uuid;

    public Client(ServerFrame server, Socket socket, onMessageReceived listener,
            UUID uuid) {
        this.server = server;
        this.client = socket;
        this.mMessageListener = listener;
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void run() {
        try {
            Gson gson = new Gson();
            ois = new ObjectInputStream(client.getInputStream());
            oos = new ObjectOutputStream(client.getOutputStream());
            sendMessage(new Message(1, "SUCCESS"));
            while (true) {
                String a = (String) ois.readObject();
                if (a != null) {
                    mMessageListener.MessageReceived(a, this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.server.removeDisconnectedClient(this);
            this.stop();
        }
    }

    public void sendMessage(Message msg) {
        try {
            Gson gson = new Gson();
            System.out.println("Gửi dữ liệu đến client: " + gson.toJson(msg));
            oos.writeObject(gson.toJson(msg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface onMessageReceived {

        public void MessageReceived(String msg, Client uid);
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
