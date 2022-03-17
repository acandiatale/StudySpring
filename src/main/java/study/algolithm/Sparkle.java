package study.algolithm;

import javax.swing.*;
import java.awt.*;

public class Sparkle extends JFrame {
    public static void main(String[] args) throws InterruptedException {
        Sparkle sparkle = new Sparkle();
        sparkle.setUndecorated(true);
        sparkle.setSize(10, 10);
        sparkle.setVisible(true);
        sparkle.setAlwaysOnTop(true);
//        sparkle.setOpacity(0.3f);
        sparkle.setBackground(Color.WHITE);
        while(true) {
            Thread.sleep(10);
            sparkle.setLocation((int) MouseInfo.getPointerInfo().getLocation().getX() + 20,
                    (int) MouseInfo.getPointerInfo().getLocation().getY() + 20);
        }
    }
}
