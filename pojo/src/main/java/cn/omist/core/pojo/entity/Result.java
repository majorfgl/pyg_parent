package cn.omist.core.pojo.entity;

import java.io.Serializable;

/**
 * @author Mr_Fan
 * @Date 2019/9/2 9:58
 */
public class Result implements Serializable {
    public Boolean success;
    public String message;

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
