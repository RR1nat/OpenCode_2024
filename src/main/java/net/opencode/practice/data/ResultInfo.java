package net.opencode.practice.data;


import io.swagger.v3.oas.annotations.media.Schema;

public record ResultInfo(@Schema(example = "Какой-то результат") String result) {
}