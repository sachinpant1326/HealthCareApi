package com.cg.healthcare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="BEDS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BED_TYPE",discriminatorType = DiscriminatorType.INTEGER)
public class Bed implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="IS_OCCUPIED")
	@ColumnDefault(value="false")
	private boolean isOccupied;
	
	@OneToOne
	@JoinColumn(name = "APPOINTMENT_ID")
	private Appointment appointment;
	
	@Column(name="PRICE",nullable =  false)
	private double pricePerDay;
	
	@ManyToOne
	@JoinColumn(name = "D_CENTER_ID")
	private DiagnosticCenter diagnosticCenter;
	
	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public Bed()
	{
		this.isOccupied = false;
	}
	
	public Bed(double pricePerDay)
	{
		this();
		this.pricePerDay = pricePerDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public void addAppointment(Appointment appointment) {
		this.setAppointment(appointment);
	}
	
	public void removeAppointment() {
		this.setAppointment(null);
	}
}