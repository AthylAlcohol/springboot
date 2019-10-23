package com.qf.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @NotNull(message = "id不能为空")
    private int id;
    @NotNull(message = "用户名不能为空")
    private String name;
    private String password;

    @Email(message = "邮箱格式错误")
    private String email;

    private String phone;
    /*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")*/
    private Date date;


}
