package com.gihanz.configs;

public class TextConstrain {

    private TextConstrain() {
    }

    public static final String UUID = "UUID";

    // LOGS CONSTRAINS
    public static final String LOG_INSERT = "LOG_INSERT   UUID : {}";
    public static final String LOG_UPDATE = "UPDATE   UUID : {}";
    public static final String LOG_DELETE = "LOG_UPDATE   UUID : {}";
    public static final String LOG_SELECT_BY_ID = "LOG_SELECT_BY_ID   UUID : {}";
    public static final String LOG_SELECT_ALL = "LOG_SELECT_ALL   UUID : {}";

    // LOGS EXCEPTIONS
    public static final String EX_RECORD_NOT_FOUND = "Record Not Found";
    public static final String EX_BAD_REQUEST = "Bad Request";
    public static final String EX_INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String EX_NOT_IMPLEMENTED = "Not Implemented";
    public static final String EX_UNAUTHORIZED = "UNAUTHORIZED";
    //    EXCEPTION LOGS
    public static final String EX_RECORD_NOT_EXIST = "Record Not Exist : {}";

    public static final String LOGIN = "LOGIN";
    public static final String REFRESH = "REFRESH";
}
