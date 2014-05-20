import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Shane
 * @date: 16/12/11
 */
public class Parser {
    private Scanner reader;
    private Game gameref;

    public Parser(Game game)
    {
        reader = new Scanner(System.in);
        gameref = game;
    }

    public void getCommand()
    {
        String inputLine;
        System.out.print("\n> ");     // print prompt

        inputLine = reader.nextLine();
        if (inputLine.contains("north") || inputLine.contains("up"))
        {
            gameref.player.move(Player.NORTH);
        }
        else if (inputLine.contains("east") || inputLine.contains("right"))
        {
            gameref.player.move(Player.EAST);
        }
        else if (inputLine.contains("south") || inputLine.contains("down"))
        {
            gameref.player.move(Player.SOUTH);
        }
        else if (inputLine.contains("west") || inputLine.contains("left"))
        {
            gameref.player.move(Player.WEST);
        }
        else if (inputLine.contains("score"))
        {
            System.out.println("Your score is: " + gameref.score);
        }
        else if (inputLine.contains("exit"))
        {
            System.out.println("Your score is: " + gameref.score);
            System.out.println("Goodbye!");
            gameref.stopGame();
        }
        else if (inputLine.contains("drop"))
        {
            if (gameref.player.hasItem())
            {
                System.out.println("You have dropped the present on the floor.");
                gameref.world.map[gameref.player.getPosX()][gameref.player.getPosY()].addItem(gameref.player.getItem());
                gameref.player.removeItem();
            }
            else
            {
                System.out.println("You are not currently holding an item.");
            }
        }
        else if (inputLine.contains("npcs"))
        {
            for (NPC npc : gameref.npcs)
            {
                System.out.println("NPC: (" + npc.getPosX() + "," + npc.getPosY() + ")");
            }
        }
    }

}
