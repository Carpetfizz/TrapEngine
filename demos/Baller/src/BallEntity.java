import com.ajayramesh.TrapEngine.Entity;
import com.ajayramesh.TrapEngine.InputHandler;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by ajay on 4/8/15.
 */
public class BallEntity extends Entity{

    public BallEntity(int x, int y){
        setX(x);
        setY(y);
    }

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
}
