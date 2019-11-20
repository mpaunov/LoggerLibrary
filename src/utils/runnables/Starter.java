package utils.runnables;

import utils.enums.ReportLevel;
import utils.helpers.FileHelper;
import utils.loggers.Logger;
import utils.loggers.MessageLogger;
import utils.loggers.appenders.Appender;
import utils.loggers.appenders.ConsoleAppender;
import utils.loggers.appenders.FileAppender;
import utils.loggers.layouts.Layout;
import utils.loggers.layouts.SimpleLayout;
import utils.loggers.layouts.XmlLayout;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logger logger = new AppenderType(scanner).invoke();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String time = tokens[1];
            String message = tokens[2];

            switch (reportLevel) {
                case INFO:
                    logger.logInfo(time, message);
                    break;
                case WARNING:
                    logger.logWarning(time, message);
                    break;
                case ERROR:
                    logger.logError(time, message);
                    break;
                case CRITICAL:
                    logger.logCritical(time, message);
                    break;
                case FATAL:
                    logger.logFatal(time, message);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(logger.toString());
    }


}
