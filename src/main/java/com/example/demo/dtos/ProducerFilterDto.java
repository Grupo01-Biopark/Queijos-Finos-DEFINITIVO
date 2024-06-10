package com.example.demo.dtos;

//import com.example.demo.entity.enums.TipoCertificate;
import com.example.demo.entity.enums.TipoStatusProduction;
/* TUDO QUE ESTIVER COMMITADADO ESTA SENDO UTILIZADO EM OUTRA VERSÃO */

public class ProducerFilterDto {

    private String nameProducer;
    private String city;
    private String technologyName;
    // private TipoCertificate tipoCertificate; 
    private TipoStatusProduction tipoStatusProduction;

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    /*
     * public TipoCertificate gettipoCertificate() {
     * return tipoCertificate;
     * }
     * 
     * public void settipoCertificate(TipoCertificate tipoCertificate) {
     * this.tipoCertificate = tipoCertificate;
     * }
     */

    public TipoStatusProduction getTipoStatusProduction() {
        return tipoStatusProduction;
    }

    public void setTipoStatusProduction(TipoStatusProduction tipoStatusProduction) {
        this.tipoStatusProduction = tipoStatusProduction;
    }

    public ProducerFilterDto() {
    }

    public ProducerFilterDto(String nameProducer, String city, String technologyName,
            TipoStatusProduction tipoStatusProduction) {
        this.nameProducer = nameProducer;
        this.city = city;
        this.technologyName = technologyName;
        // this.tipoCertificate = tipoCertificate;
        this.tipoStatusProduction = tipoStatusProduction;
    }

}