package com.dt.core.exception;

/**
 * Created by 白超 on 2018/6/28.
 */
public class TableDataException extends DtException {

    public TableDataException() {
    }

    public TableDataException(String message) {
        super(message);
    }

    public TableDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableDataException(Throwable cause) {
        super(cause);
    }

    public TableDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
