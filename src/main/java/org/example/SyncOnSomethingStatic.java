package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncOnSomethingStatic {

    private static final Logger log = LoggerFactory.getLogger(SyncOnSomethingStatic.class);
    private static final Object lock = new Object();

    private final int i;

    public SyncOnSomethingStatic(int i) {
        synchronized (lock) { // much better
            log.info("Start: {}", i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                log.error("nuts");
            }
            log.info("Stop: {}", i);
        }
        this.i = i;
    }

    public int get() {
        return i;
    }
}
