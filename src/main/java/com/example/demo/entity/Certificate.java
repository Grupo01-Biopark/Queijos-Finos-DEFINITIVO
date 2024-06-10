package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private java.util.Date simPoa;

    @Temporal(TemporalType.DATE)
    private java.util.Date susaf;

    @Temporal(TemporalType.DATE)
    private java.util.Date sisbi;

    @Temporal(TemporalType.DATE)
    private java.util.Date seloArte;

    @Temporal(TemporalType.DATE)
    private java.util.Date cif;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSimPoa() {
        return simPoa;
    }

    public void setSimPoa(Date simPoa) {
        this.simPoa = simPoa;
    }

    public Date getSusaf() {
        return susaf;
    }

    public void setSusaf(Date susaf) {
        this.susaf = susaf;
    }

    public Date getSisbi() {
        return sisbi;
    }

    public void setSisbi(Date sisbi) {
        this.sisbi = sisbi;
    }

    public Date getSeloArte() {
        return seloArte;
    }

    public void setSeloArte(Date seloArte) {
        this.seloArte = seloArte;
    }

    public Date getCif() {
        return cif;
    }

    public void setCif(Date cif) {
        this.cif = cif;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
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
