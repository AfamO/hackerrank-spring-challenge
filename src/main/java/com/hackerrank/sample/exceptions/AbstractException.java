package com.hackerrank.sample.exceptions;

public class AbstractException extends RuntimeException {
    private String code;
    private String message;

    public AbstractException(String code,String message){
        super(message);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
