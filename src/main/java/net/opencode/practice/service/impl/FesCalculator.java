package net.opencode.practice.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.FesDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Service
public class FesCalculator implements MedicalCalculatorService {

    @Override
    public ResultInfo calculate(AbstractDto dto) {
        var fesDto = (FesDto) dto;
        var SCr = fesDto.getSerumCreatinine();
        var UNa = fesDto.getUrineSodium();
        var SNa = fesDto.getSerumSodium();
        var UCr = fesDto.getUrineCreatinine();
        var d1 = SCr * UNa * 100;
        var d2 = SNa * UCr;
        var result = BigDecimal.valueOf((double) d1 / d2).setScale(1, RoundingMode.HALF_UP);

        if (result.compareTo(BigDecimal.valueOf(1)) < 0)
            return new ResultInfo("%s Преренальная олигурия ".formatted(result));
        if (result.compareTo(BigDecimal.valueOf(4)) > 0)
            return new ResultInfo("%s Постренальная или обструктивная олигурия ".formatted(result));

        return new ResultInfo("%s Ренальная олигурия".formatted(result));
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.FES;
    }
}
