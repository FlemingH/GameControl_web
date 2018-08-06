package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L1 extends Thread{

    private static boolean isL1Stop;

    public static void setIsL1Stop(boolean newStop){
        isL1Stop = newStop;
    }

    @Override
    public void run() {

        isL1Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL1Stop) {
            robot.setAutoDelay(90);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
