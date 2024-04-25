package com.example.demo.dtos;

import java.util.Date;

public class ProducerDto {
    private String nome;
    private String cpf;
    private String telefone1;
    private String cnpj;
    private String razaoSocial;
    private String telefone2;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String uf;
    private String cidade;
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

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
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

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(String dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "ProducerDto{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone1='" + telefone1 + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", telefone2='" + telefone2 + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", email='" + email + '\'' +
                ", dataAssinatura=" + dataAssinatura +
                ", dataVencimento=" + dataVencimento +
                ", situacao='" + situacao + '\'' +
                ", dataSituacao=" + dataSituacao +
                ", sim_poa=" + sim_poa +
                ", susaf=" + susaf +
                ", sisbi=" + sisbi +
                ", selo_arte=" + selo_arte +
                ", cif=" + cif +
                '}';
    }
}
