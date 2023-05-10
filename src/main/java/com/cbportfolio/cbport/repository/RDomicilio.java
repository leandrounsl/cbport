
package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDomicilio extends JpaRepository <Domicilio, Long>{
    
}
