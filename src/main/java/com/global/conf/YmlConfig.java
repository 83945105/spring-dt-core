package com.global.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * yml配置
 * Created by 白超 on 2018/4/8.
 */
@Configuration
public class YmlConfig {

    /**
     * 当前模式
     */
    public static String ACTIVE;

    @Value("${spring.profiles.active}")
    public void setActive(String active) {
        ACTIVE = active;
    }

    /**
     * 文件上传地址
     */
    public static String UPLOAD_PATH;

    @Value("${web.upload-path}")
    public void setUploadPath(String uploadPath) {
        UPLOAD_PATH = uploadPath;
    }
}
