package net.opencode.practice.service.impl;

import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.MrtDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MrtCalculator implements MedicalCalculatorService {

    @Override
    public ResultInfo calculate(AbstractDto dto){
        var mrtDto = (MrtDto) dto;
        var percentage = mrtDto.getP() / 100;
        var volume = mrtDto.getMl();
        var result = percentage * volume * 1000;
        var result2 = result * 1000;

        return new ResultInfo(result + " миллиграммов " + result2 + " микрограммов");
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.MRT;
    }

}
