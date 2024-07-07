package net.opencode.practice.service;


import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;

public interface MedicalCalculatorService<T extends AbstractDto> {

    ResultInfo calculate(T dto);

    CalculatorType getCalculatorType();
}
