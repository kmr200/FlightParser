import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tickets {

    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getMean(List<Ticket> tickets) {
        double sum = 0;

        for (Ticket ticket : tickets) {
            sum += ticket.getPrice();
        }

        return sum / tickets.size();
    }

    public double getMedian(List<Ticket> tickets) {
        // Create a mutable copy of the ticket's list
        List<Ticket> sortedTickets = new ArrayList<>(tickets);

        sortedTickets.sort(Comparator.comparingInt(Ticket::getPrice));

        int size = sortedTickets.size();
        if (size == 0) {
            return 0;
        }

        if (size % 2 == 0) {
            return (sortedTickets.get(size / 2 - 1).getPrice() + sortedTickets.get(size / 2).getPrice()) / 2.0;
        } else {
            return sortedTickets.get(size / 2).getPrice();
        }
    }

}
