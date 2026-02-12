class TicketCounter {

    private int tickets = 10;

    public void bookTicket(String userName, int seatsRequested) {

        System.out.println(userName + " trying to book " + seatsRequested + " tickets");

        if (tickets >= seatsRequested) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tickets -= seatsRequested;
            System.out.println(userName + " successfully booked. Remaining: " + tickets);

        } else {
            System.out.println(userName + " Booking Failed. Only " + tickets + " tickets left.");
        }
    }
}

class User extends Thread {

    private TicketCounter counter;
    private int seats;

    public User(TicketCounter counter, String name, int seats) {
        super(name);
        this.counter = counter;
        this.seats = seats;
    }

    @Override
    public void run() {
        counter.bookTicket(getName(), seats);
    }
}

public class TicketBookingSystem {

    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        User u1 = new User(counter, "User-1", 4);
        User u2 = new User(counter, "User-2", 4);
        User u3 = new User(counter, "User-3", 4);
        User u4 = new User(counter, "User-4", 4);
        User u5 = new User(counter, "User-5", 4);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
    }
}