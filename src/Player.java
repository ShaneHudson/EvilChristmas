/**
 * Created by IntelliJ IDEA.
 * @author: Shane Hudson
 * @date: 2011.12.15
 */
public class Player extends Movable {
    private String name;
    protected int homePosX;
    protected int homePosY;
    private Item inventory;

    public Player(Game game)
    {
        posX = 0; homePosX = 0;
        posY = 0; homePosY = 0;
        gameRef = game;
        inventory = null;
    }

    public Player(int x, int y, Game game)
    {
        posX = x; homePosX = x;
        posY = y; homePosY = y;
        gameRef = game;
        inventory = null;
    }
    
    public void setName(String playerName)
    {
        name = playerName;
    }
    
    public String getName()
    {
        return name;
    }

    public boolean isHome()
    {
        if (posX == homePosX && posY == homePosY)
            return true;
        return false;
    }


    public int getHomePosX()
    {
        return homePosX;
    }

    public int getHomePosY()
    {
        return homePosY;
    }

    public void addItem (Item item)
    {
        inventory = item;
    }

    public void removeItem()
    {
        inventory = null;
    }
    
    public Item getItem()
    {
        return inventory;
    }
    
    public boolean hasItem()
    {
        if (inventory != null)
        {
            return true;
        }
        return false;
    }
}
