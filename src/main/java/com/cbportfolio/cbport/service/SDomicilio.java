package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoDomicilio;
import com.cbportfolio.cbport.entity.Domicilio;
import com.cbportfolio.cbport.repository.RDomicilio;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SDomicilio implements IDomicilioService {
    
    @Autowired
    public RDomicilio domicRepo;
    //inyecta la dependencia del repo con el q vamos a trabajar
    @Autowired
    public SPersona persoServ;
    
    //ENTIDADES
    
    @Override
    public List<Domicilio> list() {
        return domicRepo.findAll();
    }
    
    /*public List<Educacion> verEducaciones() {
        List<Educacion> listaEducaciones = educRepo.findAll();
        return listaEducaciones;  
    }  */

    @Override
    public Domicilio getById(Long id) {
        return domicRepo.findById(id).orElse(null);
    }
    
    /*public Educacion buscarEducacion(Long id) {
        Educacion educ = educRepo.findById(id).orElse(null);
        return educ;
    } */
    
    @Override
    public void create(Domicilio domicnew) {
        domicRepo.save(domicnew);
    }

    @Override
    public void delete(Long id) {
        domicRepo.deleteById(id);
    }
    
    @Override
    public void edit(Domicilio domic) {
        domicRepo.save(domic);
    }
    
     //DTOs
    
    @Override
    public List<DtoDomicilio> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoDomicilio> listadomicdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Domicilio> listadomic= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Domicilio domic: listadomic){
            
            DtoDomicilio domicdto =
            
            DtoDomicilio.builder()
                    .id_domicilio(domic.getId())
                    .calle(domic.getCalle())
                    .altura(domic.getAltura())
                    .piso(domic.getPiso())
                    .localidad(domic.getLocalidad())
                    .provincia(domic.getProvincia())
                    .mapa(domic.getMapa())
                    .id_persona(domic.getPers().getId())
                    //.personaId(domic.getPersonaId())
                    .build();
            listadomicdto.add(domicdto); 
        }
    return listadomicdto;
    }
          
    @Override
    public void createDto(DtoDomicilio domicdtonew){
    
        Domicilio domicnew=
                
        Domicilio.builder()
                //.id(domicdtonew.getId_domicilio())
                .calle(domicdtonew.getCalle())
                .altura(domicdtonew.getAltura())
                .piso(domicdtonew.getPiso())
                .localidad(domicdtonew.getLocalidad())
                .provincia(domicdtonew.getProvincia())
                .mapa(domicdtonew.getMapa())
                .pers(persoServ.getById(domicdtonew.getId_persona()))
                //.personaId(domicdtonew.getPers().getId())
                //.personaId(domicdtonew.getPersonaId())
                .build();
        this.create(domicnew);
    }         
    
    @Override
    public void editDto(DtoDomicilio domicdto){
    
        //Busco la experiencia y la guardo en un objeto
        Domicilio domicmod=this.getById(domicdto.getId_domicilio());
                
        //Cargo los datos desde el DTO
        domicmod.setCalle(domicdto.getCalle());
        domicmod.setAltura(domicdto.getAltura());
        domicmod.setPiso(domicdto.getPiso());
        domicmod.setLocalidad(domicdto.getLocalidad());
        domicmod.setProvincia(domicdto.getProvincia());
        domicmod.setMapa(domicdto.getMapa());
        //domicmod.setId_persona(domicdto.getId_persona()); // no sé si va     
        // Lo cargo a BD
        this.edit(domicmod);
        
    }
    
    @Override
    public DtoDomicilio getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Domicilio domicBuscado=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoDomicilio domicBuscadoDTO =
             
             DtoDomicilio.builder()
                     .id_domicilio(domicBuscado.getId())
                     .calle( domicBuscado.getCalle())
                     .altura( domicBuscado.getAltura())
                     .piso( domicBuscado.getPiso())
                     .localidad( domicBuscado.getLocalidad())
                     .provincia( domicBuscado.getProvincia())
                     .mapa( domicBuscado.getMapa())
                     .id_persona( domicBuscado.getPers().getId())
                  .build();
    
             return domicBuscadoDTO;   
     
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
}
