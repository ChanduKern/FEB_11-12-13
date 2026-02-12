class EmailService {

    public void sendEmail(String email) {

        System.out.println("Preparing email for " + email);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Email sent to " + email);
    }
}

class OrderService {

    private EmailService emailService = new EmailService();

    public void placeOrder(String customerEmail) {

        System.out.println("Order placed successfully!");

        Thread emailThread = new Thread(() -> {
            emailService.sendEmail(customerEmail);
        });

        emailThread.start();
    }
}

public class AsyncExample {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        orderService.placeOrder("customer@gmail.com");

        System.out.println("Order confirmation shown to user immediately.");
    }
}