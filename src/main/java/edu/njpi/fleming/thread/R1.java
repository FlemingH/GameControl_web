package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R1 extends Thread{

    private static boolean isR1Stop;

    public static void setIsR1Stop(boolean newStop){
        isR1Stop = newStop;
    }

    @Override
    public void run() {

        isR1Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR1Stop) {
            robot.setAutoDelay(90);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
