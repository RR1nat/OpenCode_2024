package net.opencode.practice.configuration;

import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MedicalCalculatorConfiguration {

    @Bean
    public Map<CalculatorType, MedicalCalculatorService> medicalCalculatorServices(List<MedicalCalculatorService> handlers) {
        var map = new HashMap<CalculatorType, MedicalCalculatorService>();

        for (var handler : handlers) {
            map.compute(handler.getCalculatorType(), (calculatorType, medicalCalculatorService) -> {
                if (medicalCalculatorService == null) medicalCalculatorService = handler;

                return medicalCalculatorService;
            });
        }

        return map;
    }
}