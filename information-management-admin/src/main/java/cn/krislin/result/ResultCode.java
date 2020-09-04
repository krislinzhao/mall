package cn.krislin.result;

/**
 * @Package cn.krislin.result
 * @ClassName ResultCode
 * @Description TODO
 * @Date 2020/9/2 19:38
 * @Author krislin
 * @Version V1.0
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}