package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L6 extends Thread{

    private static boolean isL6Stop;

    public static void setIsL6Stop(boolean newStop){
        isL6Stop = newStop;
    }

    @Override
    public void run() {

        isL6Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL6Stop) {
            robot.setAutoDelay(800);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
