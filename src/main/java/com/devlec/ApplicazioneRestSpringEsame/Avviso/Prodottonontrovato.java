package com.devlec.ApplicazioneRestSpringEsame.Avviso;

public class Prodottonontrovato extends RuntimeException {
    public Prodottonontrovato(Long id) {
        super("Utente non trovato " + id);
    }
}