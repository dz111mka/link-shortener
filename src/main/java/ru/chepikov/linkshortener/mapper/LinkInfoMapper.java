package ru.chepikov.linkshortener.mapper;

import org.mapstruct.Mapper;
import ru.chepikov.linkshortener.dto.CreateShortLinkRequest;
import ru.chepikov.linkshortener.dto.CreateShortLinkResponse;
import ru.chepikov.linkshortener.model.LinkInfo;

@Mapper(componentModel = "spring")
public interface LinkInfoMapper {
    LinkInfo fromCreateRequest(CreateShortLinkRequest request);

    CreateShortLinkResponse toResponse(LinkInfo linkInfo);

}
