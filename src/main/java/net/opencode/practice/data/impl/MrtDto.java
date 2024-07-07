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
public class MrtDto extends AbstractDto {

    @Min(1)
    @Max(1000)
    @Schema(example = "13", description = "Процентное содержание")
    double p;

    @Min(1)
    @Max(1000)
    @Schema(example = "10", description = "Объем ампулы")
    double ml;
}
