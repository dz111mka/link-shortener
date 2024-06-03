package ru.chepikov.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.service.LinkService;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class, args);

        CreateShortLinkRequest request = new CreateShortLinkRequest();
        LinkService service = new LinkService();
        System.out.println(service.generateShortLink(request));
    }
}