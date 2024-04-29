package net.opencode.practice.data.impl;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;
import net.opencode.practice.data.CalculatorType;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ImtDto extends AbstractDto {

    int m;
    int h;
}

