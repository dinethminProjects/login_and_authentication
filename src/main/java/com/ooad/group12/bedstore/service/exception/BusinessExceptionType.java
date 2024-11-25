package com.ooad.group12.bedstore.service.exception;

public enum BusinessExceptionType {

    BUSINESS(1000, "Business Exception"),
    FILE_NOT_CREATE(1001, "File Not Create"),
    FILE_NOT_UPLOAD(1002, "File Not Upload"),
    FILE_NOT_FOUND(1003, "File Not Found"),
    PROCESS_NOT_FOUND(1004, "Process Not Found"),
    NOT_FOUND(1005, "Not Found"),
    USER_DISABLED(1006, "User Disabled"),
    USER_NOT_FOUND(1006, "User Not Found");


    private final int code;
    private final String message;

    BusinessExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
