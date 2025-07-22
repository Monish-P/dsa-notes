/*

Functional req:
1. The users sees a list of available items in the dashboard screen.
2. User selects an item by pressing some code key or number
3. The user makes a payment using any of the payment method
4. after successful payment , the item is dispersed

Core entities :
1. Item
2. User (optional)
3. Payment class
*/
import java.util.*;
public abstract class Item {

    private static int total_no_of_items = 55;

    private String item_code;
    private String item_name;
    private float price;
    private String item_description;
    private static List<ItemObserver> observers = new ArrayList<>();

    public abstract void disperse();

    public static void addObserver(ItemObserver observer) {
        observers.add(observer);
    }

    public static void removeObserver(ItemObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Item item) {
        for (ItemObserver observer: observers) {
            observer.update(item);
        }
    }


}

public class Cracker extends Item {

    private static int no_of_crackers = 30;

    public void disperse() {
        this.setNoOfCrackers(this.getNoOfCrackers() - 1);
        super.setTotalNoOfItems(super.getTotalNoOfItems() - 1);

        //remaining logic
        if (this.getNoOfCrackers() == 0) {
            super.notifyObservers(this);
        }
    }

}

public class SoftDrink extends Item {

    private static int no_of_drinks = 25;
    

    public void disperse() {
        this.setNoOfDrinks(this.getNoOfDrinks() - 1);
        super.setTotalNoOfItems(super.getTotalNoOfItems() - 1);

        //remaining logic
        if (this.getNoOfDrinks() == 0) {
            super.notifyObservers(this);
        }
    }

}

public interface ItemObserver {
    public void update(Item item);
}

public class DashboardNotification implements ItemObserver {

    void update(Item item) {
        System.out.println("Dashboard notification is sent making the item:"+item.getItemName()+" disabled/unavailable to the user");
    }
}

public class EmailNotification implements ItemObserver {

    void update(Item item) {
        System.out.println("Email notification is sent to the operator that "+item.getItemName()+" is out of stock and needs refill");
    }
}

public abstract class ItemFactory {
    public abstract Item addItemtoCart();
}

public class CrackerFactory extends ItemFactory {

    public abstract Item addItemtoCart(String item_code) {
        return new Cracker(item_code);
    }
}

public class SoftDrinkFactory extends ItemFactory {

    public abstract Item addItemtoCart(String item_code) {
        return new SoftDrink(item_code);
    }
}

public interface PaymentStrategy {
    void makePayment();
}

public class UPIPayment implements PaymentStrategy {
    public void makePayment() {
        System.out.println("UPI payment completed")
    }
}

public class CashPayment implements PaymentStrategy {
    public void makePayment() {
        System.out.println("Cash payment completed")
    }
}

// public class Dashboard {
//     private static int total_no_of_items
// }

public class Main {
    public static void main(String[] args) {
        //initial setup
        ItemFactory crackerFactory = new CrackerFactory();
        ItemFactory softDrinkFactory = new SoftDrinkFactory();
        Item.addObserver(new DashboardNotification());
        Item.addObserver(new EmailNotification());

        //add the available items
        Cracker good_day_biscuit = crackerFactory.addItemtoCart("GD00");
        SoftDrink pepsi = softDrinkFactory.addItemtoCart("PP12");

        //make payment
        PaymentStrategy cash = new CashPayment();
        cash.makePayment();

        //disperse the items
        good_day_biscuit.disperse();
        pepsi.disperse();

    }
}
