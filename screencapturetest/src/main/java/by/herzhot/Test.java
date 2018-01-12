package by.herzhot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws AWTException, IOException {

        File file = new File("C:\\projects\\screencapturetest\\src\\main\\resources\\test.png");
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        BufferedImage bufferedImage =  robot.createScreenCapture(rectangle);



//        bufferedImage = JNAScreenShot.getScreenshot(rectangle);


        if (bufferedImage != null) {
            ImageIO.write(bufferedImage, "png", file);
        }

    }
}
