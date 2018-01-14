package le12.a3.strategy;

import le12.a3.Ticket;

import java.util.List;
import java.util.function.BiFunction;

public class BubbleSortStrategy implements ISortStrategy {

    @Override
    public void sort(List<Ticket> ticket, BiFunction<Ticket, Ticket, Boolean> function) {
        int p = ticket.size()-1;
        while (p > 0) {
            int r = p;
            p = 0;
            for (int i = 0; i < r; ++i) {
                if (function.apply(ticket.get(i),ticket.get(i+1))) {
                    Ticket t = ticket.get(i);
                    ticket.set(i, ticket.get(i+1));
                    ticket.set(i+1, t);
                    p = i;
                }
            }
        }
    }
}
