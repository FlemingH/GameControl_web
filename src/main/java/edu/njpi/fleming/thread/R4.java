package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R4 extends Thread{

    private static boolean isR4Stop;

    public static void setIsR4Stop(boolean newStop){
        isR4Stop = newStop;
    }

    @Override
    public void run() {

        isR4Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR4Stop) {
            robot.setAutoDelay(350);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
