package com.qf.springboot.entity;

/**
 * @author PanYouGEn
 * @Date 2019/10/22
 */
public class ResultBean<T> {
    private String resCode;
    private T data;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultBean(String resCode, T data) {
        this.resCode = resCode;
        this.data = data;
    }
}
