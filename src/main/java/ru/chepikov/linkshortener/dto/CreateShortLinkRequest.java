package ru.chepikov.linkshortener.dto;

import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class CreateShortLinkRequest {
    String link;
    ZonedDateTime endTime;
    String description;
    boolean active;

}
