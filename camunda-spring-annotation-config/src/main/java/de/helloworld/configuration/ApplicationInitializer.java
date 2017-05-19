package de.helloworld.configuration;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

  private final static Logger LOG = Logger.getLogger(ApplicationInitializer.class.getName());

  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    LOG.info("initializing application");

    // Create the 'root' Spring application context
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(PropertyPlaceholderConfigurerConfig.class);
    ctx.register(DatasourceConfig.class);
    ctx.register(FlyWayEntityManagerFactory.class);
    ctx.register(CamundaConfig.class);
    ctx.register(SpringConfig.class);

    // Manage the lifecycle of the root application context
    servletContext.addListener(new ContextLoaderListener(ctx));
    servletContext.addListener(new RequestContextListener());


    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("Dispatcher", dispatcherServlet);
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");




    // http://stackoverflow.com/questions/16707152/spring-mvc-dispatcherservlet-by-annotations
    // http://docs.spring.io/autorepo/docs/spring-framework/3.1.x/javadoc-api/org/springframework/web/WebApplicationInitializer.html

    // http://stackoverflow.com/questions/2769467/what-is-dispatcher-servlet-in-spring

  }

}
