package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoEducacion;
import com.cbportfolio.cbport.dto.DtoExperiencia;
import com.cbportfolio.cbport.entity.Educacion;
import com.cbportfolio.cbport.entity.Experiencia;
import com.cbportfolio.cbport.repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion implements IEducacionService {
    
    @Autowired
    public REducacion educRepo;
    //inyecta la dependencia del repo con el q vamos a trabajar
    @Autowired
    public SPersona persoServ;
    
    
    @Override
    public List<Educacion> list() {
        return educRepo.findAll();
    }
    
    /*public List<Educacion> verEducaciones() {
        List<Educacion> listaEducaciones = educRepo.findAll();
        return listaEducaciones;  
    }  */

    @Override
    public Educacion getById(Long id) {
        return educRepo.findById(id).orElse(null);
    }
    
    /*public Educacion buscarEducacion(Long id) {
        Educacion educ = educRepo.findById(id).orElse(null);
        return educ;
    }  */
    
    @Override
    public void create(Educacion educnew) {
        educRepo.save(educnew);
    }

    @Override
    public void delete(Long id) {
        educRepo.deleteById(id);
    }
    
    @Override
    public void edit(Educacion educ) {
        educRepo.save(educ);
    }
 
     //DTOs
    
    @Override
    public List<DtoEducacion> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoEducacion> listaeducdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Educacion> listaeduc= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Educacion educ: listaeduc){
            
            DtoEducacion educdto =
            
            DtoEducacion.builder()
                    .id_educacion(educ.getId())
                    .institucion(educ.getInstitucion())
                    .logo(educ.getLogo())
                    .url(educ.getUrl())
                    .titulo(educ.getTitulo())
                    .alcanceTitulo(educ.getAlcanceTitulo())
                    .fechaObt(educ.getFechaObt())
                    .comentario(educ.getComentario())                    
                    .id_persona(educ.getPers().getId())
                    //.personaId(educ.getPersonaId())              
                    .build();
            listaeducdto.add(educdto); 
        }
    return listaeducdto;
    }
     
    @Override
    public void createDto(DtoEducacion educdtonew){
    
        Educacion educnew=
                
        Educacion.builder()
                //.id(educdtonew.getId_educacion())
                .institucion(educdtonew.getInstitucion())
                .logo(educdtonew.getLogo())
                .url(educdtonew.getUrl())
                .titulo(educdtonew.getTitulo())
                .alcanceTitulo(educdtonew.getAlcanceTitulo())
                .fechaObt(educdtonew.getFechaObt())
                .comentario(educdtonew.getComentario()) 
                .pers(persoServ.getById(educdtonew.getId_persona()))
                //.personaid(expedto.getPers().getId())
                //.personaId(educdtonew.getPersonaId())
                .build();
        this.create(educnew);
    }
    
    
    @Override
    public void editDto(DtoEducacion educdto){
    
        //Busco la experiencia y la guardo en un objeto
        Educacion educmod=this.getById(educdto.getId_educacion());
                
        //Cargo los datos desde el DTO
        educmod.setInstitucion(educdto.getInstitucion());
        educmod.setLogo(educdto.getLogo());
        educmod.setUrl(educdto.getUrl());
        educmod.setTitulo(educdto.getTitulo());
        educmod.setAlcanceTitulo(educdto.getAlcanceTitulo());
        educmod.setFechaObt(educdto.getFechaObt());
        educmod.setComentario(educdto.getComentario());
        //educmod.setId_persona(educdto.getId_persona()); // no sé si va   
        
        // Lo cargo a BD
        this.edit(educmod);
        
    }
    
    @Override
    public DtoEducacion getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Educacion educBuscada=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoEducacion educBuscadaDTO =
             
             DtoEducacion.builder()
                     .id_educacion(educBuscada.getId())
                     .institucion(educBuscada.getInstitucion())
                     .logo( educBuscada.getLogo())
                     .url( educBuscada.getUrl())
                     .titulo( educBuscada.getTitulo())
                     .alcanceTitulo( educBuscada.getAlcanceTitulo())
                     .fechaObt( educBuscada.getFechaObt())
                     .comentario( educBuscada.getComentario())
                     .id_persona( educBuscada.getPers().getId())
                  .build();
    
             return educBuscadaDTO;   
     
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
}
