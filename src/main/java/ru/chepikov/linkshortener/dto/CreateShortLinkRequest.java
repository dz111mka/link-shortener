package ru.chepikov.linkshortener.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortLinkRequest {

    @NotEmpty(message = "Ссылка не может быть пустой")
    @Size(min = 10, max = 4096, message = "Длина ссылки не может быть меньше 10 и больше 4096")
    @Pattern(regexp = "https?://.+\\..+", message = "Ссылка не соответсвует паттерну URL")
    String link;
    @Future(message = "дата окончания ссылки должна быть в будущем")
    ZonedDateTime endTime;
    @NotEmpty(message = "Описание не может быть пустым")
    String description;
    @NotNull(message = "Не может быть пустым")
    Boolean active;


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
