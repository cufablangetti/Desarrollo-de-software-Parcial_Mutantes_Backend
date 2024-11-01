package com.example.ParcialMutantes_Blangetti.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsResponse {
    private Long countMutantDna;
    private Long countHumanDna;
    private Double ratio;
}

