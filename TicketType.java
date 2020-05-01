package concurrency;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;



    public static TicketType getRandomTickets() {
        int pick = new Random().nextInt(TicketType.values().length);
        return TicketType.values()[pick];
    }

}