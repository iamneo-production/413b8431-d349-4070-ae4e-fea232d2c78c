package com.examly.crm.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Opportunity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String status;
	private double value;
	private LocalDate closeDate;
	private String notes;

	@ManyToOne
	@JoinColumn(name = "customer_id",insertable = false, updatable = false)
	private Customer customer;

	@Column(name="customer_id")
	private Long customer_id;
	
	@OneToMany(mappedBy = "opportunity",cascade = CascadeType.ALL)
    private List<Sale> sales;

	public Opportunity() {
		super();
		
	} 
	

	public Opportunity(Long id, String name, String status, double value, LocalDate closeDate,
		String notes, Long customer_id) {
	super();
	this.id = id;
	this.name = name;
	this.status = status;
	this.value = value;
	this.closeDate = closeDate;
	this.notes = notes;
	this.customer_id = customer_id;
}


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

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public LocalDate getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", name=" + name + ", customer=" + customer + ", status=" + status + ", value="
				+ value + ", closeDate=" + closeDate + ", notes=" + notes + "]";
	}


	public Long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	
	
	
}
