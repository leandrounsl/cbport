package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoProyecto;
import com.cbportfolio.cbport.entity.Proyecto;
import com.cbportfolio.cbport.repository.RProyecto;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto implements IProyectoService{
    
    @Autowired
    public RProyecto proyRepo;
    
    @Autowired
    public SPersona persoServ;
    
    
    @Override
    public List<Proyecto> list() {
        return proyRepo.findAll();
    }
    
    /*public List<Proyecto> verProyectos() {
        List<Proyecto> listaProyectos = proyRepo.findAll();
        return listaProyectos;  
    }  */

    @Override
    public Proyecto getById(Long id) {
        return proyRepo.findById(id).orElse(null);
    }
    
    /*public Proyecto buscarProyecto(Long id) {
        Proyecto proy = proyRepo.findById(id).orElse(null);
        return proy;
    }  */
    
    @Override
    public void create(Proyecto proynew) {
        proyRepo.save(proynew);
    }

    @Override
    public void delete(Long id) {
        proyRepo.deleteById(id);
    }
    
    @Override
    public void edit(Proyecto proy) {
        proyRepo.save(proy);
    }

     //DTOs
    
    @Override
    public List<DtoProyecto> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoProyecto> listaproydto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Proyecto> listaproy= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Proyecto proy: listaproy){
            
            DtoProyecto proydto =
            
            DtoProyecto.builder()
                    .id_proyecto(proy.getId())
                    .tituloProyecto(proy.getTituloProyecto())
                    .imagen(proy.getImagen())
                    .url(proy.getUrl())
                    .destinatario(proy.getDestinatario())
                    .descProyecto(proy.getDescProyecto())
                    .periodoDesarrollo(proy.getPeriodoDesarrollo())
                    .id_persona(proy.getPers().getId())
                    //.personaId(proy.getPersonaId())
                    .build();
            listaproydto.add(proydto); 
        }
    return listaproydto;
    }
          
    @Override
    public void createDto(DtoProyecto proydtonew){
    
        Proyecto proynew=
                
        Proyecto.builder()
                //.id(proydtonew.getId_proyecto())
                .tituloProyecto(proydtonew.getTituloProyecto())
                .imagen(proydtonew.getImagen())
                .url(proydtonew.getUrl())
                .destinatario(proydtonew.getDestinatario())
                .descProyecto(proydtonew.getDescProyecto())
                .periodoDesarrollo(proydtonew.getPeriodoDesarrollo())
                .pers(persoServ.getById(proydtonew.getId_persona()))
                //.personaid(expedto.getPers().getId())
                //.personaId(proydtonew.getPersonaId())
                .build();
        this.create(proynew);
    }              
    
    @Override
    public void editDto(DtoProyecto proydto){
    
        //Busco la experiencia y la guardo en un objeto
        Proyecto proymod=this.getById(proydto.getId_proyecto());
                
        //Cargo los datos desde el DTO
        proymod.setTituloProyecto(proydto.getTituloProyecto());
        proymod.setImagen(proydto.getImagen());
        proymod.setUrl(proydto.getUrl());
        proymod.setDestinatario(proydto.getDestinatario());
        proymod.setDescProyecto(proydto.getDescProyecto());
        proymod.setPeriodoDesarrollo(proydto.getPeriodoDesarrollo());
        //proymod.setId_persona(proydto.getId_persona()); // no sé si va   
        
        // Lo cargo a BD
        this.edit(proymod);
        
    }
    
    @Override
    public DtoProyecto getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Proyecto proyBuscado=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoProyecto proyBuscadoDTO =
             
             DtoProyecto.builder()
                     .id_proyecto(proyBuscado.getId())
                     .tituloProyecto( proyBuscado.getTituloProyecto())
                     .imagen( proyBuscado.getImagen())
                     .url( proyBuscado.getUrl())
                     .destinatario( proyBuscado.getDestinatario())
                     .descProyecto( proyBuscado.getDescProyecto())
                     .periodoDesarrollo( proyBuscado.getPeriodoDesarrollo())
                     .id_persona( proyBuscado.getPers().getId())
                  .build();
    
             return proyBuscadoDTO;   
     
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
   
}
