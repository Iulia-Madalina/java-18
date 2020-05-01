package concurrency;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FestivalStatisticsThread implements Runnable {

    private LinkedList<TicketType> ticketList;
    FestivalGate g = new FestivalGate();

    public FestivalStatisticsThread(LinkedList<TicketType> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public void run() {

        //ticketList = g.getTicketList();

        Map<TicketType, Long> counts = new ConcurrentHashMap<>();
        counts = ticketList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(Thread.currentThread().getName());



        try {
            Thread.sleep(2000);
            System.out.println(ticketList.size() + " participants entered");
            System.out.println(counts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
