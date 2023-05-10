
package com.cbportfolio.cbport.repository;

import com.cbportfolio.cbport.entity.Usuario;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RUsuario extends JpaRepository <Usuario, Long> {
     //public List<Usuario> findByUsernameAndPassword(String username, String password);
}
