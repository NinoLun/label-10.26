package com.score.api;

/**
 * ccz
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ccz
 * @since 2015-12-12 18:22
 */
@Controller
@EnableWebMvc
@SpringBootApplication
public class App extends WebMvcConfigurerAdapter {


//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(App.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
