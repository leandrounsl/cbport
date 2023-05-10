package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoExperiencia;
import com.cbportfolio.cbport.entity.Experiencia;
import com.cbportfolio.cbport.service.IExperienciaService;
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
@RequestMapping("/experiencia") //localhost:8080/experiencia
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    private IExperienciaService expeServ;
    //private SExperiencia expeServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoExperiencia> list(){
       // return listaExperiencias;
       return expeServ.listDto();
    }
       
    @PostMapping ("/alta")
    public void create(@RequestBody DtoExperiencia experiencia){
        //listaExperiencias.add(expe);
        expeServ.createDto(experiencia);
        //return "La experiencia fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        expeServ.deleteDto(id);
        //return "La experiencia fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public void edit(@RequestBody DtoExperiencia experiencia){
        //listaExperiencias.add(expe);
        expeServ.editDto(experiencia);
        //return "Los datos de la experiencia se modificaron correctamente";
    }
    
     // este sería editar por id, pero no lo tenemos en el servicio ni su interfase, tampoco en FRONTEND
    /*
    @PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody DtoExperiencia expedto){
        //listaExperiencias.add(expe);
        expeServ.editDto(expedto);
        return "Los datos de la experiencia se modificaron correctamente";
    }
    en principio parece
    */    
    
     // para devolver datos de una experiencia por id
    @GetMapping("/detalle/{id}")
    @ResponseBody
    public DtoExperiencia getByIdDto(@PathVariable Long id){
        return expeServ.getByIdDto(id);
    }
    
    /*@GetMapping ("/detalle/{id}") 
    @ResponseBody
    public Experiencia getById(@PathVariable Long id){
       return expeServ.getById(id);
    }*/
    
    
   
    
    /* NO USAR
    @PutMapping ("edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Experiencia expe){
        expeServ.edit(expe);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
   
}

