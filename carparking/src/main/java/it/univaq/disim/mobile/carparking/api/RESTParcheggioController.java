package it.univaq.disim.mobile.carparking.api;

import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.common.Utility;
import it.univaq.disim.mobile.carparking.domain.Parcheggio;
import it.univaq.disim.mobile.carparking.domain.Preferiti;
import it.univaq.disim.mobile.carparking.domain.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parcheggio")
public class RESTParcheggioController {

    @Autowired
    private CarParkingService service;

    @GetMapping
    public List<Parcheggio> list() {
        List<Parcheggio> parcheggi = service.findAllParcheggi();
        List<Preferiti> preferiti = service.findAllByIdUtente(Utility.getUtente().getId());

        for (Parcheggio p: parcheggi) {
            for (Preferiti pf: preferiti) {
                if (p.equals(pf.getParcheggio())) {
                    p.piaciuto = true;
                }
            }
        }

        return parcheggi;
    }

    @GetMapping("/{id}")
    public Parcheggio findById(@PathVariable Long id) {
        List<Preferiti> preferiti = service.findAllByIdUtente(Utility.getUtente().getId());
        Parcheggio parcheggio = service.findParcheggioById(id);
        for (Preferiti pf: preferiti) {
            if (parcheggio.equals(pf.getParcheggio())) {
                parcheggio.piaciuto = true;
            }
        }
        return parcheggio;
    }

    @GetMapping("/{idParcheggio}/recensioni")
    public List<Recensione> list(@PathVariable long idParcheggio) {
        return service.findAllRecensioni(idParcheggio);
    }
}
