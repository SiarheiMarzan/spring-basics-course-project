package by.course.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope("prototype")
public class Event {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String msg;

    @Autowired
    @Qualifier("newDate")
    private Date date;

    @Autowired
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.dateFormat = dateFormat;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", msg=" + msg + ", date="
                + (dateFormat != null ? dateFormat.format(date) : date) + "]";
    }
}
