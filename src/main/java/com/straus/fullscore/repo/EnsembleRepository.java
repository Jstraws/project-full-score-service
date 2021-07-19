package com.straus.fullscore.repo;

import com.straus.fullscore.model.Ensemble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnsembleRepository extends JpaRepository<Ensemble, Long> {
}
