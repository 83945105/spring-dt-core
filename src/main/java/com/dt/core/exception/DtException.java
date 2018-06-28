package com.dt.core.exception;

/**
 * Created by 白超 on 2018/6/28.
 */
public class DtException extends RuntimeException {

    public DtException() {
    }

    public DtException(String message) {
        super(message);
    }

    public DtException(String message, Throwable cause) {
        super(message, cause);
    }

    public DtException(Throwable cause) {
        super(cause);
    }

    public DtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
