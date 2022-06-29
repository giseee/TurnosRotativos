package com.neorisLab.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neorisLab.model.JornadaLaboral;
import com.neorisLab.repository.JornadaLaboralRepository;
@Service
public class JornadaLaboralService {
	@Autowired
	private JornadaLaboralRepository jornadaRepository;
    @Transactional
    public JornadaLaboral update(JornadaLaboral entity,Long id) throws Exception {
        try {
            java.util.Optional<JornadaLaboral> entityOptional = jornadaRepository.findById(id);
            JornadaLaboral unaJornadaLaboral = entityOptional.get();
            unaJornadaLaboral = jornadaRepository.save(entity);
            return unaJornadaLaboral;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public JornadaLaboral save(JornadaLaboral entity) throws Exception {
        try {
            entity = jornadaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (jornadaRepository.existsById(id)) {
                jornadaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public JornadaLaboral findById(Long id) throws Exception {
        try {
            Optional<JornadaLaboral> entityOptional = jornadaRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<JornadaLaboral> findAll() throws Exception {
        try {
            List<JornadaLaboral> entities = jornadaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
