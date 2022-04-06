package com.devlec.ApplicazioneRestSpringEsame.configurazione;

import com.devlec.ApplicazioneRestSpringEsame.Model.Prodotti;
import com.devlec.ApplicazioneRestSpringEsame.persistenza.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static final Logger logger=LoggerFactory.getLogger(PrimoInserimento.class);
    @Bean
    CommandLineRunner inseriscielementi(ProdottiRepository repository){
        return args -> {
            Prodotti p1=new Prodotti("Verdure","0,50","1,00");
            Prodotti p2=new Prodotti("Carne","0,75","5,00");

            List<Prodotti> prodotti=new ArrayList<>();
            prodotti.add(p1);
            prodotti.add(p2);
            repository.saveAll(prodotti);
            List<Prodotti> prodottidalDB=repository.findAll();
            Prodotti p1deldb=new Prodotti();
            int indice=0;
            for(Prodotti p: prodottidalDB){
                if(indice==0){
                    logger.error("Prendo il primo elemento del db");
                    p1deldb=p;
                    indice++;
                }
                logger.info("Prodotto: "+p.getNomeProd());
                logger.info("Quantita: "+p.getQuantita());
                logger.info("Prezzo: "+p.getPrezzo());
                logger.info("Data di scadenza: "p.getDatascadenza());
                logger.warn(p.toString());
            }
            Prodotti prodottoconid1=repository.findById(1L).get();
            logger.info("Il prodotto con id 1: "+prodottoconid1.getNomeProd());
            p1deldb.setPrezzo("Nuovo prezzo: ");
            repository.save(p1deldb);
            p1deldb.setQuantita("Nuova quantita: ");
            repository.save(p1deldb);
            p1deldb.setDatascadenza("Nuova data di scadenza: ");
            repository.save(p1deldb);
            prodottidalDB=repository.findAll();
            for (Prodotti p:prodottidalDB){
                logger.info("Nome del prodotto: "+p.getNomeProd());
                logger.info("Quantita: "+p.getQuantita());
                logger.info("Prezzo: "+p.getPrezzo());
                logger.info("Data di scadenza: "+p.getDatascadenza());
            }
        };
    }
}
