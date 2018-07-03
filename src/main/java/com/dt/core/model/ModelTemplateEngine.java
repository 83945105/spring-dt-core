package com.dt.core.model;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 白超 on 2018/7/3.
 */
public class ModelTemplateEngine {

    public static void main(String[] args) {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("templates/");
        resolver.setSuffix(".text");
        resolver.setCacheable(true);
        resolver.setTemplateMode(TemplateMode.TEXT);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        Context context = new Context();

        Map<String, String> setting = new HashMap<>();
        setting.put("packagePath", "com.huanet.bean");
        setting.put("TableAlias", "JurRole");
        setting.put("templateSuffix", "Model");

        context.setVariable("setting", setting);
        context.setVariable("array", new String[]{"1", "2", "3", "4", "5"});


        String str = templateEngine.process("model", context);
        System.out.println(str);


    }
}
