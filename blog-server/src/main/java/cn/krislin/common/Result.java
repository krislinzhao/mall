package cn.krislin.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package cn.krislin.common
 * @ClassName Result
 * @Description 控制层通用结果集
 * @Date 20/7/15 8:53
 * @Author krislin
 * @Version V1.0
 */
@Data
public class Result implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public static Result success(String msg, Object data) {
        return success(200, msg, data);
    }


    public static Result success(String msg) {
        return success(200, msg, null);
    }

    /**
     * 抽取结果集，提高代码重用性
     *
     * @param data
     * @return success(code, msg, data)
     */
    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }

    /**
     * 抽取结果集,提搞代码重用性
     *
     * @param msg
     * @return error(code, msg, null)
     */
    public static Result error(String msg) {
        return error(400, msg, null);
    }

    /**
     * 返回成功获取的结果集
     *
     * @param code
     * @param msg
     * @param data
     * @return result
     */
    public static Result success(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 返回错误信息结果集
     *
     * @param code
     * @param msg
     * @param data
     * @return result
     */
    public static Result error(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
