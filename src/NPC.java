import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Shane
 * @date: 2011.12.15
 */
public class NPC extends Movable{
    private Random rand;

    public NPC(int x, int y, Game game)
    {
        posX = x;
        posY = y;
        gameRef = game;
        rand = new Random();
    }
    public void navigation()
    {
        switch(rand.nextInt(4))
        {
            case 0:
                move(NPC.NORTH);
                break;
            case 1:
                move(NPC.EAST);
                break;
            case 2:
                move(NPC.SOUTH);
                break;
            case 3:
                move(NPC.WEST);
                break;
        }
    }

}
