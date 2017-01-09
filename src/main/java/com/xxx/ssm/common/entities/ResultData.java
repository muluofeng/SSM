package com.xxx.ssm.common.entities;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ResultData<T> {

    private Boolean success = true;
    private String code;
    private String message = "";
    private T data;

    public ResultData(){

    }

    public ResultData(Boolean success,String message){
        this.success = success;
        this.message = message;
    }

    public ResultData(Boolean success,String message,T obj){
        this.success = success;
        this.message = message;
        this.data  = obj;
    }

    public Boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
