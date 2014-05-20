import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Shane
 * @date: 15/12/11
 */
public class World {
    public Tile[][] map;
    private int width, height;
    private Random rand;
    private Game game;

    protected int amountOfPresents;

    public World(Game game)
    {
        this.game = game;
        map = new Tile[100][100];
        amountOfPresents = 10;
        initialisePresents();
    }

    public World(int w, int h, Game game)
    {
        this.game = game;
        map = new Tile[w][h];
        width = w; height = h;
        amountOfPresents = 5;

        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                map[x][y] = new Tile();
            }
        }
        initialisePresents();
    }

    private void initialisePresents()
    {
        Random rand = new Random();
        for(int i = 0; i < amountOfPresents; i++)
        {
            int randY = rand.nextInt(getWidth());
            int randX = rand.nextInt(getHeight());
            if (!(randX == 0 && randY == 0))
                map[randX][randY].addItem(new Item("Present"));
        }
    }

    
    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }


    public void removeItem()
    {
        Item tmpItem = game.player.getItem();
        game.player.removeItem();
        amountOfPresents--;
        game.world.map[game.player.getPosX()][game.player.getPosY()].addItem(tmpItem);
    }
}
