/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package by.herzhot;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ThreadFactory;

/**
 * @author alhe0816
 *         Date: 10.03.2017
 *         Time: 11:38
 */
public class Test3 extends Application {

    private Animation animation = new Animation(this);
    private Text[] text = new Text[14];
    private Map<String, String> packets = new LinkedHashMap<>();
    private Thread thread;
    private int port = 80;
    private int size = 16;
    byte[] buffer = new byte[size];
    private ThreadFactory threadFactory;


    public Test3() throws SocketException {
        for (int i = 0; i < text.length; i++) {
            text[i] = new Text();
//            text[i].setLayoutX(15);
            text[i].setLayoutY(50 + i*25);
//            text[i].setText("hello");
            text[i].setFill(Color.GREENYELLOW);
//            text[i].setScaleX(2);
//            text[i].setScaleY(2);
            text[i].setTextAlignment(TextAlignment.LEFT);
//            text[i].setX(100);
//            text[i].setY(100);
            text[i].setFont(Font.font(20));
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, 800, 400, Color.BLACK);
        primaryStage.setScene(scene);

        Button button1 = new Button("WRITE ALL TO FILE");
        Button button2 = new Button("STOP");
        Label label1 = new Label("PORT");
        label1.setTextFill(Color.GREEN);
        TextField portValue = new TextField(String.valueOf(port));
        Label label2 = new Label("BYTE SIZE");
        label2.setTextFill(Color.GREEN);
        TextField sizeValue = new TextField(String.valueOf(size));
        Button refreshButton = new Button("START TO LISTEN");


        HBox hBox = new HBox(label1, portValue, label2, sizeValue, refreshButton, button1);
        hBox.setSpacing(10);

        root.getChildren().add(hBox);
        root.getChildren().addAll(text);

        button1.setOnAction(event -> {
            try(  PrintWriter out = new PrintWriter( "data.txt" )  ){
                for (String key : packets.keySet()) {
                    out.println(key + " | " + packets.get(key));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
//            animation.start();
        });
        button2.setOnAction(event -> {
//            animation.stop();
        });
        refreshButton.setOnAction(event -> {
            port = Integer.valueOf(portValue.getCharacters().toString());
            System.out.println(port);
            size = Integer.valueOf(sizeValue.getCharacters().toString());
            System.out.println(size);
            buffer = new byte[size];
//            packets.clear();
            startNewThread();

        });

        animation.start();
        primaryStage.show();

//        startNewThread();

//        System.out.println(byteArray2Hex(packet.getData()));
//        System.out.println(Arrays.toString(packet.getData()));
//        System.out.println(packet.getAddress());
//        System.out.println(packet.getLength());
//        System.out.println(packet.getOffset());
//        System.out.println(packet.getPort());
//        System.out.println(packet.getSocketAddress());

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Text[] getText() {
        return text;
    }

    public void setText(Text[] text) {
        this.text = text;
    }

    public Map<String, String> getPackets() {
        return packets;
    }

    private static String byteArray2Hex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x ", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private void startNewThread() {
        threadFactory = Thread::new;
        thread = threadFactory.newThread(() -> {
            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(port);
                System.out.println(socket.isBound());
                socket.setReuseAddress(true);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            int i = 0;
            while (i++ < 1000) {
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                packets.put(new Timestamp(System.currentTimeMillis()).toString(), byteArray2Hex(packet.getData()));
            }
            if (!socket.isClosed()) {
                socket.close();
                System.out.println("Socket is closed");
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER. 
 
 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
*/