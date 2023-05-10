
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
public class DtoDomicilio {
    
    private Long id_domicilio;
    private String calle; 
    private String altura; 
    private String piso;
    private String localidad;
    private String provincia;
    private String mapa;
    //private Persona pers;
    private Long id_persona; //esto no sé si va
    
    
}
