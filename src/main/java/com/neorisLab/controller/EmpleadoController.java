package com.neorisLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neorisLab.model.Empleado;
import com.neorisLab.service.EmpleadoService;

@RestController
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;//genero la instancia 
	
	@GetMapping(value = "/empleado/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
   @PostMapping("/altaEmpleado")
	public ResponseEntity<?> save(@RequestBody Empleado entity) {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }
	
	  @GetMapping("/listaEmpleados")
	public ResponseEntity<?> getAll() {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Empleado entity) {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.update(id, entity));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empleadoService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }
}
