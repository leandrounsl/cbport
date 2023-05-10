
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
public class DtoProyecto {
    
    private Long id_proyecto;
    private String tituloProyecto;
    private String imagen; 
    private String url;
    private String destinatario;
    private String descProyecto;
    private String periodoDesarrollo; 
    //private Persona pers;
    private Long id_persona; //esto no sé si va
    
}
