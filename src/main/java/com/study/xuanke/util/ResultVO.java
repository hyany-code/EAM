package com.study.xuanke.util;
public class ResultVO<T> {

    private Integer flag = 0;//1代表失败

    private String msg;

    private String desc;

    private T result;

    public ResultVO(){

    }
    public ResultVO(Integer flag ,String msg,String desc,T result){
        super();
        this.flag = flag;
        this.desc = desc ;
        this.msg = msg;
        this.result = result;
    }
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}