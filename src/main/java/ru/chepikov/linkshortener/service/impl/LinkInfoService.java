package ru.chepikov.linkshortener.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.chepikov.linkshortener.beanpostprocessor.LogExecutionTime;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.dto.CreateShortLinkResponse;
import ru.chepikov.linkshortener.exeption.NotFoundException;
import ru.chepikov.linkshortener.model.LinkInfo;
import ru.chepikov.linkshortener.property.LinkShortenerProperty;
import ru.chepikov.linkshortener.repository.LinkInfoRepository;

@Service
public class LinkInfoService {

    @Autowired
    LinkShortenerProperty property;

    @Autowired
    LinkInfoRepository repository;

    public LinkInfoService() {
    }

    @LogExecutionTime
    public CreateShortLinkResponse createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setEndTime(request.getEndTime());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.isActive());
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(property.getShortLinkLength()));
        linkInfo.setOpeningCount(0L);

        repository.save(linkInfo);

        return CreateShortLinkResponse.builder()
                .id(linkInfo.getId())
                .link(linkInfo.getLink())
                .endTime(linkInfo.getEndTime())
                .description(linkInfo.getDescription())
                .active(linkInfo.isActive())
                .shortLink(linkInfo.getShortLink())
                .build();
    }

    @LogExecutionTime
    public LinkInfo getByShortLink(String shortLink) {
        return repository.findByShortLink(shortLink)
                .orElseThrow(
                        () -> new NotFoundException(String.format("do not found short link %s", shortLink))
                );
    }
}
