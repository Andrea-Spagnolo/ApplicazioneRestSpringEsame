package com.devlec.ApplicazioneRestSpringEsame.configurazione;

import com.devlec.ApplicazioneRestSpringEsame.Model.Prodotti;
import com.devlec.ApplicazioneRestSpringEsame.persistenza.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static final Logger logger=LoggerFactory.getLogger(PrimoInserimento.class);
    @Bean
    CommandLineRunner inseriscielementi(ProdottiRepository repository){
        return args -> {
            Prodotti p1=new Prodotti("farina", 1f, 2.50f);
            Prodotti p2=new Prodotti("carne", 10.5f, 5f);

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
                logger.info("Prodotto: "+p.getNome());
                logger.info("Quantita: "+p.getQuantita());
                logger.info("Prezzo: "+p.getPrezzo());
                logger.info("Data di scadenza: "+p.getDatascadenza());
                logger.warn(p.toString());
            }
            Prodotti prodottoconid1=repository.findById(1L).get();
            logger.info("Il prodotto con id 1: "+prodottoconid1.getNome());
            p1deldb.setPrezzo(1f);
            repository.save(p1deldb);
            p1deldb.setQuantita(2f);
            repository.save(p1deldb);
            p1deldb.setDatascadenza(new Date());
            repository.save(p1deldb);
            prodottidalDB=repository.findAll();
            for (Prodotti p:prodottidalDB){
                logger.info("Nome del prodotto: "+p.getNome());
                logger.info("Quantita: "+p.getQuantita());
                logger.info("Prezzo: "+p.getPrezzo());
                logger.info("Data di scadenza: "+p.getDatascadenza());
            }
        };
    }
}
