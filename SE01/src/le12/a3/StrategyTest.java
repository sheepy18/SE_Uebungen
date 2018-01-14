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

        tickets.add(new Ticket(20, new Kunde("Lukas")));
        tickets.add(new Ticket(15, new Kunde("Lars")));
        tickets.add(new Ticket(23, new Kunde("Patrick")));
        tickets.add(new Ticket(28, new Kunde("Max")));
        tickets.add(new Ticket(10, new Kunde("Lukas")));

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

    @Test
    public void sortName() {
        //BubbleSort
        payed.setTickets(generateTickets());
        payed.setSortStrategy(new BubbleSortStrategy());
        payed.sort((a, b) -> a.getK().getName().compareTo(b.getK().getName()) > 0);
        tickets = payed.getTickets();

        assertTrue(tickets.get(0).getK().getName().compareTo(tickets.get(1).getK().getName()) <= 0);
        assertTrue(tickets.get(1).getK().getName().compareTo(tickets.get(2).getK().getName()) <= 0);
        assertTrue(tickets.get(2).getK().getName().compareTo(tickets.get(3).getK().getName()) <= 0);
        assertTrue(tickets.get(3).getK().getName().compareTo(tickets.get(4).getK().getName()) <= 0);

        //InsertionSort
        payed.setTickets(generateTickets());
        payed.setSortStrategy(new InsertionSortStrategy());
        payed.sort((a, b) -> a.getK().getName().compareTo(b.getK().getName()) > 0);
        tickets = payed.getTickets();

        assertTrue(tickets.get(0).getK().getName().compareTo(tickets.get(1).getK().getName()) <= 0);
        assertTrue(tickets.get(1).getK().getName().compareTo(tickets.get(2).getK().getName()) <= 0);
        assertTrue(tickets.get(2).getK().getName().compareTo(tickets.get(3).getK().getName()) <= 0);
        assertTrue(tickets.get(3).getK().getName().compareTo(tickets.get(4).getK().getName()) <= 0);
    }
}
