
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
public class DtoExperiencia {
    
    private Long id_experiencia;
    private String empresa;
    private String logo;
    private String url;
    private String cargo;
    private String descPuesto;
    private String inicio;
    private String fin;
    //private Persona pers;
    private Long id_persona; //esto no sé si va
    
}
