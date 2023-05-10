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
public class DtoEducacion {
    
    private Long id_educacion;
    private String institucion;
    private String logo;
    private String url;
    private String titulo;
    private String alcanceTitulo;
    private String fechaObt;
    private String comentario;
    //private Persona pers;
    private Long id_persona; //esto no sé si va
    
    
}
