import java.util.Scanner;

public class SellerUI {
    private SellerAgent seller;

    public SellerUI(SellerAgent seller) {
        this.seller = seller;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter book title (or 'exit' to quit):");
                String title = scanner.nextLine();
                if ("exit".equalsIgnoreCase(title)) {
                    break;
                }

                System.out.println("Enter price:");
                int price = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                seller.addBook(title, price);
                System.out.println("Book added: " + title + " with price " + price);
            }
        }
    }
}


