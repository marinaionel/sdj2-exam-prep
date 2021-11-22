package singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonLoggerV2 {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private SingletonLoggerV2() {
    }

    //    a class initialization occurs the first time we use one of its methods or fields
    private static class InstanceHolder {
        private static final SingletonLoggerV2 INSTANCE = new SingletonLoggerV2();
    }

    public static SingletonLoggerV2 getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void log(String msg) {
        LOGGER.log(Level.INFO, msg);
    }

}
