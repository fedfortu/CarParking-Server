package it.univaq.disim.mobile.carparking;

import it.univaq.disim.mobile.carparking.business.impl.repositories.*;
import it.univaq.disim.mobile.carparking.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                    parcheggio.setImmagineParcheggio(getImage("" + columns[13]));
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
            dendip.setImmagineProfilo(getImage("denis.jpg"));
            dendip = utenteRepository.save(dendip);

            Utente fabio = new Utente();
            fabio.setUsername("fabio");
            fabio.setPassword(passwordEncoder.encode("password"));
            fabio.setNome("Fabio");
            fabio.setCognome("Paratici");
            fabio.setEmail("fabioparatici@gmail.com");
            fabio.setLatitude(45.5787392);
            fabio.setLongitude(13.975551999999999);
            fabio.setImmagineProfilo(getImage("fabio.jpg"));
            fabio = utenteRepository.save(fabio);

            Utente arnaldo = new Utente();
            arnaldo.setUsername("arnaldo");
            arnaldo.setPassword(passwordEncoder.encode("password"));
            arnaldo.setNome("Arnaldo");
            arnaldo.setCognome("Meme");
            arnaldo.setEmail("arnaldomeme@gmail.com");
            arnaldo.setLatitude(45.5787392);
            arnaldo.setLongitude(13.975551999999999);
            arnaldo.setImmagineProfilo(getImage("arnaldo.jpg"));
            arnaldo = utenteRepository.save(arnaldo);

            Utente francesca = new Utente();
            francesca.setUsername("francesca");
            francesca.setPassword(passwordEncoder.encode("password"));
            francesca.setNome("Francesca");
            francesca.setCognome("Rossi");
            francesca.setEmail("francescarossi@gmail.com");
            francesca.setLatitude(45.5787392);
            francesca.setLongitude(13.975551999999999);
            francesca.setImmagineProfilo(getImage("francesca.jpg"));
            francesca = utenteRepository.save(francesca);

            Utente fedefo = new Utente();
            fedefo.setUsername("fedefo");
            fedefo.setPassword(passwordEncoder.encode("password"));
            fedefo.setNome("Federico");
            fedefo.setCognome("Fortunato");
            fedefo.setEmail("fedfortu22@gmail.com");
            fedefo.setLatitude(45.5787392);
            fedefo.setLongitude(13.975551999999999);
            fedefo.setImmagineProfilo(getImage("fedefo.jpg"));
            fedefo = utenteRepository.save(fedefo);

            Parcheggio SanFrancesco = new Parcheggio();
            SanFrancesco.setNome(" San Francesco");
            SanFrancesco.setDescrizione("Non videosorvegliato, illuminato, non custodito, presenza di servizi igienici. All'aperto");
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
            SanFrancesco.setImmagineParcheggio(getImage("parcheggi1.jpg"));
            SanFrancesco = parcheggioRepository.save(SanFrancesco);

            Parcheggio Belvedere = new Parcheggio();
            Belvedere.setNome("Belvedere Atri");
            Belvedere.setDescrizione("Bel parcheggio, un po disordinato ma tutto sommato ok." +
                    "custodito, e video sorvegliato, non del tutto pulito." +
                    "belli gli arredamenti. Mi piacciono molto gli interni di questo parcheggio particolari dettagli");
            Belvedere.setIndirizzo("Via Circonvallazione Nord");
            Belvedere.setTelefono("0861553829");
            Belvedere.setOrario("13:00");
            Belvedere.setCosto1ora("1€");
            Belvedere.setCosto24ore("5€");
            Belvedere.setCostoMensile("50€");
            Belvedere.setRating(4);
            Belvedere.setProvincia("Atri");
            Belvedere.setLatitude(42.580256);
            Belvedere.setLongitude(13.972040);
            Belvedere.setImmagineParcheggio(getImage("parcheggi6.jpg"));
            Belvedere = parcheggioRepository.save(Belvedere);


            Recensione recensione1 = new Recensione();
            recensione1.setNome("Bel parcheggio, mi piace");
            recensione1.setDescrizione("Ottimo parcheggio pensavo peggio ma alla fine mi piace molto e sono molto soddisfatto del parcheggio ");
            recensione1.setDataPubblicazione(new Date(System.currentTimeMillis()));
            recensione1.setUtente(francesca);
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

            Recensione recensione3 = new Recensione();
            recensione3.setNome("Parcheggio pessimo");
            recensione3.setDescrizione("Parcheggio pessimo per 3  motivi: 1) troppo caro. 2) dicono di controllare ma non è vero ( mi hanno rotto finestrino). 3) poco curato. ");
            recensione3.setDataPubblicazione(new Date(System.currentTimeMillis()));
            recensione3.setUtente(fabio);
            recensione3.setParcheggio(SanFrancesco);
            recensione3.setRating(1);
            recensione3 =  recensioneRepository.save(recensione3);

            Recensione recensione4 = new Recensione();
            recensione4.setNome("Buon Parcheggio");
            recensione4.setDescrizione("Parcheggio ben illuminato, largo e ben tenuto. Sono soddisfatto.");
            recensione4.setDataPubblicazione(new Date(System.currentTimeMillis()));
            recensione4.setUtente(arnaldo);
            recensione4.setParcheggio(SanFrancesco);
            recensione4.setRating(4);
            recensione4 =  recensioneRepository.save(recensione4);

            Recensione recensione5 = new Recensione();
            recensione5.setNome("Buon Parcheggio");
            recensione5.setDescrizione("Parcheggio ben illuminato, largo e ben tenuto. Sono soddisfatto.");
            recensione5.setDataPubblicazione(new Date(System.currentTimeMillis()));
            recensione5.setUtente(dendip);
            recensione5.setParcheggio(Belvedere);
            recensione5.setRating(4);
            recensione5 =  recensioneRepository.save(recensione5);

        };
    }

    public static byte[] getImage(String pathPhoto) {

        Path path = Paths.get("src\\main\\resources\\Immagini\\" + pathPhoto);
        File file = new File("" + path);
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bArray;
    }
}
