
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoDomicilio;
import com.cbportfolio.cbport.entity.Domicilio;
import java.util.List;


public interface IDomicilioService {
    //entidades
    public List<Domicilio> list();
    public Domicilio getById(Long id);
    public void create(Domicilio domicnew);
    public void delete(Long id);
    public void edit(Domicilio domic);
        
    // DTOs
    public List<DtoDomicilio> listDto();
    public void createDto(DtoDomicilio domicdtonew);
    public void deleteDto(Long id);
    public void editDto(DtoDomicilio domicdto);
    public DtoDomicilio getByIdDto(Long id);
}
