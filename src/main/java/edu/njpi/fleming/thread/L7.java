package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class L7 extends Thread{

    private static boolean isL7Stop;

    public static void setIsL7Stop(boolean newStop){
        isL7Stop = newStop;
    }

    @Override
    public void run() {

        isL7Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL7Stop) {
            robot.setAutoDelay(1500);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

    }
}
