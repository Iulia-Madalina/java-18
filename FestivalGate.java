package concurrency;

import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class FestivalGate {

    private TicketType tickets;
    private LinkedList<TicketType> ticketList = new LinkedList<>();

    /**
     *Used the getRandomTickets method from Ticket Types Enum to generate random Ticket Types Enum
     * (I know I ended up not using this method)
     */
    public TicketType produce() {

        tickets = TicketType.getRandomTickets();
        //ticketList.add(tickets);

        return tickets;

    }

    /**
     *Used a stream to collect in a map Ticket Types and their frequency in the list
     * (I know I ended up not using this method)
     */
    public void show() {

        Map<TicketType, Long> counts =
                ticketList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println(ticketList.size() + "people entered");
        System.out.println(counts);
    }

    public LinkedList<TicketType> getTicketList() {
        return ticketList;
    }
}
