package by.course.spring.core.loggers;

import by.course.spring.core.beans.Event;

import java.util.Collection;
import java.util.Collections;

public class CombinedEventLogger extends AbstractLogger {

    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }

    }
    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
}
