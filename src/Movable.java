/**
 * Created by IntelliJ IDEA.
 *
 * @author: Shane
 * @date: 16/12/11
 */
public class Movable {
    public Game gameRef;
    private String name;
    protected int posX;
    protected int posY;

    public final static int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;

    public Movable()
    {

    }

    public Movable(Game game)
    {
        posX = 0;
        posY = 0;
        gameRef = game;
    }

    public Movable(int x, int y, Game game)
    {
        posX = x;
        posY = y;
        gameRef = game;
    }


    public int getPosX()
    {
        return posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void setLocation(int x, int y)
    {
        posX = x;
        posY = y;
    }

    public void move(int direction)
    {
        switch(direction)
        {
            case NORTH:
                if(posY != 0)
                    posY -= 1;
                break;
            case EAST:
                if(posX < gameRef.world.getWidth() - 1)
                    posX += 1;
                break;
            case SOUTH:
                if(posY < gameRef.world.getHeight() - 1)
                    posY += 1;
                break;
            case WEST:
                if(posX != 0)
                    posX -= 1;
                break;
        }
    }

}
