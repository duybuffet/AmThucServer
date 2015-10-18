package com.amthuc.utils;

import java.util.ArrayList;
import java.util.List;

public class GLOBAL {

    public static class TO_CLIENT {

        public static final int CONNECT = 1;
        public static final int LOGIN = 2;
        public static final int SIGNUP = 3;
        public static final int UPDATE_USERS = 4;
        public static final int CHAT = 5;
        public static final int RECEIVED_CHAT_MESSAGE = 6;
        public static final int LIST_CATEGORY = 7;
        public static final int ADD_ORDER = 8;
        public static final int SHOW_ORDERS = 9;
        public static final int LOAD_TABLES = 10;
        public static final int RELOAD_TABLES = 11;
    }

    public static class FROM_CLIENT {

        public static final int CONNECT = 1;
        public static final int LOGIN = 2;
        public static final int SIGNUP = 3;
        public static final int LOGOUT = 4;
        public static final int CHAT = 5;
        public static final int LIST_CATEGORY = 6;
        public static final int ADD_ORDER = 7;
        public static final int SHOW_ORDERS = 8;
        public static final int LOAD_TABLES = 9;
        public static final int RELOAD_TABLES = 10;
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
    
    public static class DISH_UNIT {
        public static final String DISH = "Đĩa";
        public static final String CUP = "Cốc";
        public static final String SMT = "Phần Ăn";
        public static final String[] DISH_UNIT_DISPLAY = {DISH, CUP, SMT};        
    }
    
    public static class USER_LEVEL {
        public static final int ADMIN = 2;
        public static final int CHEF = 1;
        public static final int WAITER = 0;
        public static final String[] USER_LEVEL_DISPLAY = {"Bồi bàn", "Bếp", "Quản trị"};        
    }
        
}
