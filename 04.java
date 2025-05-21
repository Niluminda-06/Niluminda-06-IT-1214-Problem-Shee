class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private boolean[] seats; 

    public BookingSystem() {
        tickets = new Ticket[10]; 
        seats = new boolean[10];  
    }

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return;
        }

        tickets[seatNumber - 1] = new Ticket(ticketNumber, customerName, seatNumber);
        seats[seatNumber - 1] = true;
        System.out.println("Ticket booked: " + customerName + " -> Seat " + seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && tickets[i].getTicketNumber() == ticketNumber) {
                System.out.println("Cancelling Ticket #" + ticketNumber + " for Seat " + tickets[i].getSeatNumber());
                seats[i] = false;
                tickets[i] = null;
                return;
            }
        }
        System.out.println("Ticket #" + ticketNumber + " not found.");
    }

    public void displayTickets() {
        System.out.println("\n--- Current Bookings ---");
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                System.out.println(ticket);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        system.cancelTicket(2);

        system.bookTicket(4, "David", 2);

        system.displayTickets();
    }
}
