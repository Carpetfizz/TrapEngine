package com.ajayramesh.TrapEngine;

public class Vector2D
{
    private double x;
    private double y;

    public Vector2D()
    {
        this(0.0,0.0);
    }

    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double magnitude()
    {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double angle()
    {
        return Math.atan2(this.y, this.x);
    }

    public Vector2D scale(double scalar)
    {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    public Vector2D add(Vector2D v2d)
    {
        return new Vector2D(this.x + v2d.x, this.y + v2d.y);
    }
}
