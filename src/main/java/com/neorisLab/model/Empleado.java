package com.neorisLab.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//import javax.persistence.Entity;

import org.springframework.stereotype.Component;


import lombok.*;
@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@SequenceGenerator(name = "user_generator", initialValue =100)
	@Column(name= "ID")
	private Long id;
	@Column
	private String name;
	@Column
	private String surname;

    @OneToMany(mappedBy = "empleado")
    @JoinTable(
            name = "empleado_jornada",
            joinColumns = @JoinColumn(name = "idJornadaLaboral")
    )
    private List<JornadaLaboral> jornadaList = new ArrayList<>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
