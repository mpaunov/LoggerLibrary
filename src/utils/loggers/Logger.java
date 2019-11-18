package utils.loggers;

import utils.enums.ReportLevel;
import utils.loggers.appenders.Appender;

public interface Logger {
    void logError(String time, String message);
    void logInfo(String time, String message);
    void logWarning(String time, String message);
    void logCritical(String time, String message);
    void logFatal(String time, String message);

    void addAppender(Appender appender);
}
