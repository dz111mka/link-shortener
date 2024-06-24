package ru.chepikov.linkshortener.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.chepikov.linkshortener.service.impl.LinkInfoService;

@Configuration
public class LinkShortenerConfig {

    @Autowired
    private LinkInfoService service;

    @PostConstruct
    public void pc() {
        System.out.println(service);
    }
}
