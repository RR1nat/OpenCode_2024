package net.opencode.practice.data.impl;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import net.opencode.practice.data.AbstractDto;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class FesDto extends AbstractDto {

    int serumSodium;
    int serumCreatinine;
    int urineSodium;
    int urineCreatinine;

}
