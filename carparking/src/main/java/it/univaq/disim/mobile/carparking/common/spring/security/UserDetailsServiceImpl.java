package it.univaq.disim.mobile.carparking.common.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.domain.Utente;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CarParkingService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = service.findUtenteByUsername(username);
        if (utente == null) {
            throw new UsernameNotFoundException("utente inesistente");
        }
        return new UserDetailsImpl(utente);

    }

}
