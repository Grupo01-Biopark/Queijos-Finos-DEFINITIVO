package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issuingBody;
    private String description;
    private Date  issuanceDate;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;


    public Long getId() {
        return id;
    }
    public String getIssuingBody() {
        return issuingBody;
    }
    public String getDescription() {
        return description;
    }
    public Date getIssuanceDate() {
        return issuanceDate;
    }
    public Producer getProducer() {
        return producer;
    }

    public static class Builder {

        private final Certificate certificate;

        public Builder(){
            this.certificate = new Certificate();
        }

        public Builder id(Long id){
            this.certificate.id = id;
            return this;
        }

        public Builder issuingBody(String issuingBody){
            this.certificate.issuingBody = issuingBody;
            return this;
        }

        public Builder description(String description){
            this.certificate.description = description;
            return this;
        }

        public Builder issuanceDate(Date issuanceDate){
            this.certificate.issuanceDate = issuanceDate;
            return this;
        }

        public Builder producer(Producer producer){
            this.certificate.producer = producer;
            return this;
        }
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Certificate other = (Certificate) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    } 

    

}
