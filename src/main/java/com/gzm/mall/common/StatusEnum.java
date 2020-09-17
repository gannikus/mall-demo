package com.gzm.mall.common;

/**
 * description
 *
 * @author 甘之萌  2020/09/16 14:55
 */
public enum StatusEnum{
    NORMAL(1, "正常"),
    DISABLED(2, "禁止");
    private long code;
    private String message;

     StatusEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
