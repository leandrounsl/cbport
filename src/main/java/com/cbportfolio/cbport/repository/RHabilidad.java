package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidad extends JpaRepository <Habilidad, Long>{
    
}
