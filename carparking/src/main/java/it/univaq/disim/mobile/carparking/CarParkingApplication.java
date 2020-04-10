package it.univaq.disim.mobile.carparking;

import it.univaq.disim.mobile.carparking.business.impl.repositories.*;
import it.univaq.disim.mobile.carparking.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class CarParkingApplication {



    public static void main(String[] args) {
        SpringApplication.run(CarParkingApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(UtenteRepository utenteRepository) {
        return (args) -> {
            Utente amleto = new Utente();
            amleto.setUsername("amleto");
            amleto.setPassword("amleto");
            amleto.setNome("Amleto");
            amleto.setCognome("Di Salle");
            amleto.setEmail("amleto.disalle@univaq.it");
            amleto = utenteRepository.save(amleto);
        };
    }
}
