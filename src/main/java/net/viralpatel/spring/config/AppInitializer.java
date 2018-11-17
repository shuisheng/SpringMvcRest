package net.viralpatel.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 下面两种方案都可以
 */

/**
 * 方案1
 */
//public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[] { AppConfig.class };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/springrest" };
//    }
//}

/**
 * 方案2
 */
public class AppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        /**
         * the below statement must be necessary, otherwise servlet cannot work.
         * but no this line code in official website
         */
        context.setServletContext(servletContext);
        context.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/springrest/*");
    }
}
