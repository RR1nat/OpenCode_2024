package net.opencode.practice.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.ImtDto;
import net.opencode.practice.data.impl.MrtDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/mrt")
@RestController
@RequiredArgsConstructor
@Validated
public class MrtCalculatorController {

    Map<CalculatorType, MedicalCalculatorService> medicalCalculatorService;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы.
                Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе. 
                Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм).
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody MrtDto dto) {
        var service = this.medicalCalculatorService.get(CalculatorType.MRT);
        return service.calculate(dto);
    }
}
