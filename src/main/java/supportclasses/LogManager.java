package supportclasses;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

public class LogManager {
    public Logger logger;

    public LogManager() {
        logger = Logger.getLogger(Log.class.getName());
    }
}