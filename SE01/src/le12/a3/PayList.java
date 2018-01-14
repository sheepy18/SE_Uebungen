package le12.a3;

import le12.a3.strategy.ISortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class PayList {
    List<Ticket> tickets;
    ISortStrategy sortStrategy;

    public PayList() {
        tickets = new ArrayList<>();
        Ticket.setPrice(1);
    }

    public void sort(BiFunction<Ticket, Ticket, Boolean> condition){
        sortStrategy.sort(tickets, condition);
    }

    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    public void setSortStrategy(ISortStrategy strategy) {
        sortStrategy = strategy;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
