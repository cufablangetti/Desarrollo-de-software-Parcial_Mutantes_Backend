package com.example.ParcialMutantes_Blangetti.Repositories;


import com.example.ParcialMutantes_Blangetti.Entities.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long> {

    Optional<Mutant> findByDna(String dna);

    Long countByIsMutant(boolean isMutant);
}
