package com.qf.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
/*把此类注入到spring容器中*/
@Component
@ConfigurationProperties(prefix = "resource")
public class Resource {


    private String imagesServer;

    private String emailServer;

    public String getImagesServer() {
        return imagesServer;
    }

    public void setImagesServer(String imagesServer) {
        this.imagesServer = imagesServer;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }
}
