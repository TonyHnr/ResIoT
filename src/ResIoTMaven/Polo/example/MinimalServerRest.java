package ResIoTMaven.Polo.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


public class MinimalServerRest {

     public static void main(String[] args) throws Exception {
         ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
         context.setContextPath("/");

         Server jettyServer = new Server(8090);
         jettyServer.setHandler(context);

         ServletHolder jerseyServlet = context.addServlet(
                 ServletContainer.class, "/*");
         jerseyServlet.setInitOrder(0);

         // Tells the Jersey Servlet which REST service/class to load.
         jerseyServlet.setInitParameter(
                 "jersey.config.server.provider.classnames",
                 EntryPoint.class.getCanonicalName());

         try {
             jettyServer.start();
             jettyServer.join();
             System.out.println("hello");

         }
         catch (Exception e) {
             e.printStackTrace();
         }
         finally {
           jettyServer.destroy();
         }
     }
}
