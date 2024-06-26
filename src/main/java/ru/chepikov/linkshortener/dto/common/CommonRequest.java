package ru.chepikov.linkshortener.dto.common;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class CommonRequest<T> {

    @Valid
    private T body;
}
