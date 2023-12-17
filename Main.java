import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sellers and buyers setup
        List<SellerAgent> sellers = new ArrayList<>();
        SellerAgent seller1 = new SellerAgent();
        sellers.add(seller1);
        
        // Create the buyer agent with the target book title
        BuyerAgent buyer1 = new BuyerAgent("Data Analytics");
        BuyerAgent buyer2 = new BuyerAgent("Quantum Mechanics");
        BuyerAgent buyer3 = new BuyerAgent("Optics");
        BuyerAgent buyer4 = new BuyerAgent("Electromagnetism");
        BuyerAgent buyer5 = new BuyerAgent("Cloud Computing");

        // Start Seller UI in a new thread to add books
        Thread sellerUIThread = new Thread(() -> new SellerUI(seller1).start());
        sellerUIThread.start();

        try {
            // Wait for the Seller UI thread to finish
            sellerUIThread.join();
        } catch (InterruptedException e) {
            System.out.println("Seller UI was interrupted.");
        }

        // After Seller UI has finished, the buyer logic will run
        buyer1.requestOffers(sellers); // Buyer requests offers from sellers
        buyer2.requestOffers(sellers); // Buyer requests offers from sellers
        buyer3.requestOffers(sellers); // Buyer requests offers from sellers
        buyer4.requestOffers(sellers); // Buyer requests offers from sellers
        buyer5.requestOffers(sellers); // Buyer requests offers from sellers
    }
}




