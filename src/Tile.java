/**
 * Created by IntelliJ IDEA.
 *
 * @author: Shane
 * @date: 15/12/11
 */
public class Tile {
    private Item item;

    public Tile()
    {

    }

    public void addItem(Item newItem)
    {
        item = newItem;
    }
    
    public Item pickUp()
    {
        Item tempItem = item;
        item = null;
        return tempItem;
    }

    public boolean hasItem()
    {
        if (item != null)
            return true;
        return false;
    }

}
