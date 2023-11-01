package com.example.treetest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//返回状态码
    private String msg;//返回状态描述信息
    private Object data; //返回数据

    //无数据返回响应
    public static Result success()
    {
        return new Result(1,"success",null);
    }

    public static Result success(Object data)
    {
        return new Result(1,"success",data);
    }

    public static Result error(String msg)
    {
        return new Result(0,msg,null);
    }
}
