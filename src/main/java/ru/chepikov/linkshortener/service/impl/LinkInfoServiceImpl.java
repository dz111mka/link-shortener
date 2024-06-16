package ru.chepikov.linkshortener.service.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.chepikov.linkshortener.beanpostprocessor.LogExecutionTime;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.exeption.NotFoundException;
import ru.chepikov.linkshortener.model.LinkInfo;
import ru.chepikov.linkshortener.repository.LinkInfoRepository;

@Service
public class LinkInfoServiceImpl{

    @Value("${link-shortener.short-link-length}")
    static int shortLinkLength;

    @Autowired
    LinkInfoRepository repository;

    public LinkInfoServiceImpl() {
    }

    @LogExecutionTime
    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.isActive());
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(shortLinkLength));

        return repository.save(linkInfo);
    }

    @LogExecutionTime
    public LinkInfo getByShortLink(String shortLink) {
        return repository.findByShortLink(shortLink)
                .orElseThrow(
                        () -> new NotFoundException(String.format("do not found short link %s", shortLink))
                );
    }
}
