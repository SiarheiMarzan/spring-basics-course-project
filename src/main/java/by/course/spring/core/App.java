package by.course.spring.core;

import by.course.spring.core.beans.Client;
import by.course.spring.core.loggers.ConsoleEventLogger;
import by.course.spring.core.loggers.EventLogger;

public class App {

    private Client client;

    private EventLogger eventLogger;
    public App(){}

    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
