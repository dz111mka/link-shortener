package ru.chepikov.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.service.LinkInfoService;

import java.time.ZonedDateTime;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class, args);

        LinkInfoService linkService = new LinkInfoService();

        CreateShortLinkRequest shortLinkRequest = new CreateShortLinkRequest("google.com", ZonedDateTime.now(), "desc", true);

        System.out.println(linkService.getByShortLink(
                linkService.createLinkInfo(shortLinkRequest).getShortLink()));
    }
}