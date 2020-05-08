import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Functions {
    //Pulled this from https://www.codejava.net/java-se/graphics/how-to-capture-screenshot-programmatically-in-java
    //Was a real pain to get working
    public static void saveToFile() {
        try {
            Robot robot = new Robot();
            String format = "png";
            String fileName = "Screenshot." + format;

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            //captureRect clarifys the dimensions of the screencapture. I tried to capture parts of the Java applet but I couldnt get that working.
            Rectangle captureRect = new Rectangle((screenSize.width / 4)+150, (screenSize.height / 4) - 40, (screenSize.width / 2) - 240, (screenSize.height / 2)-80);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, format, new File(fileName));

            System.out.println("A partial screenshot saved!");//Confirms success
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}

