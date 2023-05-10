package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Red;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRed extends JpaRepository <Red, Long>{
    
}
