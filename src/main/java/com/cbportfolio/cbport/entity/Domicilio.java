
package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String calle;
    @Basic
    private String altura;
    @Basic
    private String piso;
    @Basic
    private String localidad;
    @Basic
    private String provincia;
    @Column (length=1000)
    private String mapa;
    
    //relacion con Persona  
    //NO SÉ SI VA: private Persona pers; o private Long personaId;
    /*creación de objeto 
    private Persona pers;*/
    /*en teoría no tengo q traer un objeto persona sino un dato 
    por eso no sería private Persona pers; 
    y sí en cambio private Long personaId; q es un dato
    Porque perosona trae todo, el domicilio no me va a traer la persona sino q la persona trae al domicilio
    */
   
    //@ManyToOne()
    //@Column(name="persona_id") //anotation p ponerle otro nombre a la columna en la BD
    //private Long id_persona;
    //@JoinColumn(name = "persona_id")esta es p ponerle otro nombre a la columna en la BD 
    //para que se borre si borra persona: @OnDelete(action = OnDeleteAction.CASCADE)
    
    @ManyToOne()
    @JoinColumn(name="id_persona") //anotation p ponerle otro nombre a la columna en la BD
    private Persona pers;
    //private Long id_persona;
    
    //para que se borre si borra persona: @OnDelete(action = OnDeleteAction.CASCADE)
   

     
}
