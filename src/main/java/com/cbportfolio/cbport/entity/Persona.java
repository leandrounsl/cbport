package com.cbportfolio.cbport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.persistence.OneToOne;

//import java.util.Date;
import java.util.List;
//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter
//alt + insert p constructor  
//@NoArgsConstructor
//@AllArgsConstructor
@Builder //(se usa en lugar de los constructores)
@Entity
@Table (name= "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String especialidad1;
    @Basic
    private String especialidad2;
    @Column (length=1000)
    private String sobreMi;
    @Column (length=1000)
    private String banner;
    //@Basic
    @Column (length=1000)
    private String imagen;
    @Basic
    private String telefono;
    @Basic
    private String email;
    /*@Temporal(TemporalType.DATE)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fecha_Nac;*/
    /*@Basic
    private String password;*/
    @Basic 
    private String fechaNac;

    //relaciones
       
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers")
    private List<Domicilio> listaDomicilios;
    
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers")
    private List<Experiencia> listaExperiencias;
    
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="id_persona")
    private List<Educacion> listaEducacion;
    
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="id_persona")
    private List<Proyecto> listaProyectos;
    
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="id_persona")
    private List<Habilidad> listaHabilidades;
    
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="id_persona")
    private List<Idioma> listaIdiomas;
    
    //@OneToMany(mappedBy="personaId", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @OneToMany(mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy="id_persona")
    private List<Red> listaRedes;
    
    @JsonIgnore
    @OneToOne(mappedBy="pers",fetch=FetchType.LAZY)
    //@OneToOne (mappedBy="pers", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST) 
    private Usuario username;
    
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String especialidad1, String especialidad2, String sobreMi, String banner, String imagen, String telefono, String email, /*String password,*/ String fechaNac, List<Domicilio> listaDomicilios, List<Experiencia> listaExperiencias, List<Educacion> listaEducacion, List<Proyecto> listaProyectos, List<Habilidad> listaHabilidades, List<Idioma> listaIdiomas, List<Red> listaRedes, Usuario username) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad1 = especialidad1;
        this.especialidad2 = especialidad2;
        this.sobreMi = sobreMi;
        this.banner = banner;
        this.imagen = imagen;
        this.telefono = telefono;
        this.email = email;
        //this.password = password;
        this.fechaNac = fechaNac;
        //esto no está en el ejemplo y no sé si va
        this.listaDomicilios = listaDomicilios;
        this.listaExperiencias = listaExperiencias;
        this.listaEducacion = listaEducacion;
        this.listaProyectos = listaProyectos;
        this.listaHabilidades = listaHabilidades;
        this.listaIdiomas = listaIdiomas;
        this.listaRedes = listaRedes;
        this.username = username;
        
        //en su lugar en el ejemplo figura esto, pero no estoy seguro si sigue siendo necesario si está lo anterior
        //acá lo q hace es declarar las claves foráneas como un ArrayList
        /*listaDomicilios= new ArrayList();
        listaExperiencias= new ArrayList();
        listaEducacion= new ArrayList();
        listaProyectos= new ArrayList();
        listaHabilidades= new ArrayList();
        listaIdiomas= new ArrayList();
        listaRedes= new ArrayList();*/
    }
        
}
