package com.devlec.ApplicazioneRestSpringEsame.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Prodotti {
    @Id
    @GeneratedValue
    private Long id;
    private String NomeProd;
    private Long quantita;
    private float prezzo;
    private Date datascadenza;
    public Prodotti(){
    }
    public Prodotti(String NomeProd, Long quantita, float prezzo){
        this.NomeProd=NomeProd;
        this.quantita=quantita;
        this.prezzo=prezzo;
    }
    public Prodotti(Long id, String NomeProd, Long quantita, float prezzo, Date datascadenza){
        this.id=id;
        this.NomeProd=NomeProd;
        this.quantita=quantita;
        this.prezzo=prezzo;
        this.datascadenza=datascadenza;
    }
    public Prodotti(String NomeProd, float prezzo){
        this.quantita=quantita;
        this.prezzo=prezzo;
        this.datascadenza=datascadenza;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeProd() {
        return NomeProd;
    }
    public void setNomeProd() {
        this.NomeProd=NomeProd;
    }
    public Long getQuantita() {
        return quantita;
    }
    public void setQuantita() {
        this.quantita=quantita;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo() {
        this.prezzo=prezzo;
    }
    public Date getDatascadenza() {
        return datascadenza;
    }
    public void setDatascadenza() {
        this.datascadenza=datascadenza;
    }

}
