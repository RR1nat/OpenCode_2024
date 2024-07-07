package net.opencode.practice.service.impl;

import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.ImtDto;
import net.opencode.practice.data.impl.MrtDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MrtCalculator implements MedicalCalculatorService<MrtDto> {

    @Override
    public ResultInfo calculate(MrtDto dto){
        var percentage = dto.getP() / 100;
        var volume = dto.getMl();
        var result = percentage * volume * 1000;
        var result2 = result * 1000;

        return new ResultInfo("%s миллиграммов \n %s микрограммов".formatted(result, result2));
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.MRT;
    }

}
