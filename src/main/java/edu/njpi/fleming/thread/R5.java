package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R5 extends Thread{

    private static boolean isR5Stop;

    public static void setIsR5Stop(boolean newStop){
        isR5Stop = newStop;
    }

    @Override
    public void run() {

        isR5Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR5Stop) {
            robot.setAutoDelay(500);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
