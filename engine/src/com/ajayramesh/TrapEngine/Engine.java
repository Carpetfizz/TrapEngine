package com.ajayramesh.TrapEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.JFrame;

public class Engine extends JFrame
{
    int WIN_W = 800;
    int WIN_H = 600;
    boolean CAP_FRAMERATE = true;
    int FRAMERATE_CAP = 60;
    int UPDATE_INTERVAL = 10;
    double x = 0.0D;
    BufferedImage backBuffer;
    Insets insets = getInsets();
    World world;
    InputHandler input = new InputHandler(this);

    public void setWorld(World world)
    {
        world.setInput(this.input);
        this.world = world;
    }

    public static void main(String[] args)
    {
        Engine te = new Engine();
        World world = new World();
        te.initialize(world);
    }

    public void initialize(World world)
    {
        setTitle("Trap Engine");
        setResizable(false);
        setDefaultCloseOperation(3);
        this.backBuffer = new BufferedImage(this.WIN_W, this.WIN_H, 1);
        setVisible(true);
        setSize(this.insets.left + this.WIN_W + this.insets.right, this.insets.top + this.WIN_H + this.insets.bottom);
        setWorld(world);
        run();
        System.exit(0);
    }

    void run()
    {
        boolean isRunning = true;
        double lastTime = Time.currentTimeMs();
        while (isRunning)
        {
            double time = Time.currentTimeMs();
            /* If the elapsed time between updates is greater than 1s, skip to the next frame */
            if (time - lastTime > 1000.0D) {
                lastTime = time;
            }
            /* Elapsed time between updates divided by the update interval provides updatesNeeded */
            int updatesNeeded = (int)(time - lastTime) / this.UPDATE_INTERVAL;
            for (int i = 0; i < updatesNeeded; i++)
            {
                update();
                /* Increment the lastTime by the UPDATE_INTERVAL so that the elapsed time increases */
                lastTime += this.UPDATE_INTERVAL;
            }
            double frameStart = Time.currentTimeMs();
            draw();
            if (this.CAP_FRAMERATE)
            {
                /* Length of how long each frame should be  - the length of the latest frame */
                double delay = 1000 / this.FRAMERATE_CAP - (Time.currentTimeMs() - frameStart);
                if (delay > 0.0D) {
                    try
                    {
                        Thread.sleep((long)delay);
                    }
                    catch (Exception localException) {}
                }
            }
            /* 1 Second  / time it took current frame to render */
            System.out.println("FPS: " + 1.0D / (Time.currentTimeMs() / 1000.0D - frameStart / 1000.0D));
        }
        setVisible(false);
    }

    void update()
    {
        this.world.update();
    }

    void draw()
    {
        Graphics g = getGraphics();
        Graphics bbg = this.backBuffer.getGraphics();
        bbg.setColor(Color.BLACK);
        bbg.fillRect(0, 0, this.WIN_W, this.WIN_H);
        this.world.draw(bbg);
        g.drawImage(this.backBuffer, this.insets.left, this.insets.right, this);
    }
}
