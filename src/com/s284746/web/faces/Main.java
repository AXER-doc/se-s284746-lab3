package com.s284746.web.faces;

import com.s284746.web.faces.util.GraphicConstructor;
import com.s284746.web.faces.util.SQLProcessor;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.catalina.WebResourceRoot;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

public class Main {
    private static void invokeServer() throws ServletException, LifecycleException, IOException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        StandardContext context = (StandardContext) tomcat.addWebapp("", new File("webapp").getAbsolutePath());
        WebResourceRoot resourceRoot = new StandardRoot(context);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", new File("build/classes").getAbsolutePath(), "/"));
        context.setResources(resourceRoot);
        tomcat.start();
        System.out.println("Enter anything to stop");
        int ch = System.in.read();
        while (ch >= 32) {
            ch = System.in.read();
        }
        tomcat.stop();
    }
    public static void main(String[] args) {
        try {
            GraphicConstructor.save("figure.png");
            // uncomment if complete database deletion is needed
            // SQLProcessor.dropDB();
            SQLProcessor.initDB();
            invokeServer();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
