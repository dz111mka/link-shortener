package ru.chepikov.linkshortener;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.chepikov.linkshortener.service.LinkInfoService;
import ru.chepikov.linkshortener.service.impl.LogExecutionTimeLinkInfoServiceProxy;

@SpringBootApplication
public class LinkShortenerApp {

    @Autowired
    @Qualifier("linkInfoServiceProxy")
    private LinkInfoService service;

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class, args);

    }

    @PostConstruct
    public void pc() {
        LogExecutionTimeLinkInfoServiceProxy proxy = new LogExecutionTimeLinkInfoServiceProxy(service);
        System.out.println(proxy.getByShortLink("qweqwe"));
    }
}