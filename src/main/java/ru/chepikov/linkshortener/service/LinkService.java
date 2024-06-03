package ru.chepikov.linkshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.utils.Constant;

public class LinkService {

    public String generateShortLink(CreateShortLinkRequest request) {
        return RandomStringUtils.randomAlphanumeric(Constant.STRING_LENGTH);
    }
}
