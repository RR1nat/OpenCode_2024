package net.opencode.practice.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorInfo;
import net.opencode.practice.data.CalculatorType;
import net.opencode.practice.data.ResultInfo;
import net.opencode.practice.data.impl.MrtDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/mrt")
@RestController
@RequiredArgsConstructor
@Validated
public class MrtCalculatorController {

    Map<CalculatorType, MedicalCalculatorService<?>> medicalCalculatorServices;
    @Operation(summary = "Gets calculator information", description = "Returns Mrt calculator information", tags = "info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorInfo.class)))
    })

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Этот калькулятор позволяет пересчитать процентное содержание вещества в заданном объеме раствора в миллиграммы.
                Расчеты исходят из того факта, что 1% любого вещества в среднем соответствует 10 мг вещества в растворе. 
                Также известно, что 1 мг (миллиграмм) = 1000 мкг (микрограмм), а 1 г (грамм) = 1000 мг (миллиграмм).
                """);
    }
    @Operation(summary = "Calculate result from your data",
            description = "Calculate Mrt result from your data",
            tags = "calculate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultInfo.class))),
            @ApiResponse(responseCode = "422",
                    description = "Validation exception",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))}
    )
    @SuppressWarnings("unchecked")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("result")
    public ResultInfo result(@Validated @RequestBody MrtDto dto) {
        var service = (MedicalCalculatorService<AbstractDto>) this.medicalCalculatorServices.get(CalculatorType.MRT);
        return service.calculate(dto);
    }
}
