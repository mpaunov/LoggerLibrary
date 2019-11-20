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

public class AppenderType {
    private Scanner scanner;

    public AppenderType(Scanner scanner) {
        this.scanner = scanner;
    }

    public Logger invoke() {
        int n = Integer.parseInt(scanner.nextLine());

        Logger logger = new MessageLogger();


        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String appenderType = tokens[0];

            Layout layout = tokens[1].equals("SimpleLayout")
                    ? new SimpleLayout()
                    : new XmlLayout();

            Appender appender;
            if (appenderType.equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
                if (tokens.length == 3) {
                    appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
                }
            } else {
                appender = new FileAppender(layout, new FileHelper());
            }
            logger.addAppender(appender);
        }
        return logger;
    }
}
