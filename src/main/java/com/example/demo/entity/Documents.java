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
@Table(name = "tb_Documents")
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String startDate;
	private String completionDate;
	
	@ManyToOne
	@JoinColumn(name = "producer_id")
	private Producer producer; 
	
	@ManyToOne
	@JoinColumn(name = "documents_id")
	private documents documents;

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

	public documents getdocuments() {
		return documents;
	}

	public void setdocuments(documents documents) {
		this.documents = documents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(completionDate, id, producer, startDate, documents);
	}

	
}
