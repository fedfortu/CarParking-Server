package it.univaq.disim.mobile.carparking;

import it.univaq.disim.mobile.carparking.business.impl.repositories.*;
import it.univaq.disim.mobile.carparking.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            try (InputStream is = classloader.getResourceAsStream("parcheggi.csv");
                 InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr)) {

                String row;
                while ((row = br.readLine()) != null) {
                    String[] columns;
                    columns = row.split(";");


                    Parcheggio parcheggio = new Parcheggio();
                    parcheggio.setNome(columns[1]);
                    parcheggio.setDescrizione(columns[2]);
                    parcheggio.setIndirizzo(columns[3]);
                    parcheggio.setTelefono(columns[4]);
                    parcheggio.setOrario(columns[5]);
                    parcheggio.setCosto1ora(columns[6]);
                    parcheggio.setCosto24ore(columns[7]);
                    parcheggio.setCostoMensile(columns[8]);
                    parcheggio.setRating(Integer.parseInt(columns[9]));
                    parcheggio.setProvincia(columns[10]);
                    parcheggio.setLatitude(Double.parseDouble(columns[11]));
                    parcheggio.setLongitude(Double.parseDouble(columns[12]));
                    parcheggio = parcheggioRepository.save(parcheggio);

                }
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }


            Utente dendip = new Utente();
            dendip.setUsername("dendip");
            dendip.setPassword(passwordEncoder.encode("password"));
            dendip.setNome("Denis");
            dendip.setCognome("Di Patrizio");
            dendip.setEmail("denisdipatrizio4@gmail.com");
            dendip.setLatitude(45.5787392);
            dendip.setLongitude(13.975551999999999);
            dendip = utenteRepository.save(dendip);

            Utente fedefo = new Utente();
            fedefo.setUsername("fedefo");
            fedefo.setPassword(passwordEncoder.encode("password"));
            fedefo.setNome("Federico");
            fedefo.setCognome("Fortunato");
            fedefo.setEmail("fedfortu22@gmail.com");
            fedefo.setLatitude(45.5787392);
            fedefo.setLongitude(13.975551999999999);
            fedefo = utenteRepository.save(fedefo);

            Parcheggio SanFrancesco = new Parcheggio();
            SanFrancesco.setNome("SanFrancesco");
            SanFrancesco.setDescrizione("Bel parcheggio, un po disordinato ma tutto sommato ok." +
                    "custodito, e video sorvegliato, non del tutto pulito." +
                    "belli gli arredamenti. Mi piacciono molto gli interni di questo parcheggio particolari dettagli");
            SanFrancesco.setIndirizzo("Via Piazza Dante");
            SanFrancesco.setTelefono("0861553947");
            SanFrancesco.setOrario("13:00");
            SanFrancesco.setCosto1ora("5€");
            SanFrancesco.setCosto24ore("20€");
            SanFrancesco.setCostoMensile("110€");
            SanFrancesco.setRating(2);
            SanFrancesco.setProvincia("L'Aquila");
            SanFrancesco.setLatitude(45.5787392);
            SanFrancesco.setLongitude(13.975551999999999);
            SanFrancesco = parcheggioRepository.save(SanFrancesco);


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
