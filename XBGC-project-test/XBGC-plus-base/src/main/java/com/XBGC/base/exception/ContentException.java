package com.XBGC.base.exception;

public class ContentException extends RuntimeException {
    private String errCode;
    private String errMessage;

    public ContentException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public ContentException(String errCode) {

    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
