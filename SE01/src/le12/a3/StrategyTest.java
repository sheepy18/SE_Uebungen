package le12.a3;

import le12.a3.strategy.BubbleSortStrategy;
import le12.a3.strategy.InsertionSortStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StrategyTest {

    PayList payed;
    List<Ticket> tickets;

    @Before
    public void setup() {
        payed = new PayList();
        payed.setTickets(generateTickets());
        tickets = new ArrayList<>();
    }

    private List<Ticket> generateTickets() {
        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new Ticket(20));
        tickets.add(new Ticket(15));
        tickets.add(new Ticket(23));
        tickets.add(new Ticket(28));
        tickets.add(new Ticket(10));

        return tickets;
    }

    @Test
    public void InsertionSortPreis() {
        payed.setTickets(generateTickets());
        payed.setSortStrategy(new InsertionSortStrategy());
        payed.sort((a,b) -> a.calcPrice() > b.calcPrice());
        tickets = payed.getTickets();

        assertTrue(tickets.get(0).calcPrice() <= tickets.get(1).calcPrice());
        assertTrue(tickets.get(1).calcPrice() <= tickets.get(2).calcPrice());
        assertTrue(tickets.get(2).calcPrice() <= tickets.get(3).calcPrice());
        assertTrue(tickets.get(3).calcPrice() <= tickets.get(4).calcPrice());
    }

    @Test
    public void InsertionSortDauer() {
        payed.setTickets(generateTickets());
        payed.setSortStrategy(new InsertionSortStrategy());
        payed.sort((a,b) -> a.getParkTime() > b.getParkTime());
        tickets = payed.getTickets();

        assertTrue(tickets.get(0).getParkTime() <= tickets.get(1).getParkTime());
        assertTrue(tickets.get(1).getParkTime() <= tickets.get(2).getParkTime());
        assertTrue(tickets.get(2).getParkTime() <= tickets.get(3).getParkTime());
        assertTrue(tickets.get(3).getParkTime() <= tickets.get(4).getParkTime());
    }

    @Test
    public void BubbleSortStrategyDauer() {
        payed.setTickets(generateTickets());
        payed.setSortStrategy(new BubbleSortStrategy());
        payed.sort((a,b) -> a.getParkTime() > b.getParkTime());
        tickets = payed.getTickets();

        assertTrue(tickets.get(0).getParkTime() <= tickets.get(1).getParkTime());
        assertTrue(tickets.get(1).getParkTime() <= tickets.get(2).getParkTime());
        assertTrue(tickets.get(2).getParkTime() <= tickets.get(3).getParkTime());
        assertTrue(tickets.get(3).getParkTime() <= tickets.get(4).getParkTime());
    }

    @Test
    public void BubbleSortStrategyPreis() {
        payed.setTickets(generateTickets());
        payed.setSortStrategy(new BubbleSortStrategy());
        payed.sort((a,b) -> a.calcPrice() > b.calcPrice());
        tickets = payed.getTickets();

        assertTrue(tickets.get(0).calcPrice() <= tickets.get(1).calcPrice());
        assertTrue(tickets.get(1).calcPrice() <= tickets.get(2).calcPrice());
        assertTrue(tickets.get(2).calcPrice() <= tickets.get(3).calcPrice());
        assertTrue(tickets.get(3).calcPrice() <= tickets.get(4).calcPrice());
    }
}
