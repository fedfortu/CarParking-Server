package it.univaq.disim.mobile.carparking.business;

import java.util.List;

import it.univaq.disim.mobile.carparking.domain.Utente;

public interface CarParkingService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

}
