package it.univaq.disim.mobile.carparking.business;

import it.univaq.disim.mobile.carparking.api.RegistrazioneRequest;
import it.univaq.disim.mobile.carparking.domain.Parcheggio;
import it.univaq.disim.mobile.carparking.domain.Recensione;
import it.univaq.disim.mobile.carparking.domain.Utente;

import java.util.List;

public interface CarParkingService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

	Utente updatePosition(Utente utente) throws BusinessException;

	Parcheggio findParcheggioById(Long id) throws BusinessException;

	List<Parcheggio> findAllParcheggi() throws BusinessException;

	List<Recensione> findAllRecensioni(long idParcheggio) throws BusinessException;

	void createRecensione(Recensione recensione) throws BusinessException;

	Recensione findRecensioneById(long idRecensione) throws BusinessException;

	void updateRecensione(Recensione recensione) throws BusinessException;

	List<Recensione> findRecensioniUtente() throws BusinessException;

	void deleteRecensione(long idRecensione) throws BusinessException;



}
