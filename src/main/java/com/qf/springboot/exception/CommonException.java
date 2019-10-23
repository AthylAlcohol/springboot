package com.qf.springboot.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.springboot.entity.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanYouGEn
 * @Date 2019/10/22
 */
@Slf4j
@ControllerAdvice
public class CommonException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handleException(Exception e){
        log.error(e.getMessage());
        return new ResultBean("500","当前服务器繁忙，请稍后再试");
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException ex) throws JsonProcessingException {
        //1.此处先获取BindingResult
        BindingResult bindingResult = ex.getBindingResult();
        //2.获取错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        //3.组装异常信息
        Map<String,String> message = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            message.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        //4.将map转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(message);
        //5.返回错误信息
        return new ResultBean("400",json);
    }
}
