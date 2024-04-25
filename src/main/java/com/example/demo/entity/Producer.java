package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.enums.TipoStatusProduction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProducer;
    private String cpfProducer;
    private String email;
    private String socialReason; 
    private String cnpj;
    private String comments;
    private TipoStatusProduction tipoStatusProducer;
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();
    
    
    public Long getId() {
        return id;
    }
    
    public String getNameProducer() {
        return nameProducer;
    }
    
    public String getCpfProducer() {
        return cpfProducer;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSocialReason() {
        return socialReason;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public String getComments() {
        return comments;
    }
    
    public List<Address> getAddresses() {
        return addresses;
    }
    
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
    
    public List<Certificate> getCertificates() {
        return certificates;
    }
    
    public TipoStatusProduction getTipoStatusProducer() {
        return tipoStatusProducer;
    }

    // Construtor privado, acessível apenas pelo Builder
    private Producer() {}
    
    // Builder estático interno à classe Producer
    public static class Builder {
        private final Producer producer;

        public Builder() {
            this.producer = new Producer();
        }

        public Builder id(Long id) {
            this.producer.id = id;
            return this;
        }

        public Builder nameProducer(String nameProducer) {
            this.producer.nameProducer = nameProducer;
            return this;
        }

        public Builder cpfProducer(String cpfProcucer){
            this.producer.cpfProducer = cpfProcucer;
            return this;
        }

        public Builder email(String email) {
            this.producer.email = email;
            return this;
        }

        public Builder socialReason(String socialReason) {
            this.producer.socialReason = socialReason;
            return this;
        }

        public Builder cnpj(String cnpj) {
            this.producer.cnpj = cnpj;
            return this;
        }

        public Builder comments(String comments) {
            this.producer.comments = comments;
            return this;
        }

        public Builder tipoStatusProducer(TipoStatusProduction tipoStatusProducer){
            this.producer.tipoStatusProducer = tipoStatusProducer;
            return this;
        }

        public Producer build() {
            return this.producer;
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
        Producer other = (Producer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
