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
import net.opencode.practice.data.impl.FesDto;
import net.opencode.practice.service.MedicalCalculatorService;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/fes")
@RestController
@RequiredArgsConstructor
@Validated
public class FesCalculatorController {

    Map<CalculatorType, MedicalCalculatorService<?>> medicalCalculatorServices;

    @Operation(summary = "Gets calculator information", description = "Returns Fes calculator information", tags = "info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorInfo.class)))
    })

    @GetMapping("info")
    public CalculatorInfo get() {
        return new CalculatorInfo("""
                Алгоритм, позволяющий определить тип олигурии: преренальная, ренальная или постренальная.
                Оценка производится следующим образом: Фракционная экскреция натрия (FENa), % = 100 × (SCr × UNa ) / (SNa × UCr), где
                SCr - сывороточный креатинин; UNa - натрий мочи; SNa - натрий сыворотки; UCr - креатинин мочи.
                """);
    }

    @Operation(summary = "Calculate result from your data",
            description = "Calculate Fes result from your data",
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
    public ResultInfo result(@Validated @RequestBody FesDto dto) {
        var service = (MedicalCalculatorService<AbstractDto>) this.medicalCalculatorServices.get(CalculatorType.FES);
        return service.calculate(dto);
    }
}
