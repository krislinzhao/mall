package cn.krislincommon.exception;


import cn.krislincommon.api.IErrorCode;
import lombok.Data;

/**
* 网关异常类
*/
@Data
public class GateWayException extends RuntimeException{

    private long code;

    private String message;

    public GateWayException(IErrorCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }
}
