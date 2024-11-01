package com.example.ParcialMutantes_Blangetti.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import com.example.ParcialMutantes_Blangetti.validators.ValidDna;

@Getter
@Setter
public class MutantRequestDto {
    @Valid
    @ValidDna
    private String[] dna;
}
