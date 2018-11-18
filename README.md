# SpringMvcRest
This is an example of spring mvc rest service

# Java Config (use Java Config instead of web.xml)

## 1. the first method, implement Spring’s WebApplicationInitializer
```sh
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
```
## 2. the second method, extend AbstractAnnotationConfigDispatcherServletInitializer
```sh
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/springrest/*" };
    }
}
```
# use Jackson return response with json format
add jackson dependency as below in pom.xml
```jshelllanguage
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.6</version>
</dependency>
```
