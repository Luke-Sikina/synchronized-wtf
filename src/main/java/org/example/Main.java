package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        log.info("Running first set of sync things. Note how multiple things start at the same time.");
        List<Integer> bad = IntStream.range(0, 20)
                .boxed()
                .parallel()
                .map(SyncOnField::new)
                .map(SyncOnField::get)
                .toList();

        log.info("Running second set of sync things. Note how the mutex works, and only one thing is running at once");
        List<Integer> better = IntStream.range(0, 20)
                .boxed()
                .parallel()
                .map(SyncOnSomethingStatic::new)
                .map(SyncOnSomethingStatic::get)
                .toList();

    }
}