package com.neorisLab.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neorisLab.model.Empleado;
import com.neorisLab.repository.EmpleadoRepository;
@Service
public class EmpleadoService {
	@Autowired
	private EmpleadoRepository repository;
	
	 @Transactional
	    public Empleado save(Empleado entity) throws Exception {
	        try{
	            entity = repository.save(entity);
	            return entity;
	        } catch (Exception e){
	            throw new Exception(e.getMessage());
	        }
	    }
	 @Transactional(readOnly = true)
	    public Empleado findById(Long id) throws Exception {
	        try{
	            Optional<Empleado> entityOptional = repository.findById(id);
	            return entityOptional.get();
	        } catch (Exception e){
	            throw new Exception(e.getMessage());
	        }
	    }
	    @Transactional(readOnly = true)
	    public List<Empleado> findAll() throws Exception {
	        try{
	            List<Empleado> entities = repository.findAll();
	            return entities;
	        } catch (Exception e){
	            throw new Exception(e.getMessage());
	        }
	    }
	    @Transactional
	    public Empleado update(Long id, Empleado entity) throws Exception {
	        try{
	            Optional<Empleado> entityOptional =repository.findById(id);
	            Empleado unEmpleado= entityOptional.get();
	            unEmpleado =repository.save(entity );
	            return  unEmpleado;
	        } catch (Exception e){
	            throw new Exception(e.getMessage());
	        }
	    }
	    
	    @Transactional
	    public boolean delete(Long id) throws Exception {
	        try{
	            if (repository.existsById(id)){
	                repository.deleteById(id);
	                return true;
	            } else {
	                throw new Exception();
	            }
	        } catch (Exception e){
	            throw new Exception(e.getMessage());
	        }
	    }
	
	
	
	
	

}
