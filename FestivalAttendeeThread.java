package concurrency;


import java.util.LinkedList;

public class FestivalAttendeeThread implements Runnable {


    private LinkedList<TicketType> ticketList;

    public FestivalAttendeeThread(LinkedList<TicketType> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public void run() {

//        for (int i = 0; i < 20; i++) {
//            tickets = TicketType.getRandomTickets();
//           // System.out.println(Thread.currentThread().getName());
//            synchronized (ticketList) {
//                ticketList.add(tickets);
//            }
//            System.out.println("Ticket Type: " + tickets);
//            System.out.println("Type of Tickets purchased: " + ticketList);
//        }
        try {
            Thread.sleep(3000);
            System.out.println(ticketList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}



