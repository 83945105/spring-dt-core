package com.global.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * web配置
 * Created by 白超 on 2018-4-5.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Value("${web.cors.allow}")
    private String allow;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if ("true".equals(allow)) {
            //设置允许跨域的路径
            registry.addMapping("/**")
                    //设置允许跨域请求的域名
                    .allowedOrigins("*")
                    //是否允许证书 不再默认开启
                    .allowCredentials(true)
                    //设置允许的方法
                    .allowedMethods("*")
                    //跨域允许时间
                    .maxAge(3600);
        }
    }

    @Value("${web.upload-path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("file:" + uploadPath);
        super.addResourceHandlers(registry);
    }

    @Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }

}
