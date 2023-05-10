package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository <Educacion, Long>{
    
}
