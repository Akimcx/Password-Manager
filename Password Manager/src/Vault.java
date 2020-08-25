import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vault implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3586709451697099301L;

    private List<Item> items;

    public Vault() { items = new ArrayList<>(); }

    public void addItem( Item item ) { System.out.println( "Item added successfully" ); }

    public void removeItem( Item item ) { System.out.println( "Item removed successfully" ); }

    public List<Item> getItems() { return items; }

}
