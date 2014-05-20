import java.util.ArrayList;
import java.util.Random;

/**
 * The main game class
 * @author: Shane Hudson
 * @date: 2011.12.15
 */
public class Game {

    public static World world;
    private static Game game;
    public static Player player;
    protected static int score;
    protected static ArrayList<NPC> npcs;

    private static boolean isRunning;

    public static void main(String [] args)
    {
        game = new Game();
        Parser parser = new Parser(game);
        System.out.println("Welcome to Evil Christmas!");
        isRunning = true;
        while(isRunning)
        {
            printMap();
            parser.getCommand();

            for (NPC npc : npcs)
            {
                npc.navigation();
            }

            Tile currentPos = world.map[player.posX][player.posY];
            
            if(currentPos.hasItem())
            {
                if (!player.hasItem())
                {
                    player.addItem(currentPos.pickUp());
                    System.out.println("You have picked up a present");
                }
                else   {
                    System.out.println("There is a present here but your hands are full!");
                }
            }

            if( player.isHome() && player.hasItem())
            {
                player.removeItem();
                game.score++;
                System.out.println("Your score is: " + game.score);
            }
            
            if (player.hasItem())
            {
                for (NPC npc : npcs)
                {
                    if (npc.getPosX() == player.getPosX() && npc.getPosY() == player.getPosY())
                    {
                        player.removeItem();
                        System.out.println("You have been caught! The present has been taken away.");
                    }
                }
            }
            checkScore();

            System.out.println("Player: (" + player.posX + "," + player.posY + ")");
        }
    }

    public Game()
    {
        world = new World(5,5, this);
        player = new Player(0,0, this);
        player.setName("player1");
        npcs = new ArrayList<NPC>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {
            npcs.add(new NPC(rand.nextInt(5),rand.nextInt(5),this));
        }
    }

    public void stopGame()
    {
        isRunning = false;
    }

    private static void printMap()
    {
        for (int y = 0; y < world.getHeight(); y++)
        {
            for (int x = 0; x < world.getWidth(); x++)
            {
                Tile currentTile = world.map[x][y];
                if (currentTile.hasItem())
                    System.out.print("[x]");
                else if (currentTile == world.map[player.getPosX()][player.getPosY()])
                    System.out.print("[P]");
                else if (currentTile == world.map[player.getHomePosX()][player.getHomePosY()])
                    System.out.print("[H]");
                else if (hasNPC(currentTile))
                    System.out.print("[*]");
                else
                    System.out.print("[ ]");
            }
            System.out.print("\n");
        }
    }

    
    private static boolean hasNPC(Tile current)
    {
        for (NPC npc : npcs)
        {
            if (current == world.map[npc.getPosX()][npc.getPosY()])
            {
                return true;
            }
        }
        return false;
    }


    private static void checkScore()
    {
        if (world.amountOfPresents == 0)
        {
            System.out.println("The game is finished! Your score is: " + score);
        }
    }

}
