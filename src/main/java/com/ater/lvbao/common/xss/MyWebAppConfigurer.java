package com.ater.lvbao.common.xss;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by haley on 2018/1/5.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
              /*  .allowedOrigins("http://192.168.1.97")
                .allowedMethods("GET", "POST")
                .allowCredentials(false).maxAge(3600)*/;
    }
}
