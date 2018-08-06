package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SThread extends Thread{

    private static boolean isSStop;

    @Override
    public void run() {

        isSStop = false;

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(1000);

        while (!isSStop){
            robot.keyPress(KeyEvent.VK_DOWN);
        }

    }

    public static void setIsSStop(boolean newStop){
        isSStop = newStop;
    }

}
