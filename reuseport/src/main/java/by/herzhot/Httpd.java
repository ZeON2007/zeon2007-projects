package by.herzhot;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;

public class Httpd {
    public static void main(String[] args) throws Exception {
        int port = 18080;
        //int port = 8080;
//        int port = 5001;
        Server server = new Server();

        // server.addEventListener(new MyListener());
        ReusePortServerConnector connector = new ReusePortServerConnector(server);
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});

        HandlerCollection handlers = new HandlerCollection();
        server.setHandler(handlers);

//        Slf4jRequestLog requestLog = new Slf4jRequestLog();
//        requestLog.setExtended(true);
//        requestLog.setLogCookies(false);
//        requestLog.setLogTimeZone("GMT");
//        RequestLogHandler requestLogHandler = new RequestLogHandler();
//        requestLogHandler.setRequestLog(requestLog);
//        handlers.addHandler(requestLogHandler);

        server.start();
        server.join();
    }

}
