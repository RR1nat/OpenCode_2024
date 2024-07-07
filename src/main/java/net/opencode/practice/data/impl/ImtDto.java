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
public class ImtDto extends AbstractDto {

    @Min(1)
    @Max(1000)
    @Schema(example = "63", description = "Масса")
    int weight;

    @Min(1)
    @Max(1000)
    @Schema(example = "175", description = "Рост")
    int height;
}

