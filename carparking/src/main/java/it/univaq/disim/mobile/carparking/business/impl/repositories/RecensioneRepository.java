package it.univaq.disim.mobile.carparking.business.impl.repositories;

import java.util.List;

import it.univaq.disim.mobile.carparking.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import it.univaq.disim.mobile.carparking.domain.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione, Long>{

    List<Recensione> findRecensioneByParcheggioId(long idParcheggio);

    List<Recensione> findRecensioneByUtente(Utente utente);

}
