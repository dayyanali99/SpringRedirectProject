package org.springproject.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebServletConfiguration implements WebApplicationInitializer
{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        try (AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext())
        {
            webContext.register(SpringConfig.class);
            webContext.setServletContext(servletContext);
            ServletRegistration.Dynamic servlet =
                    servletContext.addServlet("dispatcher",new DispatcherServlet(webContext));
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/");
        }
    }
}
