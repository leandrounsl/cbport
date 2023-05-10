package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoIdioma;
import com.cbportfolio.cbport.entity.Idioma;
import com.cbportfolio.cbport.service.IIdiomaService;
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
@RequestMapping("/idioma") //localhost:8080/idiomas
@CrossOrigin(origins = "http://localhost:4200")
public class CIdioma {
    
    @Autowired
    private IIdiomaService idiomaServ;
    //private SIdioma idiomaServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoIdioma> list (){
       // return listaIdiomas;
       return idiomaServ.listDto();
    }
    
    @PostMapping ("/alta")
    public void create (@RequestBody DtoIdioma idioma){
        //listaIdiomas.add(idiom);
        idiomaServ.createDto(idioma);
        //return "El idioma fue creado correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        idiomaServ.deleteDto(id);
        //return "El idioma fue borrado correctamente";
    }
    
    @PutMapping ("/edicion")
    public void edit (@RequestBody DtoIdioma idioma){
        //listaIdiomas.add(idiom);
        idiomaServ.editDto(idioma);
        //return "Los datos del idioma se modificaron correctamente";
    }
    
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Idioma idioma){
        idiomaServ.edit(idioma);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public DtoIdioma getByIdDto (@PathVariable Long id){
       return idiomaServ.getByIdDto(id);
    }
    
    /*@GetMapping ("/detalle/{id}")
    @ResponseBody
    public Idioma getById (@PathVariable Long id){
       return idiomaServ.getById(id);
    }*/
}
