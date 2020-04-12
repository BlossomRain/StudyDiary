package com.github.ssm.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/11 0011
 * @Description:一个通用的返回类
 */
public class Msg {
    //状态码
    private int code;
    //提示信息
    private String msg;
    //返回给用户的数据
    private Map<String, Object> data = new HashMap<>();

    public static Msg successed() {
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMsg("success");
        return msg;
    }
    public static Msg failed() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("failed");
        return msg;
    }

    public Msg add(String key,Object value){
        this.getData().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
