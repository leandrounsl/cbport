package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Habilidad;
import com.cbportfolio.cbport.dto.DtoHabilidad;
import com.cbportfolio.cbport.repository.RHabilidad;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidad implements IHabilidadService{
        
    @Autowired
    public RHabilidad habRepo;
    
    @Autowired
    public SPersona persoServ;
    
    
    @Override
    public List<Habilidad> list() {
        return habRepo.findAll();
    }
    
    /*public List<Habilidad> verHabilidades() {
        List<Habilidad> listaHabilidades = habRepo.findAll();
        return listaHabilidades;  
    }  */

    @Override
    public Habilidad getById(Long id) {
        return habRepo.findById(id).orElse(null);
    }
    
    /*public Habilidad buscarHabilidad(Long id) {
        Habilidad hab = habRepo.findById(id).orElse(null);
        return hab;
    } */
    
    @Override
    public void create(Habilidad habnew) {
        habRepo.save(habnew);
    }

    @Override
    public void delete(Long id) {
        habRepo.deleteById(id);
    }
    
    @Override
    public void edit(Habilidad hab) {
        habRepo.save(hab);
    }

     //DTOs
    
    @Override
    public List<DtoHabilidad> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoHabilidad> listahabdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Habilidad> listahab= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Habilidad hab: listahab){
            
            DtoHabilidad habdto =
            
            DtoHabilidad.builder()
                    .id_habilidad(hab.getId())
                    .span(hab.getSpan())
                    .nombreHab(hab.getNombreHab())
                    .porcentaje(hab.getPorcentaje())
                    .progreso(hab.getProgreso())
                    .id_persona(hab.getPers().getId())
                    //.personaId(hab.getPersonaId())
                    .build();
            listahabdto.add(habdto); 
        }
    return listahabdto;
    }
          
    @Override
    public void createDto(DtoHabilidad habdtonew){
    
        Habilidad habnew=
                
        Habilidad.builder()
                //.id(habdtonew.getId_habilidad())                
                .span(habdtonew.getSpan())
                .nombreHab(habdtonew.getNombreHab())
                .porcentaje(habdtonew.getPorcentaje())
                .progreso (habdtonew.getProgreso())
                .pers(persoServ.getById(habdtonew.getId_persona()))
                //.personaid(expedto.getPers().getId())
                //.personaId(habdtonew.getPersonaId())
                .build();
        this.create(habnew);
    }
    
    
    @Override
    public void editDto(DtoHabilidad habdto){
    
        //Busco la experiencia y la guardo en un objeto
        Habilidad habmod=this.getById(habdto.getId_habilidad());
                
        //Cargo los datos desde el DTO
        habmod.setSpan(habdto.getSpan());
        habmod.setNombreHab(habdto.getNombreHab());
        habmod.setPorcentaje(habdto.getPorcentaje());
        habmod.setProgreso(habdto.getProgreso());
        //habmod.setId_Persona(habdto.getId_persona()); // no sé si va   
        
        // Lo cargo a BD
        this.edit(habmod);
        
    }
    
    @Override
    public DtoHabilidad getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Habilidad habBuscada=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoHabilidad habBuscadaDTO =
             
             DtoHabilidad.builder()
                     .id_habilidad(habBuscada.getId())
                     .span( habBuscada.getSpan())
                     .nombreHab( habBuscada.getNombreHab())
                     .porcentaje( habBuscada.getPorcentaje())
                     .progreso( habBuscada.getProgreso())
                     .id_persona( habBuscada.getPers().getId())
                  .build();
    
             return habBuscadaDTO;   
     
    }
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
    
    //METODOS DTOs
    
    /*@Override
    public List<DtoHabilidad> verDtoHabilidades(){
    // Lista de DTOS
    List<DtoHabilidad> listahabdto = new ArrayList<>();
    // Lista de Entidades
    List<Habilidad> listahab = this.verHabilidades();
        
        for (Habilidad hab : listahab) {
            DtoHabilidad dto
                    = DtoHabilidad.builder()
                            .span(hab.getSpan())
                            .nombreHab(hab.getNombreHab())
                            .porcentaje(hab.getPorcentaje())
                            .progreso (hab.getProgreso())
                            .pers(hab.getPers())
                            .build();

            listahabdto.add(dto);
        }
        return listahabdto;
    }*/

    /*@Override
    public DtoHabilidad buscarDtoHabilidad(Long id) {
             throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearDtoHabilidad(DtoHabilidad dtohab) {
              
        DtoHabilidad newhab=
                DtoHabilidad.builder()
                        .sapn(dtohab.getSpan())
                        .nombreHab(dtohab.getNombreHab())
                        .porcentaje(dtohab.getPorcentaje())
                        .progreso(dtohab.getProgreso())
                        .pers(dtohab.getPers())         
                    .build();
        this.crearDtoHabilidad(newhab);
    }


    @Override
    public List<DtoHabilidad> verDtoHabilidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarDtoHabilidad(Long id) {  
        habRepo.deleteById(id);
    }
    

    @Override
    public void editarDtoHabilidad(DtoHabilidad dtohab) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    public void modificarHabilidadDTO(HabilidadDTO habilidadDTO){
        
        //Busco la habilidad y la guardo en un objeto
        Habilidad habilidadaModificar=this.buscarHabilidad(habilidadDTO.getId_habilidad());
        
        //Cargo los datos desde el DTO
        habilidadaModificar.setNombre(habilidadDTO.getNombre());
        habilidadaModificar.setPorcentaje(habilidadDTO.getPorcentaje());
        
        //Lo guardo en la base de datos
        this.modificarHabilidad(habilidadaModificar);
    }*/
}
      

   
    

   


    
