
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoIdioma;
import com.cbportfolio.cbport.entity.Idioma;
import java.util.List;


public interface IIdiomaService {
    
    //entidades
    public List<Idioma> list();
    public Idioma getById(Long id);
    public void create(Idioma idiomanew);
    public void delete(Long id);
    public void edit(Idioma idioma);
        
    // DTOs
    public List<DtoIdioma> listDto();
    public void createDto(DtoIdioma idiomadtonew);
    public void deleteDto(Long id);
    public void editDto(DtoIdioma idiomadto);
    public DtoIdioma getByIdDto(Long id);
}
