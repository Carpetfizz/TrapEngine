package com.ajayramesh.TrapEngine;

import java.awt.Graphics;

public class Entity
{
    private int x;
    private int y;
    boolean enabled = true;

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    protected void update(InputHandler input) {}

    protected void draw(Graphics bbg) {}
}
