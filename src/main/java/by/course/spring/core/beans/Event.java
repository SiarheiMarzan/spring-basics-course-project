package by.course.spring.core.beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    public static boolean isDay(int start, int end) {
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }

    public Event(Date date, DateFormat df) {
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.dateFormat = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", msg=" + msg + ", date=" + dateFormat.format(date) + "]";
    }
}
