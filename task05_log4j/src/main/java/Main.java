import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.trace("trace log");
        logger.debug("debug log ");
        logger.info("info log ");
        logger.warn("warn log ");
        logger.error("error log ");
        logger.fatal("fatal log ");

    }
}
