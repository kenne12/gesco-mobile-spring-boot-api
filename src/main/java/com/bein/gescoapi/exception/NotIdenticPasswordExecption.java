package com.bein.gescoapi.exception;

public class NotIdenticPasswordExecption extends RuntimeException {

    public NotIdenticPasswordExecption(String message) {
        super(message);
    }

    public NotIdenticPasswordExecption(String message, Exception e) {
        super(message, e);
    }

}
