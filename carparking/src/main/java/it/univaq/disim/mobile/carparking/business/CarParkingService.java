package it.univaq.disim.mobile.carparking.business;

import it.univaq.disim.mobile.carparking.api.RegistrazioneRequest;
import it.univaq.disim.mobile.carparking.domain.Parcheggio;
import it.univaq.disim.mobile.carparking.domain.Utente;

import java.util.List;

public interface CarParkingService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

	Parcheggio findParcheggioById(Long id) throws BusinessException;

	List<Parcheggio> findAllParcheggi() throws BusinessException;


}
