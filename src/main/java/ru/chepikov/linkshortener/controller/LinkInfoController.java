package ru.chepikov.linkshortener.controller;

import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.dto.CreateShortLinkResponse;
import ru.chepikov.linkshortener.dto.common.CommonRequest;
import ru.chepikov.linkshortener.dto.common.CommonResponse;
import ru.chepikov.linkshortener.service.impl.LinkInfoService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/link-infos")
public class LinkInfoController {

    private final LinkInfoService service;

    @PostMapping("/")
    public CommonResponse<CreateShortLinkResponse> postCreateShortLinkRequest(@RequestBody @Valid CommonRequest<CreateShortLinkRequest> request) {
        log.info("Поступил запрос на создание короткой ссылки {}", request);
        CreateShortLinkResponse response = service.createLinkInfo(request.getBody());
        return CommonResponse.<CreateShortLinkResponse>builder()
                .body(response)
                .build();
    }


}
