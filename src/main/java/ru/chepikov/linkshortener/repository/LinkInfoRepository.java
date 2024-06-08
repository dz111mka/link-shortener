package ru.chepikov.linkshortener.repository;

import ru.chepikov.linkshortener.model.LinkInfo;

import java.util.Optional;

public interface LinkInfoRepository {

    Optional<LinkInfo> findByShortLink(String shortLink);

    LinkInfo save(LinkInfo linkInfo);
}
