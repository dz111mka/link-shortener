package ru.chepikov.linkshortener.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CreateShortLinkRequest {
    String link;
    ZonedDateTime endTime;
    String description;
    boolean active;

}
