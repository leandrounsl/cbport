
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoPersona;
import com.cbportfolio.cbport.entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //entidades
    public List<Persona> list();
    public Persona getById(Long id);
    public void create(Persona pernew);
    public void delete(Long id);
    public void edit(Persona per);
    //public Persona loginPersona(String email, String password);
    
    // DTOs
    public List<DtoPersona> listDto();
    public void createDto(DtoPersona perdtonew);
    public void deleteDto(Long id);
    public void editDto(DtoPersona perdto);
    public DtoPersona getByIdDto(Long id);
    //public DtoPersona loginPersonaDto(String email, String password);
    
}
