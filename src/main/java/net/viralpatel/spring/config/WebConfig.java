package net.viralpatel.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("net.viralpatel.spring")
public class WebConfig implements WebMvcConfigurer {
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //by default prefix = "/WEB-INF/" and  suffix = ".jsp"
        registry.jsp().prefix("/WEB-INF/classes/views/");
    }
}
