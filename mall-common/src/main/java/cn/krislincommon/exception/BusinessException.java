package cn.krislincommon.exception;

/**
 * 业务异常
 **/
public class BusinessException extends Exception {

    public BusinessException(){super();}

    public BusinessException(String message) {
        super(message);
    }

}
