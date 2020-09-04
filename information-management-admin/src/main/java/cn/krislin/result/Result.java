package cn.krislin.result;

import lombok.Data;

/**
 * @Package cn.krislin.common
 * @ClassName Result
 * @Description 控制层通用结果集
 * @Date 20/7/15 8:53
 * @Author krislin
 * @Version V1.0
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        result = data;
    }
}
