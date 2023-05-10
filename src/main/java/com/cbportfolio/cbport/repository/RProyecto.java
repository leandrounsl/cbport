package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository <Proyecto, Long>{
    
}
