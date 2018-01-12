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

import javafx.animation.AnimationTimer;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author alhe0816
 *         Date: 10.03.2017
 *         Time: 12:25
 */
public class Animation extends AnimationTimer {

    private Test3 test3;

    public Animation(Test3 test3) {
        this.test3 = test3;
    }

    @Override
    public void handle(long now) {
        Set<String> keys = test3.getPackets().keySet();
        List<String> sortedKeys = keys.stream().collect(Collectors.toList());
        if (keys.size() <= 14) {
            for (int i = sortedKeys.size() - 1; i >= 0; i--) {
                test3.getText()[i].setText(test3.getPackets().get(sortedKeys.get(i)) + " | " + sortedKeys.get(i));
            }
        } else {
            for (int i = sortedKeys.size() - 1; i >= sortedKeys.size() - 14; i--) {
                test3.getText()[i -(sortedKeys.size() - 14)].setText(test3.getPackets().get(sortedKeys.get(i)) + " | " + sortedKeys.get(i));
            }
        }
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