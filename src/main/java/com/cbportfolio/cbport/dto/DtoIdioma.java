
package com.cbportfolio.cbport.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class DtoIdioma {
    
    private Long id_idioma;
    private String idioma;
    private Double porcentaje;
    private String progreso;
    private String comentario;
   //private Persona pers;
    private Long id_persona; //esto no sé si va
   
    
}
