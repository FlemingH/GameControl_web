package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R3 extends Thread{

    private static boolean isR3Stop;

    public static void setIsR3Stop(boolean newStop){
        isR3Stop = newStop;
    }

    @Override
    public void run() {

        isR3Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR3Stop) {
            robot.setAutoDelay(250);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
