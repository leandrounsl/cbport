
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoUsuario;
import com.cbportfolio.cbport.entity.Usuario;
import com.cbportfolio.cbport.repository.RUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SUsuario implements IUsuarioService{
    
    @Autowired
    public RUsuario usuarioRepo; 
    //inyecta la dependencia del repo con el q vamos a trabajar
     
    @Autowired
    public SPersona persoServ;
    
    /*@Override
    public Usuario loginUsuario(String username, String password) {
        List<Usuario> listaUsuarios = usuarioRepo.findByUsernameAndPassword(username, password);
        if(!listaUsuarios.isEmpty())
        {
            return listaUsuarios.get(0);
        }
        return null;
     
    }*/

    @Override
    public List<Usuario> list() {
        return usuarioRepo.findAll();
    } 
    
    /*public List<Persona> verPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;  
    }*/
    
    @Override
    public Usuario getById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    } //Luisina
    
    
    /*public Persona buscarPersona(Long id) {
        Persona per = persoRepo.findById(id).orElse(null);
        return per;
    } programa TK */
    
    @Override
    public void create(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }
    
    @Override
    public void edit(Usuario usuario) {
        usuarioRepo.save(usuario);
    }
    
     //DTOs
    
    @Override
    public List<DtoUsuario> listDto(){
    // Lista Persona dsd DTO
        List<DtoUsuario> listausuariosdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Usuario> listausuarios= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Usuario user: listausuarios){
            
            DtoUsuario usuariosdto =
            
            DtoUsuario.builder()
                    .id_usuario(user.getId())
                    .username(user.getUsername())
                    //.email(user.getEmail())
                    .password(user.getPassword())          
                    .id_persona(user.getPers().getId())
                    .build();
            listausuariosdto.add(usuariosdto); 
        }
    return listausuariosdto;
    }

          
    @Override
    public void createDto(DtoUsuario usuariodtonew){
    
        Usuario usuarionew=
                
        Usuario.builder()
                .id(usuariodtonew.getId_usuario())               
                .username(usuariodtonew.getUsername())               
                //.email(usuariodtonew.getEmail())
                .password(usuariodtonew.getPassword())
                .pers(persoServ.getById(usuariodtonew.getId_persona()))                
                .build();
        this.create(usuarionew);
    }
    
    
    @Override
    public void editDto(DtoUsuario usuariodto){
    
        //Busco la experiencia y la guardo en un objeto
        Usuario usuariomod=this.getById(usuariodto.getId_usuario());               
        //Cargo los datos desde el DTO
        usuariomod.setUsername(usuariodto.getUsername());        
        //usuariomod.setEmail(usuariodto.getEmail());
        usuariomod.setPassword(usuariodto.getPassword());              
        // Lo cargo a BD
        this.edit(usuariomod);
    }
    
    @Override
    public DtoUsuario getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Usuario usuariobuscado=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoUsuario usuarioBuscadoDTO =
             
             DtoUsuario.builder()
                     .id_usuario(usuariobuscado.getId())
                     .username( usuariobuscado.getUsername())                     
                     //.email( usuariobuscado.getEmail())
                     .password( usuariobuscado.getPassword())                     
                  .build();
    
             return usuarioBuscadoDTO;   
     
    }
            
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
   /*
    @Override
    public DtoUsuario loginUsuarioDto(String username, String password) {
        List<Usuario> listaUsuariosDto = usuarioRepo.findByUsernameAndPassword(username, password);
        if(!listaUsuariosDto.isEmpty())
        {
            return listUsuariosDto.get(0);
        }
        return null;
     
    }
    */
    
    
    
    
}
