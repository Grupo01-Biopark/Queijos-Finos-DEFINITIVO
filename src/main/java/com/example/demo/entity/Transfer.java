package com.example.demo.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transfer")
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String startDate;
	private String completionDate;
	
	@ManyToOne
	@JoinColumn(name = "producer_id")
	private Producer producer; 
	
	@ManyToOne
	@JoinColumn(name = "technology_id")
	private Technology technology;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	@Override
	public int hashCode() {
		return Objects.hash(completionDate, id, producer, startDate, technology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		return Objects.equals(completionDate, other.completionDate) && Objects.equals(id, other.id)
				&& Objects.equals(producer, other.producer) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(technology, other.technology);
	}
	
	
}
