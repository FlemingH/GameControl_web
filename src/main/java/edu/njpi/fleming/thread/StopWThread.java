package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 为了防止有些游戏识别错误：在结束w线程后需要轻点一下w，用于彻底结束
 */
public class StopWThread extends Thread{

    @Override
    public void run() {

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);

    }
}
