package com.amthuc.utils;

public class GLOBAL {

    public static class TO_CLIENT {

        public static final int CONNECT = 1;
        public static final int LOGIN = 2;
        public static final int SIGNUP = 3;
        public static final int UPDATE_USERS = 4;
        public static final int CHAT = 5;
        public static final int RECEIVED_CHAT_MESSAGE = 6;

    }

    public static class FROM_CLIENT {

        public static final int CONNECT = 1;
        public static final int LOGIN = 2;
        public static final int SIGNUP = 3;
        public static final int LOGOUT = 4;
        public static final int CHAT = 5;
    }
    
    public static class AREA {
        public static final int FLOOR_1 = 1;
        public static final int FLOOR_2 = 2;
        public static final int FLOOR_3 = 3;
    }
    
    public static class TABLE_TYPE {
        public static final int TABLE_2 = 2;
        public static final int TABLE_4 = 4;
        public static final int TABLE_8 = 8;
    }
}
