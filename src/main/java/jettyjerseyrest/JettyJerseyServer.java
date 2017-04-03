package jettyjerseyrest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyJerseyServer
{

    public static void main( String[] args ) {

        ResourceConfig config = new ResourceConfig();
        config.packages("jettyjerseyrest");

        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        Server server = new Server(2222);
        //Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");


        try {
            try {
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                server.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            server.destroy();
        }
    }
}

