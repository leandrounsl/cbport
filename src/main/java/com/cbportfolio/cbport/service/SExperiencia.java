package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoExperiencia;
import com.cbportfolio.cbport.entity.Experiencia;
import com.cbportfolio.cbport.repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia implements IExperienciaService {
    
    @Autowired
    public RExperiencia expeRepo;
    
    @Autowired
    public SPersona persoServ;
    
    
    //ENTIDADES
    
    @Override
    public List<Experiencia> list() {
        return expeRepo.findAll();
    }
    
    /*public List<Experiencia> verExperiencias() {
        List<Experiencia> listaExperiencias = expeRepo.findAll();
        return listaExperiencias;  
    }  */

    @Override
    public Experiencia getById(Long id) {
        return expeRepo.findById(id).orElse(null);
    }
    
    /*public Experiencia buscarExperiencia(Long id) {
        Experiencia expe = expeRepo.findById(id).orElse(null);
        return expe;
    }  */
    
    @Override
    public void create(Experiencia expenew) {
        expeRepo.save(expenew);
    }
    
    @Override
    public void edit(Experiencia expe) {
        expeRepo.save(expe);
    }
    
    @Override
    public void delete(Long id) {
        expeRepo.deleteById(id);
    }
    

    //DTOs
    
    @Override
    public List<DtoExperiencia> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoExperiencia> listaexpedto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Experiencia> listaexpe= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Experiencia expe: listaexpe){
            
            DtoExperiencia expedto =
            
            DtoExperiencia.builder()
                    .id_experiencia(expe.getId())
                    .empresa(expe.getEmpresa())
                    .logo(expe.getLogo())
                    .url(expe.getUrl())
                    .cargo(expe.getCargo())
                    .descPuesto(expe.getDescPuesto())
                    .inicio(expe.getInicio())
                    .fin(expe.getFin())
                    //.pers(persoServ.getById(expedtonew.getIdPersona()))
                    .id_persona(expe.getPers().getId())
                    .build();
            listaexpedto.add(expedto); 
        }
    return listaexpedto;
    }
          
    @Override
    public void createDto(DtoExperiencia expedtonew){
    
        Experiencia expenew=
                
        Experiencia.builder()
                //.id(expedtonew.getIdExperiencia())
                .empresa(expedtonew.getEmpresa())
                .logo(expedtonew.getLogo())
                .url(expedtonew.getUrl())
                .cargo(expedtonew.getCargo())
                .descPuesto(expedtonew.getDescPuesto())
                .inicio(expedtonew.getInicio())
                .fin(expedtonew.getFin())
                .pers(persoServ.getById(expedtonew.getId_persona()))
                //.personaid(expedto.getPers().getId())
                //.personaId(expedtonew.getPersonaId())
                .build();
        this.create(expenew);
    }
     
    @Override
    public void editDto(DtoExperiencia expedto){
    
        //Busco la experiencia y la guardo en un objeto
        Experiencia expemod=this.getById(expedto.getId_experiencia());
                
        //Cargo los datos desde el DTO
        expemod.setEmpresa(expedto.getEmpresa());
        expemod.setLogo(expedto.getLogo());
        expemod.setUrl(expedto.getUrl());
        expemod.setCargo(expedto.getCargo());
        expemod.setDescPuesto(expedto.getDescPuesto());
        expemod.setInicio(expedto.getInicio());
        expemod.setFin(expedto.getFin());
        //expemod.setId_persona(expedto.getId_persona()); // no sé si va   
        
        // Lo cargo a BD
        this.edit(expemod);
    }    
       
    @Override
    public DtoExperiencia getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Experiencia expeBuscada=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoExperiencia expeBuscadaDTO =
             
             DtoExperiencia.builder()
                     .id_experiencia(expeBuscada.getId())
                     .logo( expeBuscada.getLogo())
                     .url( expeBuscada.getUrl())
                     .cargo( expeBuscada.getCargo())
                     .descPuesto( expeBuscada.getDescPuesto())
                     .inicio( expeBuscada.getInicio())
                     .fin( expeBuscada.getFin())
                     .id_persona( expeBuscada.getPers().getId())
                  .build();
    
             return expeBuscadaDTO;   
     
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
}
