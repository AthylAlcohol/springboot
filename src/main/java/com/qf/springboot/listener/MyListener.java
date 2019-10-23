package com.qf.springboot.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
@Component
public class MyListener implements ServletRequestListener{


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyListener Destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyListener Initialized");
    }
}
