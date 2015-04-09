# TrapEngine
An attempt to write a 2D game engine in Java from scratch.

![Call this a game?](http://i.imgur.com/2bS7GvG.gif)

*Started from the trap now I rap - 2Chainz*

## Features
* Fixed ticks

* Framerate capping

* Keyboard input

* Easy to use API

## Todo
* Build and deploy workflow

* Basic collision detection

* Average framerate calculation

* Image sprites and sprite animations

* Mouse input

## API

Disclaimer: I've never used another code-based game engine, nor have I used Java before working on this project, so I'd appreciate some pointers on best pracctices.

All of the current functionality is modeled in the "Baller" demo, which is included in this repo.

### Create a World
"Worlds" are structures that include "Entities". Entities are passed into the world's digest cycle to perform updates and drawings. You can also think of them as "Levels" or "Scenes"

```
public class Level1 extends World {
    public Level1(){
    }
}
```

Once you've created your own World, you can initialize the game engine by passing it in.

```
/* Inside your "main" */
Engine te = new Engine();
te.initialize(new Level1());
```

That's it! You can run the engine with the current code, but staring at a black screen isn't too fun. Let's add some entities!

### Create Entities
"Entities" are things that exist in a game world, like characters, walls, etc. After they are created, they must be added into the world's "Entities" array.
Custom entities must `@Override` the `update()` and `draw()` methods of the Entity superclass. The following snippet is from the "Baller" demo.

Currently an entity, has getters and setters for its coordinates, which are modified in the update function. The draw function will create the shapes based on the new coordinates, and render them onto the backbuffer.
```
  @Override
  protected void update(InputHandler input){
    if(input.isKeyDown(KeyEvent.VK_RIGHT)){
        setX(getX()+1);
    }
    if(input.isKeyDown(KeyEvent.VK_LEFT)){
        setX(getX()-1);
    }
    if(input.isKeyDown(KeyEvent.VK_UP)){
        setY(getY() - 1);
    }
    if(input.isKeyDown(KeyEvent.VK_DOWN)){
        setY(getY() + 1);
    }
  }
  @Override
  protected void draw(Graphics bbg){
    bbg.setColor(Color.WHITE);
    bbg.fillOval(getX(),getY(),20,20);
  }
```

### Put entities in your world

Inside of your World subclass, (ie: Level1), simple call:

```
MyEntity e = new MyEntity();
addEntity(e);
```

This will push the entity into the update and draw cycle of the world.

## Credits
Having no experience with gamedev, or game engines, I owe my thanks to the following resources for helping me through the beginning stages.

[CompSci.CA](http://compsci.ca/v3/viewtopic.php?t=25991) for the idea and for the input system

[Ilmari Karonen](http://gamedev.stackexchange.com/a/97948/63687) for helping me decouple my updates and redering

[Game Programming Patterns | Update Method](http://gameprogrammingpatterns.com/update-method.html) for providing a design to update entities in a world

[Game Programming Patterns | Game Loop](http://gameprogrammingpatterns.com/game-loop.html) for further refinement of my game loop.

