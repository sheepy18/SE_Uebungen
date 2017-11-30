package le02.zeitNeu;

/**
 * Created by Lukas on 21.10.2017.
 */
public class Zeit implements ZeitIF {
    int minute;
    int hour;

    public Zeit() {

    }

    public Zeit(int hour, int minute) {
        if(minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }

        this.hour = hour;
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        String txt = "";
        if(hour < 10) {
            txt += "0" + hour;
        } else {
            txt += hour;
        }
        txt += ":";
        if(minute < 10) {
            txt += "0" + minute;
        } else {
            txt += minute;
        }
        return txt;
    }
}
