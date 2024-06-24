package ru.chepikov.linkshortener.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateShortLinkResponse {
    UUID id;
    String link;
    ZonedDateTime endTime;
    String description;
    boolean active;
    String shortLink;
}
