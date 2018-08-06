package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L4 extends Thread{

    private static boolean isL4Stop;

    public static void setIsL4Stop(boolean newStop){
        isL4Stop = newStop;
    }

    @Override
    public void run() {

        isL4Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL4Stop) {
            robot.setAutoDelay(350);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
