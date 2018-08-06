package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R6 extends Thread{

    private static boolean isR6Stop;

    public static void setIsR6Stop(boolean newStop){
        isR6Stop = newStop;
    }

    @Override
    public void run() {

        isR6Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR6Stop) {
            robot.setAutoDelay(800);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
