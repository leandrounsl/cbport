package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoRed;
import com.cbportfolio.cbport.entity.Red;
import com.cbportfolio.cbport.repository.RRed;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRed implements IRedService{
    
    @Autowired
    public RRed redRepo;
    
    @Autowired
    public SPersona persoServ;
    
    //ENTIDADES
    
    @Override
    public List<Red> list() {
        return redRepo.findAll();
    }
    
    /*public List<Red> verRedes() {
        List<Red> listaRedes = redRepo.findAll();
        return listaRedes;  
    }  */
    
    @Override
    public Red getById(Long id) {
        return redRepo.findById(id).orElse(null);
    }
    
    /*public Red buscarRed(Long id) {
        Red net = redRepo.findById(id).orElse(null);
        return net;
    }  */

    @Override
    public void create(Red netnew) {
        redRepo.save(netnew);
    }

    @Override
    public void delete(Long id) {
        redRepo.deleteById(id);
    }
    
    @Override
    public void edit(Red net) {
        redRepo.save(net);
    }

     //DTOs
    
    @Override
    public List<DtoRed> listDto(){
    // Lista Redes dsd DTO
        List<DtoRed> listareddto = new ArrayList<>();
        
        // Lista Redes dsd Entidad
        List<Red> listared= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Red red: listared){
            
            DtoRed reddto =
            
            DtoRed.builder()
                    .id_red(red.getId())
                    .nombreRed(red.getNombreRed())
                    .span(red.getSpan())
                    .url(red.getUrl())
                    .id_persona(red.getPers().getId())
                    //.personaId(red.getPersonaId())
                    .build();
            listareddto.add(reddto); 
        }
    return listareddto;
    }
                   
    
    @Override
    public void createDto(DtoRed reddtonew){
    
        Red rednew=
                
        Red.builder()
                //.id(reddtonew.getId_red())
                .nombreRed(reddtonew.getNombreRed())
                .span(reddtonew.getSpan())
                .url(reddtonew.getUrl())
                .pers(persoServ.getById(reddtonew.getId_persona()))
                //.personaid(expedto.getPers().getId())*/
                //.id_persona(reddtonew.getId_persona())
                .build();
        this.create(rednew);
    }
    
    @Override
    public void editDto(DtoRed reddto){
    
        //Busco la experiencia y la guardo en un objeto
        Red redmod=this.getById(reddto.getId_red());
                
        //Cargo los datos desde el DTO
        redmod.setNombreRed(reddto.getNombreRed());
        redmod.setSpan(reddto.getSpan());
        redmod.setUrl(reddto.getUrl());
        //redmod.setId_persona(reddto.getId_persona()); // no sé si va   
        
        // Lo cargo a BD
        this.edit(redmod); 
    }
    
    @Override
    public DtoRed getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Red redBuscada=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoRed redBuscadaDTO =
             
             DtoRed.builder()
                     .id_red(redBuscada.getId())
                     .nombreRed( redBuscada.getNombreRed())
                     .span( redBuscada.getSpan())
                     .url( redBuscada.getUrl())
                     .id_persona( redBuscada.getPers().getId())
                  .build();
    
             return redBuscadaDTO;   
     
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
}
