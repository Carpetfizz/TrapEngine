package com.ajayramesh.TrapEngine;

import java.awt.Graphics;
import java.util.ArrayList;

public class World
{
    private ArrayList<Entity> Entities = new ArrayList();
    private InputHandler input;

    void update()
    {
        for (Entity e:Entities)
        {
            if (e.enabled) {
                e.update(this.input);
            }
        }
    }

    void draw(Graphics bbg)
    {
        for (Entity e:Entities) {
            e.draw(bbg);
        }
    }

    public ArrayList getEntities()
    {
        return this.Entities;
    }

    public void setInput(InputHandler engineInput)
    {
        this.input = engineInput;
    }

    public void addEntity(Entity e)
    {
        this.Entities.add(e);
    }

    public void removeEntity(Entity e) {}
}
