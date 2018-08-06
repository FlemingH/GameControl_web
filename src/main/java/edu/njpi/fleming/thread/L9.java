package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L9 extends Thread{

    private static boolean isL9Stop;

    public static void setIsL9Stop(boolean newStop){
        isL9Stop = newStop;
    }

    @Override
    public void run() {

        isL9Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL9Stop) {
            robot.setAutoDelay(5000);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
