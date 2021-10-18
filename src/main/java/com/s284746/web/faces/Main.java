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

/**
 * Main class of the application.
 * Contains <code>main</code> method.
 */
public class Main {
	/**
	 * Starts the server.
	 * Stops the server when user enters anything (types anything and presses Enter/Return) to the console.
	 * @throws ServletException if server doesn't start, or if it doesn't stop
	 * @throws LifecycleException if error occurs within server lifecycle
	 * @throws IOException if <code>webapp</code> folder contents reading fails
	 */
	private static void invokeServer() throws ServletException, LifecycleException, IOException {
		long time = System.currentTimeMillis();
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		StandardContext context = (StandardContext) tomcat.addWebapp("", new File("webapp").getAbsolutePath());
		WebResourceRoot resourceRoot = new StandardRoot(context);
		resourceRoot.addPreResources(
				new DirResourceSet(resourceRoot, "/WEB-INF/classes", new File("build/main").getAbsolutePath(), "/"));
		context.setResources(resourceRoot);
		tomcat.start();
		time = System.currentTimeMillis() - time;
		System.out.print("Server invocation took ");
		System.out.print(time / 1000);
		time %= 1000;
		System.out.print('.');
		System.out.print(time / 100);
		time %= 100;
		System.out.print(time / 10);
		time %= 10;
		System.out.print(time);
		System.out.println(" seconds");
		System.out.println("Enter anything to stop");
		int ch = System.in.read();
		while (ch >= 32) {
			ch = System.in.read();
		}
		tomcat.stop();
	}

	/**
	 * Main method of the application.
	 * Creates a graph image, connects to the database (or creates new) and invokes a server.
	 * @param args command line arguments (not used in the method)
	 */
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
