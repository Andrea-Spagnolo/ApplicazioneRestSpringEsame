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
    private String nome;
    private float quantita;
    private float prezzo;
    private Date datascadenza;
    public Prodotti(){
    }

    public Prodotti(String nomeProd, float quantita, float prezzo, Date datascadenza) {
        nome = nomeProd;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.datascadenza = datascadenza;
    }

    public Prodotti(String nomeProd, float quantita, float prezzo) {
        nome = nomeProd;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNomeProd() {
        this.nome = nome;
    }
    public float getQuantita() {
        return quantita;
    }
    public void setQuantita(float quantita) {
        this.quantita= this.quantita;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo= this.prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatascadenza() {
        return datascadenza;
    }

    public void setDatascadenza(Date datascadenza) {
        this.datascadenza = datascadenza;
    }
}
