package com.ajayramesh.TrapEngine;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler
        implements KeyListener
{
    boolean[] KEYS = new boolean[256];

    public InputHandler(Component c)
    {
        c.addKeyListener(this);
    }

    public boolean isKeyDown(int keyCode)
    {
        if ((keyCode > 0) && (keyCode < 256)) {
            return this.KEYS[keyCode];
        }
        return false;
    }

    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if ((keyCode > 0) && (keyCode < 256)) {
            this.KEYS[keyCode] = true;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if ((keyCode > 0) && (keyCode < 256)) {
            this.KEYS[keyCode] = false;
        }
    }

    public void keyTyped(KeyEvent e) {}
}
