package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L3 extends Thread{

    private static boolean isL3Stop;

    public static void setIsL3Stop(boolean newStop){
        isL3Stop = newStop;
    }

    @Override
    public void run() {

        isL3Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL3Stop) {
            robot.setAutoDelay(250);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
