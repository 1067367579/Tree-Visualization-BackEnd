package com.example.treetest.exception;

import com.example.treetest.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//全局异常处理类
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception ex)
    {
        ex.printStackTrace();
        return Result.error("出现异常");
    }
}
