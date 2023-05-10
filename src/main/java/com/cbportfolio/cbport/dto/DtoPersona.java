package com.cbportfolio.cbport.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Builder
//alt + insert p constructor    
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class DtoPersona {
    
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String especialidad1;
    private String especialidad2; 
    private String sobreMi;
    private String banner;
    private String imagen;
    private String telefono;
    private String email;
    //private String password;
    private String fechaNac;
 
}
