package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R7 extends Thread{

    private static boolean isR7Stop;

    public static void setIsR7Stop(boolean newStop){
        isR7Stop = newStop;
    }

    @Override
    public void run() {

        isR7Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR7Stop) {
            robot.setAutoDelay(1500);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
