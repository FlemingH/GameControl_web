package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WThread extends Thread{

    public static boolean isWStop;

    @Override
    public void run() {

        isWStop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.setAutoDelay(1000);

        while (!isWStop){
            robot.keyPress(KeyEvent.VK_UP);
        }
    }

    public static void setIsWStop(boolean newStop){
        isWStop = newStop;
    }

}
