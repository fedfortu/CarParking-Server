package it.univaq.disim.mobile.carparking.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.univaq.disim.mobile.carparking.domain.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
}
