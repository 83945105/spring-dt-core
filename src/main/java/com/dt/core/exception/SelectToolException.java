package com.dt.core.exception;

/**
 * Created by 白超 on 2018/6/28.
 */
public class SelectToolException extends DtException {

    public SelectToolException() {
    }

    public SelectToolException(String message) {
        super(message);
    }

    public SelectToolException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectToolException(Throwable cause) {
        super(cause);
    }

    public SelectToolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
