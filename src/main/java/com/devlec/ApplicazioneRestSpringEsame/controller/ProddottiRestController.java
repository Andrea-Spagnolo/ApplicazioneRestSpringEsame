package com.devlec.ApplicazioneRestSpringEsame.controller;

import com.devlec.ApplicazioneRestSpringEsame.Model.Prodotti;
import com.devlec.ApplicazioneRestSpringEsame.Avviso.Prodottonontrovato;
import com.devlec.ApplicazioneRestSpringEsame.persistenza.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons-csv;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.List;

@RestController
public class ProddottiRestController {
    private static Logger logger = LoggerFactory.getLogger(ProddottiRestController.class);
    private ProdottiRepository repository;

    public ProddottiRestController(ProdottiRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/prodotto")
    public List<Prodotti> leggituttiiprodotti() {
        logger.info("leggituttiiprodotti");
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public List<Prodotti> trovaprodottoconid(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new Prodottonontrovato(id));
    }

    @PostMapping("/prodotto")
    public Prodotti inseriscinuovoprodotto(@RequestBody Prodotti nuovoprodotto) {
        return repository.save(nuovoprodotto);
    }

    @PutMapping("/prodotto/{id}")
    public Prodotti aggiornadatiprodotti(@PathVariable Long id, @RequestBody Prodotti prodotti) {
        return repository.findById(id).map(
                nuovoprodotto -> {
                    nuovoprodotto.setQuantita(prodotti.getQuantita());
                    nuovoprodotto.setPrezzo(prodotti.getPrezzo());
                    return repository.save(nuovoprodotto);
                }
        ).orElseGet(
                () -> {
                    prodotti.setId(id);
                    return repository.save(prodotti);
                }
        );
    }

    @DeleteMapping("/prodotto/{id}")
    void eliminaUtente(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/prodotto/ricerca/nome/{nome}")
    List<Prodotti> cercapernome(@PathVariable String nome) {
        return repository.findByNome(nome);
    }

    @RequestMapping(path = "/prodotto/ricerca/datascadenza", method = RequestMethod.GET)
    public List<Prodotti> trovaprodottoperdatascadenza(
            @RequestParam(name = "datada")
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date from,
            @RequestParam(name = "dataa")
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date to) {
        return repository.findBydatascadenzaBetween(from, to);
    }

    private static final @PostMapping("/prodotto/csv")
    public <CSVRecord> ResponseEntity<String> caricaCSV(@RequestParam("file") MultipartFile file) {
        Reader in = null;
        try {
            in = new InputStreamReader(file.getInputStream());
// Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder().build().parse(in);
            for (CSVRecord record : records) {
                String nome = record.get(0);
                logger.info("Nome: " + nome);
                String quantita = record.get(1);
                logger.info("Quantita: " + quantita);
                String prezzo = record.get(2);
                logger.info("Prezzo: " + prezzo);
                String scadenza = record.get(0);
                logger.info("Scadenza: " + scadenza);
            }
        } catch (IOException e) {
            logger.error("Si è verificato un errore", e);
        }
        return ResponseEntity.ok("CSV");
        Logger logger = LoggerFactory.getLogger(ProddottiRestController.class);
        ProddottiRestController = Logger logger = LoggerFactory.getLogger(ProddottiRestController.class);
    }
}
