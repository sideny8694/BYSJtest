package com.XBGC.base.exception;
/**
 * @description xbgc在线项目异常类  用于继承 runtime异常
 * @author Mr.w
 * @date
 * @version 1.0
 */

public class XBGCPlusException extends RuntimeException {
    private String errMessage;

    public XBGCPlusException() {
        super();
    }

    public XBGCPlusException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public static void cast(CommonError commonError){
        throw new XBGCPlusException(commonError.getErrMessage());
    }
    public static void cast(String errMessage){
        throw new XBGCPlusException(errMessage);
    }


}
