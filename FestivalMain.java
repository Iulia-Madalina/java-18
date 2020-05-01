package concurrency;


import java.util.LinkedList;

public class FestivalMain {

    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();
        final TicketType[] tickets = new TicketType[1];

        LinkedList<TicketType> ticketList = gate.getTicketList();


        FestivalAttendeeThread t1 = new FestivalAttendeeThread(ticketList);
        FestivalStatisticsThread t2 = new FestivalStatisticsThread(ticketList);

        Thread festivalAttendee  = new Thread(t1);
        Thread statsThread = new Thread(t2);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {

                tickets[0] = TicketType.getRandomTickets();
                synchronized (ticketList) {
                    ticketList.add(tickets[0]);
                }
                System.out.println(Thread.currentThread().getName() + " :Ticket Type: " + tickets[0]);

            }).start();
        }

        festivalAttendee.start();
        if (ticketList.isEmpty()) {
            System.out.println("Nobody is here!");
        } else {
            statsThread.start();
        }

        // tt1.join();
        //tt2.join();

    }
}


