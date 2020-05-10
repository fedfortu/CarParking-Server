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
    public CommandLineRunner loadData(UtenteRepository utenteRepository, ParcheggioRepository parcheggioRepository, RecensioneRepository recensioneRepository) {
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
            SanFrancesco.setDescrizione("Bel parcheggio, un po disordinato ma tutto sommato ok." +
                    "custodito, e video sorvegliato, non del tutto pulito." +
                    "belli gli arredamenti. Mi piacciono molto gli interni di questo parcheggio particolari dettagli");
            SanFrancesco.setOrario("13:00");
            SanFrancesco.setCosto("1 Ora : 5€" + "2 Ore : 10€"+ " 3+ Ore : 15€");
            SanFrancesco.setRating(2);
            SanFrancesco.setProvincia("L'Aquila");
            SanFrancesco = parcheggioRepository.save(SanFrancesco);


            Parcheggio Garibaldi = new Parcheggio();
            Garibaldi.setNome("Parking Viminale");
            Garibaldi.setDescrizione("Bel parcheggio, un po disordinato ma tutto sommato ok." +
                    "custodito, e video sorvegliato, non del tutto pulito." +
                    "belli gli arredamenti. Mi piacciono molto gli interni di questo parcheggio particolari dettagli");
            Garibaldi.setOrario("13:00");
            Garibaldi.setCosto("1 Ora : 5€" + "2 Ore : 10€"+ " 3+ Ore : 15€");
            Garibaldi.setRating(2);
            Garibaldi.setProvincia("Teramo");
            Garibaldi = parcheggioRepository.save(Garibaldi);

            Recensione recensione1 = new Recensione();
            recensione1.setNome("Bel parcheggio, mi piace");
            recensione1.setDescrizione("Ottimo parcheggio pensavo peggio ma alla fine mi piace molto e sono molto soddisfatto del parcheggio ");
            recensione1.setDataPubblicazione(new Date(System.currentTimeMillis()));
            recensione1.setUtente(dendip);
            recensione1.setParcheggio(SanFrancesco);
            recensione1.setRating(3);
            recensione1 =  recensioneRepository.save(recensione1);

            Recensione recensione2 = new Recensione();
            recensione2.setNome("Ottimo parcheggio");
            recensione2.setDescrizione("Ottimo parcheggio pensavo peggio ma alla fine mi piace molto e sono molto soddisfatto del parcheggio ");
            recensione2.setDataPubblicazione(new Date(System.currentTimeMillis()));
            recensione2.setUtente(fedefo);
            recensione2.setParcheggio(SanFrancesco);
            recensione2.setRating(4);
            recensione1 =  recensioneRepository.save(recensione2);

        };
    }
}
