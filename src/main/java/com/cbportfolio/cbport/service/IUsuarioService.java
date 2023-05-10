
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoUsuario;
import com.cbportfolio.cbport.entity.Usuario;
import java.util.List;


public interface IUsuarioService {
    //entidades
    public List<Usuario> list();
    public Usuario getById(Long id);
    public void create(Usuario usuario);
    //public void create(Usuario pernew);
    public void delete(Long id);
    //public void edit(Usuario per);
    public void edit(Usuario usuario);
    //public Usuario loginUsuario(String username, String password);
    
    // DTOs
    public List<DtoUsuario> listDto();
    public void createDto(DtoUsuario usuariodtonew);
    //public void createDto(DtoUsuario perdtonew);
    public void deleteDto(Long id);
    public void editDto(DtoUsuario usuariodto);
    //public void editDto(DtoUsuario perdto);
    public DtoUsuario getByIdDto(Long id);
   // public DtoUsuario loginUsuarioDto(String username, String password);
    
}
