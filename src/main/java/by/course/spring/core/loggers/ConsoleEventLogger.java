package by.course.spring.core.loggers;

import by.course.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
