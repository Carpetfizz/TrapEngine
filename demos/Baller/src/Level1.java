import com.ajayramesh.TrapEngine.World;

/**
 * Created by ajay on 4/8/15.
 */
public class Level1 extends World {
    public Level1(){
        BallEntity ball = new BallEntity(10,40);
        addEntity(ball);
    }
}
