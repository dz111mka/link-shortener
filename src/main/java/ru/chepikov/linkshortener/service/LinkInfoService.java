package ru.chepikov.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.model.LinkInfo;
import ru.chepikov.linkshortener.repository.LinkInfoRepository;
import ru.chepikov.linkshortener.repository.impl.LinkInfoRepositoryImpl;
import ru.chepikov.linkshortener.utils.Constant;
import ru.chepikov.linkshortener.exeption.NotFoundException;

public class LinkInfoService {

    private final LinkInfoRepository linkInfoRepository = new LinkInfoRepositoryImpl();

    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.isActive());
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(Constant.SHORT_LINK_LENGTH));

        return linkInfoRepository.save(linkInfo);
    }

    public LinkInfo getByShortLink(String shortLink) {
        return linkInfoRepository.findByShortLink(shortLink)
                .orElseThrow(
                        () -> new NotFoundException("do not found short link")
                );
    }


}
