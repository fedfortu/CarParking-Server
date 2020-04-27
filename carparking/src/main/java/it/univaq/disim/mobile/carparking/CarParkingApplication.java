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

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(CarParkingApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(UtenteRepository utenteRepository, ParcheggioRepository parcheggioRepository) {
        return (args) -> {
            Utente dendip = new Utente();
            dendip.setUsername("dendip");
            dendip.setPassword(passwordEncoder.encode("password"));
            dendip.setNome("Denis");
            dendip.setCognome("Di Patrizio");
            dendip.setEmail("denisdipatrizio4@gmail.com");
            dendip = utenteRepository.save(dendip);

            Utente fedefo = new Utente();
            fedefo.setUsername("fedefo");
            fedefo.setPassword(passwordEncoder.encode("password"));
            fedefo.setNome("Federico");
            fedefo.setCognome("Fortunato");
            fedefo.setEmail("fedfortu22@gmail.com");
            fedefo = utenteRepository.save(fedefo);

            Parcheggio SanFrancesco = new Parcheggio();
            SanFrancesco.setNome("SanFrancesco");
            SanFrancesco.setDescrizione("Bel parcheggio");
            SanFrancesco.setOrario("13:00");
            SanFrancesco.setCosto("1 Ora : 5€" + "2 Ore : 10€"+ " 3+ Ore : 15€");
            SanFrancesco = parcheggioRepository.save(SanFrancesco);
        };
    }
}
