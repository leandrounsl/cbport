
package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoUsuario;
import com.cbportfolio.cbport.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario") //localhost:8080/usuario
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = ("https://cjbfrontend.web.app", "http://localhost:4200")) estas se pueden poner juntas
public class CUsuario {
    
    @Autowired
    private IUsuarioService userServ; 
    //private SPersona persoServ;
    //inyección de dependencia de la controladora con el service
    
    
    /*@PostMapping ("/login") //("/autenticacion/login")
    public Usuario loginUsuario (@RequestBody DtoUsuario usuario){
        return userServ.loginUsuario(usuario.getUsername(), usuario.getPassword());
    }*/
    
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoUsuario> list (){
       // return listaPersonas;
       return userServ.listDto();
    }
    
    
    
    @PostMapping ("/alta")
    public String create (@RequestBody DtoUsuario usuario){
        //listaPersonas.add(pers);
        userServ.createDto(usuario);
        return "El usuario fue creado correctamente";
    }
    /*
    @PostMapping ("/alta")
    public String create (@RequestBody DtoPersona persona){
        //listaPersonas.add(pers);
        persoServ.createDto(persona);
        return "La persona fue creada correctamente";
    }
    */
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        userServ.deleteDto(id);
        //return "El usuario fue borrado correctamente";
    }
    
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody DtoUsuario usuario){
        //listaPersonas.add(pers);
        userServ.editDto(usuario);
        return "Los datos de la persona se modificaron correctamente";
    }
    
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Persona persona){
        persoServ.edit(persona);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public DtoUsuario getByIdDto (@PathVariable Long id){
       return userServ.getByIdDto(id);
    }
    
    /* @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Persona getById (@PathVariable Long id){
       return userServ.getById(id);
    }*/
    
    
    
}
