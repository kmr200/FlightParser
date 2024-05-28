import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        final Gson gson = new GsonBuilder().create();
        File file = new File("src/main/resources", "tickets.json");

        try (FileReader fileReader = new FileReader(file)) {
            Tickets tickets = gson.fromJson(fileReader, Tickets.class);

            //Sort tickets taking off from VVO and landing at TLV
            List<Ticket> VvoTlvTickets = tickets.getTickets().stream()
                    .filter(ticket -> ticket.getOrigin().equals("VVO"))
                    .filter(ticket -> ticket.getDestination().equals("TLV"))
                    .toList();

            /*Store tickets for each carrier in separate lists stored in
            HashMap<Carrier name, Array List with tickets>. The Lists are
            later used to find the minimal time it takes for each carrier.
             */
            Map<String, List<Ticket>> ticketsByCarrier = new HashMap<>();

            for (Ticket ticket : VvoTlvTickets) {
                String carrier = ticket.getCarrier();

                if (!ticketsByCarrier.containsKey(carrier)) {
                    ticketsByCarrier.put(carrier, new ArrayList<>());
                    ticketsByCarrier.get(carrier).add(ticket);
                } else {
                    ticketsByCarrier.get(carrier).add(ticket);
                }
            }

            System.out.println("Minimal flying time for every carrier in minutes:");

            //Compute minimal time for each carrier
            for (String carrier : ticketsByCarrier.keySet()) {
                List<Ticket> carrierTickets = ticketsByCarrier.get(carrier);
                carrierTickets.stream()
                        .min(Comparator.comparing(Ticket::getFlightDuration))
                        .ifPresent(minTicket -> System.out.println(carrier + " -> " + minTicket.getFlightDuration()));
            }

            System.out.println("Mean - Median = " + (tickets.getMean(VvoTlvTickets) - tickets.getMedian(VvoTlvTickets)));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
