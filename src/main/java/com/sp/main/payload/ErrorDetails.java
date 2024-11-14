package com.sp.main.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class ErrorDetails {
    private String message;
    private String request;
    private Date date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public ErrorDetails(String message, String request) {
        this.message = message;
        this.request = request;
    }
}
