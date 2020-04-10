package it.univaq.disim.mobile.carparking.business;

import it.univaq.disim.mobile.carparking.domain.Utente;


public interface CarParkingService {

    Utente findUtenteByUsername(String username) throws BusinessException;
}
