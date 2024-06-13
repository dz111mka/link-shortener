package ru.chepikov.linkshortener.service;

import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.model.LinkInfo;

public interface LinkInfoService {

    LinkInfo createLinkInfo(CreateShortLinkRequest request);

    LinkInfo getByShortLink(String shortLink);
}
