package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L5 extends Thread{

    private static boolean isL5Stop;

    public static void setIsL5Stop(boolean newStop){
        isL5Stop = newStop;
    }

    @Override
    public void run() {

        isL5Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL5Stop) {
            robot.setAutoDelay(500);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
