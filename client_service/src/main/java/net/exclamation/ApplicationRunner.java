package net.exclamation;

import org.springframework.boot.CommandLineRunner;

public class ApplicationRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("RUN Application runner...");
    }
}
