package ru.chepikov.linkshortener.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.model.LinkInfo;
import ru.chepikov.linkshortener.service.LinkInfoService;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Service("linkInfoServiceProxy")
public class LogExecutionTimeLinkInfoServiceProxy implements LinkInfoService {

    LinkInfoService service;

    @Override
    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        try {
            return service.createLinkInfo(request);
        } finally {
            stopWatch.stop();
            log.info("method execution time of the createLinkInfo is {} ms", stopWatch.getTotalTimeMillis());
        }
    }

    @Override

    public LinkInfo getByShortLink(String shortLink) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        try {
            return service.getByShortLink(shortLink);
        } finally {
            stopWatch.stop();
            log.info("method execution time of the getByShortLink is {} ms", stopWatch.getTotalTimeMillis());
        }
    }
}
