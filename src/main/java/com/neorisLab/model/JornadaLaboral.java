package com.neorisLab.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class JornadaLaboral implements Serializable {
	
     /**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Table(name = "id_jornada")
	private static final long serialVersionUID = 1L;


     @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinColumn(name = "idEmpleado")
     private Empleado empleado;
     private Tipo tipoJornada;
     private LocalDate fecha;
     private LocalTime horaInicio;
     private LocalTime horaFin;
     public Long getIdJornadaLaboral() {
		return serialVersionUID ;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Tipo getTipoJornada() {
		return tipoJornada;
	}
	public void setTipoJornada(Tipo tipoJornada) {
		this.tipoJornada = tipoJornada;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public void tipoJornada() {
         switch (tipoJornada)
         {
             case Vacaciones:
                 System.out.println("Usted esta de vacaciones, no puede trabajar!");
                 break;
             case Dia_Libre:
                 System.out.println("dia libre por 24 hs no podra trabajar");
                 break;
             case TurnoExtra:
                 System.out.println("ingrese como minimo 2 hs, y como maximo 6");
                 break;
             case TurnoNormal:
                 System.out.println("ingrese como minimo 6hs, y como maximo 8");
                  break;
             default:
                 System.out.println("Debe cargar una jornada valida");
                 break;
         }

     }

}
