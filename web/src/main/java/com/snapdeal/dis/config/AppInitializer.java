package com.snapdeal.dis.config;

import com.snapdeal.dis.services.service.impl.StartupServiceImpl;
import com.snapdeal.dis.web.listener.DISContextListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return  null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };

    }

    public void onStartup(ServletContext servletContext) throws  ServletException {
        super.onStartup(servletContext);
        StartupServiceImpl impl = new StartupServiceImpl();
        impl.loadAllAtStartup();
        //servletContext.addListener(new DISContextListener());
    }

}
