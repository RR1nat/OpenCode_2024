//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.opencode.practice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.ImtDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/imt")
@RestController
@RequiredArgsConstructor
@Validated
public class ImtCalculatorController {

    Map<CalculatorType, MedicalCalculatorService> medicalCalculatorService;


    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Этот калькулятор позволяет быстро и просто рассчитать индекс массы тела(ИМТ).
                Формула I=m/h*h, где: m — масса тела в килограммах; h — рост в метрах; измеряется в кг/м².
                Калькулятор рачитывает показатели в следующих интервалах: рост не более 300 см; вес не менее 10 кг.
                """);
    }

    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody ImtDto dto) {
        var service = this.medicalCalculatorService.get(CalculatorType.IMT);
        return service.calculate(dto);
    }
}
