package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoRed;
import com.cbportfolio.cbport.entity.Red;
import com.cbportfolio.cbport.service.IRedService;
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
@RequestMapping("/red") //localhost:8080/red
@CrossOrigin(origins = "http://localhost:4200")
public class CRed {
    
    @Autowired
    private IRedService redServ;
    //private SRed redServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoRed> list (){
       // return listaRedes;
       return redServ.listDto();
    }
    
    
    @PostMapping ("/alta")
    public String create (@RequestBody DtoRed red){
        //listaRedes.add(net);
        redServ.createDto(red);
        return "La red fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public void delete(@PathVariable Long id){
        redServ.deleteDto(id);
        //return "La red fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody DtoRed red){
        //listaRedes.add(net);
        redServ.editDto(red);
        return "Los datos de la red se modificaron correctamente";
    }
    
    /*@PutMapping ("/edicion/{id}")
    public String editById (@PathVariable("id") Long id, @RequestBody Red red){
        redServ.edit(red);
        return "Los datos de la experiencia se modificaron correctamente";
    }*/
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public DtoRed getByIdDto (@PathVariable Long id){
       return redServ.getByIdDto(id);
    }
    
    /*
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Red getById (@PathVariable Long id){
       return redServ.getById(id);
    }*/
}
