package ru.chepikov.linkshortener.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CreateShortLinkRequest request = (CreateShortLinkRequest) o;

        return new EqualsBuilder().append(active, request.active).append(link, request.link).append(endTime, request.endTime).append(description, request.description).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(link).append(endTime).append(description).append(active).toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateShortLinkRequest.class.getSimpleName() + "[", "]")
                .add("link='" + link + "'")
                .add("endTime=" + endTime)
                .add("description='" + description + "'")
                .add("active=" + active)
                .toString();
    }
}
