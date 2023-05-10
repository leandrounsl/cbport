
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoProyecto;
import com.cbportfolio.cbport.entity.Proyecto;
import java.util.List;


public interface IProyectoService {
   
   //entidades
    public List<Proyecto> list();
    public Proyecto getById(Long id);
    public void create(Proyecto proynew);
    public void delete(Long id);
    public void edit(Proyecto proy);
        
    // DTOs
    public List<DtoProyecto> listDto();
    public void createDto(DtoProyecto proydtonew);
    public void deleteDto(Long id);
    public void editDto(DtoProyecto proydto);
    public DtoProyecto getByIdDto(Long id);
}
