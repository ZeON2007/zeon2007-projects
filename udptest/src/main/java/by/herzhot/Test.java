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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author alhe0816
 *         Date: 17.02.2017
 *         Time: 10:24
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {

        // HOST = 192.168.0.11 10.229.90.125 10.229.90.165 10.236.3.43
        // TRACKER = 95.215.62.5  port = http (80)
        InetAddress ip = InetAddress.getByAddress(new byte[] {(byte) 10, (byte) 229, (byte) 90, (byte) 125});

        // connection request
        // data : 00 00 04 17 27 10 19 80 00 00 00 00 c6 a2 92 eb
        // convert to byte[] array
        byte[] buffer = new byte[] {0x00, 0x00, 0x04, 0x17, 0x27, 0x10, 0x19, (byte) 0x80, 0x00, 0x00, 0x00, 0x00, (byte) 0xc6, (byte) 0xa2, (byte) 0x92, (byte) 0xeb};
        int length = buffer.length;

        // DatagramPacket is used to send and received UDP packet
        DatagramPacket packet = new DatagramPacket(buffer, length, ip, 80);
        DatagramSocket socket = new DatagramSocket();
        int i = 0;
        while (i++ < 10000) {
            socket.send(packet);
            Thread.sleep(1000);
        }

        System.out.println("Already sent");
        socket.close();
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