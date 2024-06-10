package ru.chepikov.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.chepikov.LoggingConfiguration;
import ru.chepikov.LoggingConfigurationGradle;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class, args);

        LoggingConfiguration.testLog("Hi to all");
        LoggingConfigurationGradle.testLog("test");

    }
}