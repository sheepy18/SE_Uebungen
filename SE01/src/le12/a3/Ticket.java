package le12.a3;

public class Ticket {

    private static int price;
    private int parkTime;
    private Kunde k;

    public Ticket(Kunde k) {
        this.k = k;
    }

    public Ticket(int time, Kunde k) {
        parkTime = time;
        this.k = k;
    }

    public int getParkTime() {
        return parkTime;
    }
    public int getPrice() {
        return price;
    }
    public void setParkTime(int parkTime) {
        this.parkTime = parkTime;
    }
    public static void setPrice(int price) {
        Ticket.price = price;
    }
    public int calcPrice() {
        return price * parkTime;
    }

    public Kunde getK() {
        return k;
    }
}
