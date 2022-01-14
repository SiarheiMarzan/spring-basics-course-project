package by.course.spring.core;

import by.course.spring.core.beans.Client;
import by.course.spring.core.beans.Event;
import by.course.spring.core.beans.EventType;
import by.course.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;

    private EventLogger defaultLogger;

    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event,"Some event for user 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event,"Some event for user 2");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event,"Some event for user 3");

        ctx.close();
    }

    private void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if(logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
