package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String road; // rua
    private String neighborhood; // bairro
    private String locality;
    private String city;
    private String longitude;
    private String latitude;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

  
   
    public Long getId() {
        return id;
    }
    public String getCep() {
        return cep;
    }
    public String getRoad() {
        return road;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public String getLocality() {
        return locality;
    }
    public String getCity() {
        return city;
    }
    public String getLongitude() {
        return longitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }


    // metodo Builder

    public static class Builder {
        private final Address address;
    
        public Builder() {
            this.address = new Address();
        }
    
        public Builder id(Long id) {
            this.address.id = id;
            return this;
        }
    
        public Builder cep(String cep) {
            this.address.cep = cep;
            return this;
        }
    
        public Builder road(String road) {
            this.address.road = road;
            return this;
        }
    
        public Builder neighborhood(String neighborhood) {
            this.address.neighborhood = neighborhood;
            return this;
        }
    
        public Builder locality(String locality) {
            this.address.locality = locality;
            return this;
        }
    
        public Builder city(String city) {
            this.address.city = city;
            return this;
        }
    
        public Builder longitude(String longitude) {
            this.address.longitude = longitude;
            return this;
        }
    
        public Builder latitude(String latitude) {
            this.address.latitude = latitude;
            return this;
        }
    
        public Address build() {
            return this.address;
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
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
