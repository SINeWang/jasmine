package com.sinewang.wave.jsm;

import com.sinewang.wave.jsm.filter.LoginFilter;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;


/**
 * Created by wangyanjiong on 6/16/15.
 */
public class JSMServer {

    private Logger log = LoggerFactory.getLogger(JSMServer.class);


    private static String DIR_WEBROOT = "../WebRoot";


    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            DIR_WEBROOT = args[0];
        }
        new JSMServer().startExploded();
    }

    private void startExploded() throws Exception {
        Server server = new Server();
        XmlConfiguration config = new XmlConfiguration(this.getClass().getResource("/jetty.xml"));
        config.configure(server);
        server.setHandler(context());
        server.start();
        server.join();
    }


    private WebAppContext context() {
        WebAppContext context = new WebAppContext();

        {// part of RESTful-API
            context.setContextPath("/");
            context.setParentLoaderPriority(true);
            context.setConfigurations(new Configuration[]{webAppAnnotationConfiguration()});
        }
        {// part of static resources
            ResourceHandler resourceHandler = new ResourceHandler();
            MimeTypes mimeTypes = resourceHandler.getMimeTypes();
            mimeTypes.addMimeMapping("html", "text/html; charset=UTF-8");
            resourceHandler.setResourceBase(DIR_WEBROOT);
            resourceHandler.setDirectoriesListed(false);
            context.setHandler(resourceHandler);
        }

        context.addFilter(LoginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));

        FilterHolder filterHolder = context.addFilter(UrlRewriteFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
        filterHolder.setInitParameter("confPath", "urlrewrite.xml");

        return context;
    }

    private AnnotationConfiguration webAppAnnotationConfiguration() {
        return new AnnotationConfiguration() {
            @Override
            public void preConfigure(WebAppContext context) throws Exception {
                context.setAttribute(CLASS_INHERITANCE_MAP, webAppInitializerClassNameMap());
            }
        };
    }

    private AnnotationConfiguration.ClassInheritanceMap webAppInitializerClassNameMap() {

        AnnotationConfiguration.ClassInheritanceMap map = new AnnotationConfiguration.ClassInheritanceMap();
        ConcurrentHashSet<String> set = new ConcurrentHashSet<String>();
        set.add(JSMInitializer.class.getName());

        map.put(WebApplicationInitializer.class.getName(), set);

        return map;
    }
}
