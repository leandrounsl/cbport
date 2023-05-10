package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoRed;
import com.cbportfolio.cbport.entity.Red;
import java.util.List;


public interface IRedService {
    
     //entidades
    public List<Red> list();
    public Red getById(Long id);
    public void create(Red netnew);
    public void delete(Long id);
    public void edit(Red net);
    
    // DTOs
    public List<DtoRed> listDto();
    public void createDto(DtoRed netdtonew);
    public void deleteDto(Long id);
    public void editDto(DtoRed netdto);
    public DtoRed getByIdDto(Long id);
}
