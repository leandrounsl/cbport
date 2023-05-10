package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RIdioma extends JpaRepository <Idioma, Long>{
    
}
