package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncOnField {

    private static final Logger log = LoggerFactory.getLogger(SyncOnField.class);
    private Object lock;

    private final int i;

    public SyncOnField(int i) {
        this.lock = new Object();
        synchronized (lock) { // this does not do what you expect!
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
