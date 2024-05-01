package net.opencode.practice.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.FesDto;
import net.opencode.practice.data.impl.ImtDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/fes")
@RestController
@RequiredArgsConstructor
@Validated
public class FesCalculatorController {

    Map<CalculatorType, MedicalCalculatorService> medicalCalculatorService;

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Алгоритм, позволяющий определить тип олигурии: преренальная, ренальная или постренальная.
                Оценка производится следующим образом: Фракционная экскреция натрия (FENa), % = 100 × (SCr × UNa ) / (SNa × UCr), где
                SCr - сывороточный креатинин; UNa - натрий мочи; SNa - натрий сыворотки; UCr - креатинин мочи.
                """);
    }


    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody FesDto dto) {
        var service = this.medicalCalculatorService.get(CalculatorType.FES);
        return service.calculate(dto);
    }
}
