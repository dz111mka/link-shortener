package ru.chepikov.linkshortener.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortLinkRequest {
    String link;
    ZonedDateTime endTime;
    String description;
    boolean active;
}
