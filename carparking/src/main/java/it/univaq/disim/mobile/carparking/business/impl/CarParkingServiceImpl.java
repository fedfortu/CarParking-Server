package it.univaq.disim.mobile.carparking.business.impl;

import it.univaq.disim.mobile.carparking.business.BusinessException;
import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.business.impl.repositories.UtenteRepository;
import it.univaq.disim.mobile.carparking.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarParkingServiceImpl implements CarParkingService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public Utente findUtenteByUsername(String username) throws BusinessException {
        return utenteRepository.findByUsername(username);
    }
}
