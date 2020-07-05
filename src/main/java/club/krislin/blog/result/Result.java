package club.krislin.blog.result;

/**
 * @Package club.krislin.blog.result
 * @ClassName Result
 * @Description TODO
 * @Date 20/6/22 17:00
 * @Author krislin
 * @Version V1.0
 */
public class Result {
    /**
     * 响应码
     */
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
