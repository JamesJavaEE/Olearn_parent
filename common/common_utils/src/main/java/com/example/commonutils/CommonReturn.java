package com.example.commonutils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于统一格式的结果返回
 */
@Data
public class CommonReturn {
    @ApiModelProperty("success")
    private Boolean success;

    @ApiModelProperty("return code")
    private Integer code;

    @ApiModelProperty("return message")
    private String message;

    @ApiModelProperty("return data")
    private Map<String ,Object> data = new HashMap<String ,Object>();

    private CommonReturn() { }

    //成功则调用
    public static CommonReturn success(){
        CommonReturn r = new CommonReturn();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("success");
        return r;
    }

    //成功则调用
    public static CommonReturn error(){
        CommonReturn r = new CommonReturn();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("error");
        return r;
    }

    //实现链式编程 CommonReturn.success().data();

    public CommonReturn success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public CommonReturn message(String message) {
        this.setMessage(message);
        return this;
    }

    public CommonReturn code(Integer code) {
        this.setCode(code);
        return this;
    }

    public CommonReturn data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public CommonReturn data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
