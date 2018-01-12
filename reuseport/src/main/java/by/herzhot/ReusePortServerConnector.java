package by.herzhot;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.Arrays;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import sun.nio.ch.Net;


public class ReusePortServerConnector extends ServerConnector {
    private final static int SO_REUSEPORT = 0x0200;
    int i = 0;

    public ReusePortServerConnector(final Server server) {
        super(server);
    }

    // Mostly same as ServerConnector#open.
    // But chis method sets SO_REUSEPORT
    @Override
    public void open() throws IOException {
        if (getTransport() == null) {
            ServerSocketChannel serverChannel = null;
            if (isInheritChannel()) {
                Channel channel = System.inheritedChannel();
                if (channel instanceof ServerSocketChannel)
                    serverChannel = (ServerSocketChannel)channel;
                else
                    LOG.warn("Unable to use System.inheritedChannel() [{}]. Trying a new ServerSocketChannel at {}:{}", channel, getHost(), getPort());
            }

            if (serverChannel == null) {
                serverChannel = ServerSocketChannel.open();

                InetSocketAddress bindAddress = getHost() == null ? new InetSocketAddress(getPort()) :
                        new InetSocketAddress(getHost(), getPort());
                serverChannel.socket().setReuseAddress(getReuseAddress());
                setReusePort(serverChannel);
                serverChannel.socket().bind(bindAddress, getAcceptQueueSize());

                int _localPort = serverChannel.socket().getLocalPort();
                if (_localPort <= 0)
                    throw new IOException("Server channel not bound");
                try {
                    final Field field = ServerConnector.class.getDeclaredField("_localPort");
                    field.setAccessible(true);
                    field.set(this, _localPort);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

                addBean(serverChannel);
            }

            serverChannel.configureBlocking(true);
            addBean(serverChannel);

            try {
                final Field field = ServerConnector.class.getDeclaredField("_acceptChannel");
                field.setAccessible(true);
                field.set(this, serverChannel);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Set SO_REUSEPORT using refleciton.
    public void setReusePort(ServerSocketChannel serverChannel) {
        try {
            Field fieldFd = serverChannel.getClass().getDeclaredField("fd");
            //NoSuchFieldException
            fieldFd.setAccessible(true);
            FileDescriptor fd = (FileDescriptor)fieldFd.get(serverChannel);
            //IllegalAccessException

//            Method methodSetIntOption0 = Net.class.getDeclaredMethod("setIntOption0", FileDescriptor.class, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
            Method methodSetIntOption0 = Net.class.getDeclaredMethod("setIntOption0", FileDescriptor.class, boolean.class, int.class, int.class, int.class, boolean.class);
            methodSetIntOption0.setAccessible(true);
//            System.out.println(Arrays.toString(methodSetIntOption0.getParameterTypes()));

//            methodSetIntOption0.invoke(null , fd, false, '\uffff', 1, 1, false);
            methodSetIntOption0.invoke(null , fd, false, '\uffff', i, 0xf, false);
//            char c = "\uFFFF".toCharArray()[0];
//            System.out.println((int)c);
            System.out.println("++++++++++" + i++);
//            if (i > i+3500) {
//                System.exit(0);
//            }
            setReusePort(serverChannel);
        } catch (Exception e) {
            System.out.println("---------- " + i++);
//            e.printStackTrace();
//            if (i > i+3500) {
//                System.exit(0);
//            }
            setReusePort(serverChannel);
        }
    }
}
