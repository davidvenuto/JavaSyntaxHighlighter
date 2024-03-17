package sourceFiles;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Integer> items = new HashMap<>();

    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item, int quantity) {
        int currentQty = items.getOrDefault(item, 0);
        if (currentQty <= quantity) {
            items.remove(item);
        } else {
            items.put(item, currentQty - quantity);
        }
    }

    public void displayCartContents() {
        if (items.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart Contents:");
            items.forEach((item, quantity) -> System.out.println(item + ": " + quantity));
        }
    }
}

