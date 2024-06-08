package ru.chepikov.linkshortener.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class LinkInfo {
    UUID id;
    String link;
    ZonedDateTime endTime;
    String description;
    boolean active;
    String shortLink;
    long openingCount;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LinkInfo linkInfo)) return false;

        return new EqualsBuilder().append(id, linkInfo.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }

    @Override
    public String toString() {
        return "LinkInfo{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", shortLink='" + shortLink + '\'' +
                ", openingCount=" + openingCount +
                '}';
    }
}
