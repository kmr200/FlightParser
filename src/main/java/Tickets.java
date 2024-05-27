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

    public double getMean() {
        double sum = 0;

        for (Ticket ticket : tickets) {
            sum += ticket.getPrice();
        }

        return sum / tickets.size();
    }

    public double getMedian() {

        tickets.sort(Comparator.comparingInt(Ticket::getPrice));

        int size = tickets.size();
        if (size % 2 == 0) {
            return (tickets.get(size / 2 - 1).getPrice() + tickets.get(size / 2).getPrice()) / 2.0;
        } else {
            return tickets.get(size / 2).getPrice();
        }

    }

}
