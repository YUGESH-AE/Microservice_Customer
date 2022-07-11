package com.example.demo.commons;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanDto {
        Integer planId;
        String planName;
        Integer nationalRate;
        Integer localRate;

}
