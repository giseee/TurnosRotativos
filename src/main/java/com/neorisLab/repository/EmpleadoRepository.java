package com.neorisLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neorisLab.model.Empleado;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

}
