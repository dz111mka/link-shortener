package ru.chepikov.linkshortener.repository.impl;

import org.springframework.stereotype.Repository;
import ru.chepikov.linkshortener.model.LinkInfo;
import ru.chepikov.linkshortener.repository.LinkInfoRepository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LinkInfoRepositoryImpl implements LinkInfoRepository {

    private final Map<String, LinkInfo> data = new ConcurrentHashMap<>();

    @Override
    public Optional<LinkInfo> findByShortLink(String shortLink) {
        return Optional.ofNullable(data.get(shortLink));
    }

    @Override
    public LinkInfo save(LinkInfo linkInfo) {
        linkInfo.setId(UUID.randomUUID());
        data.put(linkInfo.getShortLink(), linkInfo);
        return linkInfo;
    }
}
