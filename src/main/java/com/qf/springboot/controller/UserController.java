package com.qf.springboot.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.springboot.entity.Resource;
import com.qf.springboot.entity.ResultBean;
import com.qf.springboot.entity.Student;
import com.qf.springboot.entity.User;
import com.qf.springboot.service.IUserService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
@Controller
@ResponseBody
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);



    @Autowired
    private  Resource resource;

    @RequestMapping("hello")
    public String hello(){
        return resource.getEmailServer();
    }

    @GetMapping("page/{pageIndex}")
    public String page(@PathVariable(value = "pageIndex") int pageIndex){
            return "pageIndex="+pageIndex;
    }

    @PostMapping("page/{pageIndex}")
    public String page1(@PathVariable(value = "pageIndex") int pageIndex){
        return "Post请求pageIndex="+pageIndex;
    }

    @GetMapping("show")
    public User showUser(){
        User user=new User(1,"zs","123","sdas@qq.com","13548741256",new Date());
        return user;
    }

    @GetMapping("getId/{id}")
    public String getById(@PathVariable(value = "id") int id){
        return userService.getById(id).toString();
    }

    @GetMapping("welcome")
    public String welcome(ModelMap modelMap){

        modelMap.put("username","zs");
        modelMap.put("student",new Student(2,"ls","125"));
        return "welcome";
    }

    /*@PostMapping("add")
    public ResultBean add(@Valid User user, BindingResult bindingResult) throws JsonProcessingException {
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors=bindingResult.getFieldErrors();
            Map<String,String> result=new HashMap<>();
            for(FieldError fieldError:fieldErrors){
                String message=fieldError.getDefaultMessage();
                String field=fieldError.getField();
                log.error("[{}],[{}]",field,message);
                result.put(field,message);
            }

            ObjectMapper objectMapper=new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            return new ResultBean("faild",json);

        }
        return new ResultBean("success","ok");
    }*/

    @PostMapping("add")
    public ResultBean add(@Valid User user )  {
        //AOP 业务逻辑分离 报错的异常放在Exception中
        //核心业务逻辑做数据的添加 非核心做数据的校验
        return new ResultBean("success","ok");
    }
}





