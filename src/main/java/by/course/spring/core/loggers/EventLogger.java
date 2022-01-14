package by.course.spring.core.loggers;

import by.course.spring.core.beans.Event;

public interface EventLogger {
    public void logEvent(Event event);
    public String getName();
}
