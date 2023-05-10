
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoEducacion;
import com.cbportfolio.cbport.entity.Educacion;
import java.util.List;


public interface IEducacionService {
    
    //entidades
    public List<Educacion> list();
    public Educacion getById(Long id);
    public void create(Educacion educnew);
    public void delete(Long id);
    public void edit(Educacion educ);
    
    
    // DTOs
    public List<DtoEducacion> listDto();
    public void createDto(DtoEducacion educdtonew);
    public void deleteDto(Long id);
    public void editDto(DtoEducacion educdto);
    public DtoEducacion getByIdDto(Long id);
    
}
