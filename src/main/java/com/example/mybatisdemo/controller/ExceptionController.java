package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.base.BaseDTO;
import org.apache.shiro.authc.AccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    /**捕捉 CustomRealm 抛出的异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(AccountException.class)
    public BaseDTO handleShiroException(Exception ex) {
        return BaseDTO.failBaseDTO(ex.getMessage());
    }
}
