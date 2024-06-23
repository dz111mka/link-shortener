package ru.chepikov.linkshortener.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CreateShortLinkResponse that = (CreateShortLinkResponse) o;

        return new EqualsBuilder().append(active, that.active).append(id, that.id).append(link, that.link).append(endTime, that.endTime).append(description, that.description).append(shortLink, that.shortLink).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(link).append(endTime).append(description).append(active).append(shortLink).toHashCode();
    }
}
