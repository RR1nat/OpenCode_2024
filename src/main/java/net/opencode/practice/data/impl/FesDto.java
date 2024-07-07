package net.opencode.practice.data.impl;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class FesDto extends AbstractDto {

    @Min(1)
    @Max(1000)
    @Schema(example = "136", description = "Натрий сыворотки")
    int serumSodium;

    @Min(1)
    @Max(1000)
    @Schema(example = "62", description = "Креатинин сыворотки")
    int serumCreatinine;

    @Min(1)
    @Max(1000)
    @Schema(example = "100", description = "Натрий мочи")
    int urineSodium;

    @Min(1)
    @Max(10000)
    @Schema(example = "1768", description = "Креатинин мочи")
    int urineCreatinine;

}
