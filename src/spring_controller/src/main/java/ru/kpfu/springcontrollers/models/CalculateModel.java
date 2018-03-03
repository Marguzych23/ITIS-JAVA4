package ru.kpfu.springcontrollers.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Component
public class CalculateModel {
    private double firstNumber;
    private double secondNumber;
    private String mathOperation;

}
