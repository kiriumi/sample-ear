package sample.ear.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Singleton
public class ExampleTimer {

    private final Logger looger = LogManager.getLogger();

    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void log() {
        looger.info("タイマー");
    }

}
