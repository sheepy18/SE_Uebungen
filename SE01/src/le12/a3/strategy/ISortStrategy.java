package le12.a3.strategy;

import le12.a3.Ticket;

import java.util.List;
import java.util.function.BiFunction;

public interface ISortStrategy {
     void sort(List<Ticket> ticket, BiFunction<Ticket, Ticket, Boolean> function);
}
