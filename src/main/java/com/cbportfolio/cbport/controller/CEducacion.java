package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoEducacion;
import com.cbportfolio.cbport.entity.Educacion;
import com.cbportfolio.cbport.service.IEducacionService;
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
@RequestMapping("/educacion") //localhost:8080/educacion
@CrossOrigin(origins = "http://localhost:4200/")
public class CEducacion {
    
    @Autowired
    private IEducacionService educServ;
    //private SEducacion educServ;
    //inyección de dependencia de la controladora con el service
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoEducacion> list(){
       // return listaPersonas;
       return educServ.listDto();
    }
    
    @PostMapping ("/alta")
    public void create (@RequestBody DtoEducacion educacion){
        //listaPersonas.add(pers);
        educServ.createDto(educacion);
       // return "La educacion fue creada correctamente";
    }
    
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        educServ.deleteDto(id);
        //return "La educacion fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public void edit (@RequestBody DtoEducacion educacion){
        //listaPersonas.add(pers);
        educServ.editDto(educacion);
        //return "Los datos de la educacion se modificaron correctamente";
    }
    
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Educacion educacion){
        educServ.edit(educacion);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public DtoEducacion getByIdDto(@PathVariable Long id){
       return educServ.getByIdDto(id);
    }
    /*
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Educacion getById(@PathVariable Long id){
       return educServ.getById(id);
    }*/
    
}
