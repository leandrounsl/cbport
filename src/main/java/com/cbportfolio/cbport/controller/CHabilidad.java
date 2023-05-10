package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoHabilidad;
import com.cbportfolio.cbport.entity.Habilidad;
import com.cbportfolio.cbport.service.IHabilidadService;
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
@RequestMapping("/habilidad") //localhost:8080/habilidad
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {
    
    @Autowired
    private IHabilidadService habServ;//este pone Luisina
    //private SHabilidad habServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoHabilidad> list (){
       // return listaHabilidades;
       return habServ.listDto();
    }   
    
    @PostMapping ("/alta")
    public void create (@RequestBody DtoHabilidad habilidad){
        //listaHabilidades.add(hab);
        habServ.createDto(habilidad);
        //return "La habilidad fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        habServ.deleteDto(id);
        //return "La habilidad fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public void edit(@RequestBody DtoHabilidad habilidad){
        //listaHabilidades.add(hab);
        habServ.editDto(habilidad);
        //return "Los datos de la habilidad se modificaron correctamente";
    }
    
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Habilidad habilidad){
        habServ.edit(habilidad);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public DtoHabilidad getByIdDto (@PathVariable Long id){
       return habServ.getByIdDto(id);
    }
    
    /*
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Habilidad getById (@PathVariable Long id){
       return habServ.getById(id);
    }*/
}
