package com.crud.tienda.controller;

import com.crud.tienda.model.ServiceResponse;
import com.crud.tienda.model.Tienda;
import com.crud.tienda.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tienda")
@CrossOrigin("*")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping("/list")
    public ResponseEntity<List<Tienda>> list(){
        var result = tiendaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Tienda tienda){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = tiendaService.save(tienda);
        if(result == 1){
            serviceResponse.setMessage("Item saved successfully");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Tienda tienda){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = tiendaService.update(tienda);
        if(result == 1){
            serviceResponse.setMessage("Item updated successfully");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = tiendaService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Item deleted successfully");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
