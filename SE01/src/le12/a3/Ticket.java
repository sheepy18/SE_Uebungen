package le12.a3;

public class Ticket {

    private static int price;
    private int parkTime;

    public Ticket() {
    }

    public Ticket(int time) {
        parkTime = time;
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
}
