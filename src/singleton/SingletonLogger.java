package singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonLogger {

    //  the field needs to be volatile to prevent cache incoherence issues
    private static volatile SingletonLogger INSTANCE;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private SingletonLogger() {
    }

    public void log(String msg) {
        LOGGER.log(Level.INFO, msg);
    }

    //  Double-Checked Locking
    public static SingletonLogger getINSTANCE() {
//      start by verifying if we need to create the object in the first place and only in that case we would acquire the lock
        if (INSTANCE == null) {
            synchronized (SingletonLogger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLogger();
                }
            }
        }
        return INSTANCE;
    }
}
