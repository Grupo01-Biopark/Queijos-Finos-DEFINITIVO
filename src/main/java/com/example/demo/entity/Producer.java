package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.enums.TipoStatusProducer;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observacao;
    private String nome;
    private String cpf;
    private String cnpj;
    private String razaoSocial;
    private String email;
    private String dataAssinatura;
    private String dataVencimento;
    private String situacao;
    private String dataSituacao;
    private String sim_poa;
    private String susaf;
    private String sisbi;
    private String selo_arte;
    private String cif;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();
    @OneToOne(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address = new Address();

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(String dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataSituacao() {
        return dataSituacao;
    }

    public void setDataSituacao(String dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    public String getSim_poa() {
        return sim_poa;
    }

    public void setSim_poa(String sim_poa) {
        this.sim_poa = sim_poa;
    }

    public String getSusaf() {
        return susaf;
    }

    public void setSusaf(String susaf) {
        this.susaf = susaf;
    }

    public String getSisbi() {
        return sisbi;
    }

    public void setSisbi(String sisbi) {
        this.sisbi = sisbi;
    }

    public String getSelo_arte() {
        return selo_arte;
    }

    public void setSelo_arte(String selo_arte) {
        this.selo_arte = selo_arte;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
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
}
