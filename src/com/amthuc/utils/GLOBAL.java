package com.amthuc.utils;

import java.util.ArrayList;
import java.util.List;

public class GLOBAL {

    public static class TO_CLIENT {

        public static final int TIMEOUT = -1;
        public static final int CONNECT = 1;
        public static final int LOGIN = 2;
        public static final int SIGNUP = 3;
        public static final int UPDATE_USERS = 4;
        public static final int CHAT = 5;
        public static final int RECEIVED_CHAT_MESSAGE = 6;
        public static final int LIST_CATEGORY = 7;
        public static final int ADD_ORDER = 8;
        public static final int SHOW_ORDER = 9;
        public static final int LOAD_TABLES = 10;
        public static final int RELOAD_TABLES = 11;
        public static final int UPDATE_ORDER = 12;
        public static final int ADD_LINE_TO_ORDER = 13;
        public static final int UPDATE_LINE_OF_ORDER = 14;
        public static final int DELETE_LINE_OF_ORDER = 15;
        public static final int CANCEL_ORDER = 16;
        public static final int BILL = 17;
    }

    public static class FROM_CLIENT {

        public static final int CONNECT = 1;
        public static final int LOGIN = 2;
        public static final int SIGNUP = 3;
        public static final int LOGOUT = 4;
        public static final int CHAT = 5;
        public static final int LIST_CATEGORY = 6;
        public static final int ADD_ORDER = 7;
        public static final int SHOW_ORDER = 8;
        public static final int LOAD_TABLES = 9;
        public static final int RELOAD_TABLES = 10;
        public static final int UPDATE_ORDER = 11;
        public static final int ADD_LINE_TO_ORDER = 12;
        public static final int UPDATE_LINE_OF_ORDER = 13;
        public static final int DELETE_LINE_OF_ORDER = 14;
        public static final int CANCEL_ORDER = 15;
        public static final int BILL = 16;
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

    public static class ORDER_AND_TABLE_STATUS {

        public static final int TABLE_FREE = 0;
        public static final int NOT_YET_ORDER = 1;
        public static final int ORDERED = 2;
        public static final int ORDER_READY_TO_SERVED = 3;
        public static final int ORDER_SERVED = 4;
        public static final int ORDER_BILLED = 5;
        public static final int ORDER_CANCEL = 6;
        
        public static final String[] ORDER_DISPLAY = {"Bàn trống", "Chưa gọi món", 
                                "Đã gọi món", "Món sẵn sàng phục vụ", "Đã phục vụ", 
                                "Đã thanh toán", "Hủy"};
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
    
    public static class CONFIG {
        public static String SUCCESS = "SUCCESS";
        public static String FAIL = "FAIL";
    }
}
