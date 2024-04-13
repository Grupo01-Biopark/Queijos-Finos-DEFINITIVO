package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "tb_phoneNumber")
public class PhoneNumber {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;
    
    
    public Long getId() {
        return id;
    }
    
    public String getPhone() {
        return phone;
    }

    public Producer getProducer() {
        return producer;
    }
    
    public static class Builder{
        
        private final PhoneNumber phoneNumber;
        
        public Builder(){
            this.phoneNumber = new PhoneNumber();
        }
        
        public Builder id(Long id) {
            this.phoneNumber.id = id;
            return this;
        }
        
        public Builder phone(String phone){
            this.phoneNumber.phone = phone;
            return this;
        }

        public Builder producer(Producer producer){
            this.phoneNumber.producer = producer;
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
        PhoneNumber other = (PhoneNumber) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
