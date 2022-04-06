package com.devlec.ApplicazioneRestSpringEsame.persistenza;

import com.devlec.ApplicazioneRestSpringEsame.Model.Prodotti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotti, Long>{
    List<Prodotti> findByNome(String NomeProd);
    List<Prodotti> findBydatascadenzaBetween(Date datascadenza);
}
