package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoProyecto;
import com.cbportfolio.cbport.entity.Proyecto;
import com.cbportfolio.cbport.service.IProyectoService;
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
@RequestMapping("/proyecto") //localhost:8080/proyectos
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    private IProyectoService proyServ;
    //private SProyecto proyServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoProyecto> list(){
       // return listaProyectos;
       return proyServ.listDto();
    }
    
    
    
    @PostMapping ("/alta")
    public void create (@RequestBody DtoProyecto proyecto){
        //listaProyecto.add(proy);
        proyServ.createDto(proyecto);
        //return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        proyServ.deleteDto(id);
        //return "El proyecto fue borrado correctamente";
    }
    
    @PutMapping ("/edicion")
    public void edit (@RequestBody DtoProyecto proyecto){
        //listaProyectos.add(proy);
        proyServ.editDto(proyecto);
        //return "Los datos del proyecto se modificaron correctamente";
    }
    
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Proyecto proyecto){
        proyServ.edit(proyecto);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public DtoProyecto getByIdDto (@PathVariable Long id){
       return proyServ.getByIdDto(id);
    }
    
    /*
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Proyecto getById (@PathVariable Long id){
       return proyServ.getById(id);
    }*/
}
