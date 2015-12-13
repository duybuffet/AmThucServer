package com.amthuc.server;

import com.amthuc.model.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

import com.google.gson.Gson;
import com.amthuc.view.ServerFrame;

public class Client extends Thread {
    // socket để lắng nghe và chấp nhận kết nối từ client
    private Socket client;
    // Mở luồng để nhận dữ liệu
    private ObjectInputStream ois;
    // Mở luồng để gửi dữ liệu
    private ObjectOutputStream oos;
    // interface dùng để bắt sự kiện nhận được message, khi sử dụng sẽ phải cài đặt lại hàm này trong ServerFrame
    private onMessageReceived mMessageListener;
    private ServerFrame server;
    // dùng để biết client đang kết nối là user nào
    private User user;
    // uuid viết tắt của universal unique identifier, là định danh duy nhát, dùng để phân biệt các client với nhau
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
    
    /*
        khi kế thừa từ threads, sẽ phải viết lại hàm này, muốn threads hoạt động thì chạy hàm start.
        Ví dụ: Client client = new Client(.. , ..);
               client.start();
        
    */
    public void run() {
        try {
            Gson gson = new Gson();
            // khởi tạo
            ois = new ObjectInputStream(client.getInputStream());
            oos = new ObjectOutputStream(client.getOutputStream());
            // khi client lần đầu kết nối tới, server sẽ gửi tín hiệu báo đã kết nối thành công
            sendMessage(new Message(1, "SUCCESS"));
            // vòng lặp vô hạn để luôn lắng nghe các sự kiện từ client
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
    
    /*
        hàm này server dùng để gửi dữ liệu tới client, dữ liệu sẽ được định dạng kiểu Json để android có thể đọc dc dễ dàng
    */
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
