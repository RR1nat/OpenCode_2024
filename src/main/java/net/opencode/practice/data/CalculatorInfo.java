package net.opencode.practice.data;

import io.swagger.v3.oas.annotations.media.Schema;

public record CalculatorInfo(@Schema(example = "Калькулятор расчета") String info) {
}