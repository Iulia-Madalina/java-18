package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerMain {
    private static final Logger logger = LogManager.getLogger(LoggerMain.class.getName());


    public static void main(String[] args) {


        logger.info("Simple User ->");
        User user = new User("simple_username", "12345654321", 0);
        logger.info(user);
        if (user.getGrade() < 1) {
            logger.error("Grade should be a positive number!");
        }
        logger.debug("This is a debug message in case you need it!");

        logger.fatal("That's it!");


    }
}
