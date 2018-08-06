package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L8 extends Thread{

    private static boolean isL8Stop;

    public static void setIsL8Stop(boolean newStop){
        isL8Stop = newStop;
    }

    @Override
    public void run() {

        isL8Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL8Stop) {
            robot.setAutoDelay(2000);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
