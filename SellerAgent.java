import java.util.HashMap;
import java.util.Map;

public class SellerAgent {
    private Map<String, Integer> catalogue = new HashMap<>();

    public void addBook(String title, int price) {
        catalogue.put(title, price);
    }

    public Integer respondToRequest(String title) {
        return catalogue.getOrDefault(title, null);
    }

    public void completeTransaction(String title) {
        catalogue.remove(title);
        System.out.println(title + " sold.");
    }
}


