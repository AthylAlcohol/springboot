package com.qf.springboot.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
@Configuration
public class ListenerConfig {

    @Autowired
    private  MyListener myListener;

    @Bean
    public ServletListenerRegistrationBean getListenerBean(){
        ServletListenerRegistrationBean bean=new ServletListenerRegistrationBean();
        bean.setListener(myListener);
        return  bean;
    }
}
