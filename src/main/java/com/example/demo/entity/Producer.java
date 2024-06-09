package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.enums.TipoStatusProduction;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observation;
    private String name;
    private String cpf;
    private String cnpj;
    private String socialReason;
    private String email;
    private TipoStatusProduction tipoStatusProduction;
    
    @Temporal(TemporalType.DATE)
    private Date signatureDate;
    
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    
    @Temporal(TemporalType.DATE)
    private Date simPoa;
    
    @Temporal(TemporalType.DATE)
    private Date susaf;
    
    @Temporal(TemporalType.DATE)
    private Date sisbi;
    
    @Temporal(TemporalType.DATE)
    private Date seloArte;
    
    @Temporal(TemporalType.DATE)
    private Date cif;
    
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();
    @OneToOne(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address = new Address();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transfer> transfers = new ArrayList<>();
    
    public List<Transfer> getTransfers() {
        return transfers;
    }
    
    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
    
    public List<Document> getDocuments() {
        return documents;
    }
    
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getObservation() {
        return observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getSocialReason() {
        return socialReason;
    }
    
    public void setSocialReason(String corporateName) {
        this.socialReason = corporateName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getSignatureDate() {
        return signatureDate;
    }
    
    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }
    
    public Date getExpirationDate() {
        return expirationDate;
    }
    
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public Date getStatusDate() {
        return statusDate;
    }
    
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
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
    
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
    
    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    
    public List<Certificate> getCertificates() {
        return certificates;
    }
    
    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
   
    public TipoStatusProduction getTipoStatusProduction() {
        return tipoStatusProduction;
    }
    
    public void setTipoStatusProduction(TipoStatusProduction tipoStatusProduction) {
        this.tipoStatusProduction = tipoStatusProduction;
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
        Producer other = (Producer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
