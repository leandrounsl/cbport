package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository <Experiencia, Long>{
    
}
