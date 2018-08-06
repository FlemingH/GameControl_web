package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R9 extends Thread{

    private static boolean isR9Stop;

    public static void setIsR9Stop(boolean newStop){
        isR9Stop = newStop;
    }

    @Override
    public void run() {

        isR9Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR9Stop) {
            robot.setAutoDelay(5000);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
