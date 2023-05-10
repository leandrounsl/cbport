
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoHabilidad;
import com.cbportfolio.cbport.entity.Habilidad;
import java.util.List;


public interface IHabilidadService {
    
    //Entidades
    public List<Habilidad> list();
    public Habilidad getById(Long id);
    public void create(Habilidad habnew);
    public void delete(Long id);
    public void edit(Habilidad hab);
      
    // DTOs
    public List<DtoHabilidad> listDto();
    public void createDto(DtoHabilidad habdtonew);
    public void deleteDto(Long id);
    public void editDto(DtoHabilidad habdto);
    public DtoHabilidad getByIdDto(Long id);
}
