package com.neorisLab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.neorisLab.model.JornadaLaboral;
import com.neorisLab.service.JornadaLaboralService;

@Controller

public class JornadaLaboralController {
	 private final JornadaLaboralService jornadaService;

	    public JornadaLaboralController(JornadaLaboralService jornadaService) {
	        this.jornadaService = jornadaService;
	    }


	    @GetMapping("/listaJornadas")
	    public ResponseEntity<?> getAll() {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(jornadaService.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getOne(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(jornadaService.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }

	    @PostMapping("/altaJornada")
	    public ResponseEntity<?> save(@RequestBody JornadaLaboral entity) {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(jornadaService.save(entity));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JornadaLaboral entity) {
	        try {
	            return ResponseEntity.status(HttpStatus.OK).body(jornadaService.update( entity,id));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        try {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(jornadaService.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	        }
	    }


}
