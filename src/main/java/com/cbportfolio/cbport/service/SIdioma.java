package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoIdioma;
import com.cbportfolio.cbport.entity.Idioma;
import com.cbportfolio.cbport.repository.RIdioma;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdioma implements IIdiomaService{
    
    @Autowired
    public RIdioma idiomaRepo;
    
    @Autowired
    public SPersona persoServ;
    
    
    @Override
    public List<Idioma> list() {
        return idiomaRepo.findAll();
    }
    
    /*public List<Idioma> verIdiomas() {
        List<Idioma> listaIdiomas = idiomaRepo.findAll();
        return listaIdiomas;  
    }  */

    @Override
    public Idioma getById(Long id) {
        return idiomaRepo.findById(id).orElse(null);
    }
    
    /*public Idioma buscarIdioma(Long id) {
        Idioma idioma = idiomaRepo.findById(id).orElse(null);
        return idioma;
    }  */
    
    @Override
    public void create(Idioma idiomanew) {
        idiomaRepo.save(idiomanew);
    }

    @Override
    public void delete(Long id) {
        idiomaRepo.deleteById(id);
    }
    
    @Override
    public void edit(Idioma idioma) {
        idiomaRepo.save(idioma);
    }

     //DTOs
    
    @Override
    public List<DtoIdioma> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoIdioma> listaidiomadto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Idioma> listaidioma= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Idioma idioma: listaidioma){
            
            DtoIdioma idiomadto =
            
            DtoIdioma.builder()
                    .id_idioma(idioma.getId())
                    .idioma(idioma.getIdioma())
                    .porcentaje(idioma.getPorcentaje())
                    .progreso(idioma.getProgreso())
                    .comentario(idioma.getComentario())
                    .id_persona(idioma.getPers().getId())
                    //.personaId(idioma.getPersonaId())
                    .build();
            listaidiomadto.add(idiomadto); 
        }
    return listaidiomadto;
    }
    
    @Override
    public void createDto(DtoIdioma idiomadtonew){
    
        Idioma idiomanew=
                
        Idioma.builder()
                //.id(idiomadtonew.getId_idioma())
                .idioma(idiomadtonew.getIdioma())
                .porcentaje(idiomadtonew.getPorcentaje())
                .progreso(idiomadtonew.getProgreso())
                .comentario(idiomadtonew.getComentario())
                .pers(persoServ.getById(idiomadtonew.getId_persona()))
                //.personaid(expedto.getPers().getId())
                //.personaId(idiomadtonew.getPersonaId())
                .build();
        this.create(idiomanew);
    }
    
    @Override
    public void editDto(DtoIdioma idiomadto){
    
        //Busco la experiencia y la guardo en un objeto
        Idioma idiomamod=this.getById(idiomadto.getId_idioma());
                
        //Cargo los datos desde el DTO
        idiomamod.setIdioma(idiomadto.getIdioma());
        idiomamod.setPorcentaje(idiomadto.getPorcentaje());
        idiomamod.setProgreso(idiomadto.getProgreso());
        idiomamod.setComentario(idiomadto.getComentario());
        //idiomamod.setId_persona(idiomadto.getId_persona()); // no sé si va   
        
        // Lo cargo a BD
        this.edit(idiomamod);
        
    }
    
    @Override
    public DtoIdioma getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Idioma idiomaBuscado=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoIdioma idiomaBuscadoDTO =
             
             DtoIdioma.builder()
                     .id_idioma(idiomaBuscado.getId())
                     .idioma( idiomaBuscado.getIdioma())
                     .porcentaje( idiomaBuscado.getPorcentaje())
                     .progreso( idiomaBuscado.getProgreso())
                     .comentario( idiomaBuscado.getComentario())
                     .id_persona( idiomaBuscado.getPers().getId())
                  .build();
    
             return idiomaBuscadoDTO;   
     
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
}
