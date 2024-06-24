package ru.chepikov.linkshortener.dto.common;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ValidationError {
    private String field;
    private String message;
}
