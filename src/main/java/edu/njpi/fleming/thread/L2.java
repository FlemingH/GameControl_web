package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L2 extends Thread{

    private static boolean isL2Stop;

    public static void setIsL2Stop(boolean newStop){
        isL2Stop = newStop;
    }

    @Override
    public void run() {

        isL2Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL2Stop) {
            robot.setAutoDelay(150);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
