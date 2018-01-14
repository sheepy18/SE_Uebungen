package le12.a3.strategy;

import le12.a3.Ticket;

import java.util.List;
import java.util.function.BiFunction;

public class InsertionSortStrategy implements ISortStrategy {

    @Override
    public void sort(List<Ticket> ticket, BiFunction<Ticket, Ticket, Boolean> function) {
        for(int i = 0; i < ticket.size() - 1; i++) {
            for(int j = i + 1; j < ticket.size(); j++) {
                if(function.apply(ticket.get(i), ticket.get(j))) {
                    Ticket t = ticket.get(i);
                    ticket.set(i, ticket.get(j));
                    ticket.set(j, t);
                }
            }
        }
    }
}
