/* Below is the Trader class, which functions similarly to the one from
 * Lab 3, but with a handful of differences
 *
 * This implementation of Trader uses the generic type T instead of
 * Tradable: our Trader can have objects of any type, not just Tradable
 * ones! To have our original Trader class from Lab 3, we can
 * create a Trader<Tradable> object, as that will enforce that every
 * object is Tradable.
 *
 * Go through the TODOs below and complete them.
 */

import java.util.ArrayList;
import java.util.List;


public class Trader<T> {
    private final List<T> inventory;
    private final List<T> wishlist;
    private int money;



    /**
     * Construct a Trader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public Trader(List<T> inventory, List<T> wishlist,
                  int money) {
        this.inventory = inventory;
        this.wishlist = wishlist;
        this.money = money;
    }

    /* TODO: Add a new constructor that takes a single argument
     *       representing the Trader's money. Give the Trader
     *       empty ArrayLists for their inventory and wishlist.
     */
    public Trader(int money){
        inventory = new ArrayList<T>();
        wishlist = new ArrayList<T>();
    }





    /* TODO: Implement the method addToWishlist that takes an
     *       object of type T and adds it to this Trader's wishlist.
     */
    public void addToWishlist(T obj){
        wishlist.add(obj);
    }





    /* TODO: Implement the method getSellingPrice that takes an
     *       object of type T and returns the object's price
     *       (via getPrice()) if it's Tradable. If not,
     *       return Tradable.MISSING_PRICE.
     *
     *       We will call this in exchangeMoney().
     */
    public int getSellingPrice(T potential_item){
        if (potential_item instanceof Tradable){
            int price = ((Tradable) potential_item).getPrice();
            if ( price != -1) {
                return price;
            }
        }
        return Tradable.MISSING_PRICE;
    }





    /**
     * Exchange money from other to this Trader according to the price of item,
     * if other has enough money. Otherwise, returns False.
     *
     * @return True if the exchange was completed.
     */
    public boolean exchangeMoney(Trader<T> other, T item) {
        int selling_price = this.getSellingPrice(item);
        if (selling_price == Tradable.MISSING_PRICE) {
            return false;
        }

        if (selling_price <= other.money) {
            other.money -= selling_price;
            this.money += selling_price;
            return true;
        }
        return false;
    }

    /**
     * Attempt to sell all items that are in both this Trader's inventory
     * and in other's wishlist.
     *
     * @return True iff at least one item was sold from this Trader to other
     */
    public boolean sellTo(Trader<T> other) {
        boolean sold_at_least_one = false;
        List<T> temp = new ArrayList<>();

        for (T item : this.inventory) {
            if (other.wishlist.contains(item) && exchangeMoney(other, item)) {
                temp.add(item);
                sold_at_least_one = true;
            }
        }

        this.inventory.removeAll(temp);
        other.inventory.addAll(temp);
        other.wishlist.removeAll(temp);

        return sold_at_least_one;
    }

    /**
     * Buy items from other.
     *
     * @return True iff at least one item was bought from other.
     */
    public boolean buyFrom(Trader<T> other) {
        return other.sellTo(this);
    }


    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("-- Inventory --\n");

        for (T item : this.inventory) {
            details.append(item).append("\n");
        }

        details.append("-- Wishlist --\n");
        for (T item : this.wishlist) {
            details.append(item).append("\n");
        }

        return details.toString();
    }

    public List<T> getWishlist(){
        return this.wishlist;
    }

    public List<T> getInventory(){
        return this.inventory;
    }

}