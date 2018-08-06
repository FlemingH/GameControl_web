package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R2 extends Thread{

    private static boolean isR2Stop;

    public static void setIsR2Stop(boolean newStop){
        isR2Stop = newStop;
    }

    @Override
    public void run() {

        isR2Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR2Stop) {
            robot.setAutoDelay(150);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
