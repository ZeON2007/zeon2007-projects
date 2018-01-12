package by.herzhot;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Formatter;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test2 extends Application {

//    public static void main(String[] args) throws IOException {

//        byte[] buffer = new byte[65508];
//        byte[] buffer = new byte[16];
//        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//        DatagramSocket socket = new DatagramSocket(80);
//        int i = 0;
//        while (++i < 5) {
//            socket.receive(packet);
//            System.out.println(byteArray2Hex(packet.getData()));
//            System.out.println(Arrays.toString(packet.getData()));
//            System.out.println(packet.getAddress());
//            System.out.println(packet.getLength());
//            System.out.println(packet.getOffset());
//            System.out.println(packet.getPort());
//            System.out.println(packet.getSocketAddress());
//        }
//        socket.close();
//    }
//
//    private static String byteArray2Hex(final byte[] hash) {
//        Formatter formatter = new Formatter();
//        for (byte b : hash) {
//            formatter.format("%02x ", b);
//        }
//        String result = formatter.toString();
//        formatter.close();
//        return result;

//    }

    private static final int STAR_COUNT = 5000;

    private final Rectangle[] nodes = new Rectangle[STAR_COUNT];
    private final double[] angles = new double[STAR_COUNT];
    private final long[] start = new long[STAR_COUNT];

    private final Random random = new Random();

    @Override
    public void start(final Stage primaryStage) {
        for (int i=0; i<STAR_COUNT; i++) {
            nodes[i] = new Rectangle(1, 1, Color.WHITE);
            angles[i] = 2.0 * Math.PI * random.nextDouble();
            start[i] = random.nextInt(2000000000);
        }
        final Scene scene = new Scene(new Group(nodes), 800, 600, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                final double width = 0.5 * primaryStage.getWidth();
                final double height = 0.5 * primaryStage.getHeight();
                final double radius = Math.sqrt(2) * Math.max(width, height);
                for (int i=0; i<STAR_COUNT; i++) {
                    final Node node = nodes[i];
                    final double angle = angles[i];
                    final long t = (now - start[i]) % 2000000000;
                    final double d = t * radius / 2000000000.0;
                    node.setTranslateX(Math.cos(angle) * d + width);
                    node.setTranslateY(Math.sin(angle) * d + height);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
