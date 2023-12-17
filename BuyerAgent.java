import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BuyerAgent {
    private String targetBookTitle;

    public BuyerAgent(String targetBookTitle) {
        this.targetBookTitle = targetBookTitle;
    }

    // This method is public and can be called from the Main class.
    public void requestOffers(List<SellerAgent> sellers) {
        Map<SellerAgent, Integer> offers = new HashMap<>();
        for (SellerAgent seller : sellers) {
            Integer price = seller.respondToRequest(targetBookTitle);
            if (price != null) {
                offers.put(seller, price);
            }
        }
        chooseBestOffer(offers);
    }

    // This method is private and should only be called within the BuyerAgent class.
    private void chooseBestOffer(Map<SellerAgent, Integer> offers) {
        Optional<Map.Entry<SellerAgent, Integer>> bestOffer =
                offers.entrySet().stream().min(Map.Entry.comparingByValue());

        bestOffer.ifPresent(offer -> purchaseBook(offer.getKey(), offer.getValue()));
    }

    // This method is private and should only be called within the BuyerAgent class.
    private void purchaseBook(SellerAgent seller, Integer price) {
        seller.completeTransaction(targetBookTitle);
        System.out.println("Purchased " + targetBookTitle + " for " + price + " from seller.");
    }
}




