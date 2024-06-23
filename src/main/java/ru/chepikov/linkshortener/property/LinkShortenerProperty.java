package ru.chepikov.linkshortener.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "link-shortener")
@Component
@Getter
@Setter
@NoArgsConstructor
public class LinkShortenerProperty {

    private int shortLinkLength;

}

