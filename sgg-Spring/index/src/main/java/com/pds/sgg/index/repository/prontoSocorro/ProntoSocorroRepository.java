package com.pds.sgg.index.repository.prontoSocorro;

import com.pds.sgg.index.entity.prontoSocorro.ProntoSocorro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProntoSocorroRepository extends JpaRepository<ProntoSocorro, Long> {
    
}
