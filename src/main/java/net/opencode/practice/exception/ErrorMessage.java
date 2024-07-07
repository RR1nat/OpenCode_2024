package net.opencode.practice.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public record ErrorMessage(@Schema(example = "422") int statusCode,
                           @Schema(example = "2024-06-14T12:10:11.663+00:00") Date timestamp,
                           @Schema(example = "Error message") String message,
                           @Schema(example = "Error description") String description) {
}