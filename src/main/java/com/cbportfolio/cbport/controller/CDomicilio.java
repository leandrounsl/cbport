
package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoDomicilio;
import com.cbportfolio.cbport.entity.Domicilio;
import com.cbportfolio.cbport.service.IDomicilioService;
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
@RequestMapping("/domicilio") //localhost:8080/domicilio
@CrossOrigin(origins = "http://localhost:4200")
public class CDomicilio {
    
    @Autowired
    private IDomicilioService domicServ;
    //private SDomicilio domicServ;
    //inyección de dependencia de la controladora con el service
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoDomicilio> list (){
       // return listaDomicilios;
       return domicServ.listDto();
    }
    
    @PostMapping ("/alta")
    public void create (@RequestBody DtoDomicilio domicilio){
        //listaDomicilios.add(domic);
        domicServ.createDto(domicilio);
        //return "El domicilio fue creado correctamente";
    }
    
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        domicServ.deleteDto(id);
        //return "El domicilio fue borrado correctamente";
    }
    
    @PutMapping ("/edicion")
    public void edit (@RequestBody DtoDomicilio domicilio){
        //listaDomicilio.add(domic);
        domicServ.editDto(domicilio);
        //return "Los datos del domicilio se modificaron correctamente";
    }
        
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Domicilio domicilio){
        domicServ.edit(domicilio);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
      // para devolver datos de una experiencia por id
    @GetMapping("/detalle/{id}")
    @ResponseBody
    public DtoDomicilio getByIdDto(@PathVariable Long id){
        return domicServ.getByIdDto(id);
    }
    
    /*@GetMapping ("/detalle/{id}")
    @ResponseBody
    public Domicilio getById (@PathVariable Long id){
       return domicServ.getById(id);
    }*/
    
}
