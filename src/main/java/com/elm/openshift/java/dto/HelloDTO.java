package com.elm.openshift.java.dto;

import java.io.Serializable;

public class HelloDTO implements Serializable {
private String message;

    public HelloDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
