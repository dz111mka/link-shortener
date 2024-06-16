package ru.chepikov.linkshortener;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.model.LinkInfo;
import ru.chepikov.linkshortener.service.impl.LinkInfoServiceImpl;

@SpringBootApplication
public class LinkShortenerApp {

    @Autowired
    LinkInfoServiceImpl service;

    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class, args);

    }

    @PostConstruct
    public void pc() {
        LinkInfo linkInfo = service.createLinkInfo(new CreateShortLinkRequest());
        System.out.println(service.getByShortLink(linkInfo.getShortLink()).getShortLink());
    }

}