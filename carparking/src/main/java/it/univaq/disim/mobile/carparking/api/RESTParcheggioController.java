package it.univaq.disim.mobile.carparking.api;

import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.domain.Parcheggio;
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
        return service.findAllParcheggi();
    }

    @GetMapping("/{id}")
    public Parcheggio findById(@PathVariable Long id) {
        return service.findParcheggioById(id);
    }

    @GetMapping("/{idParcheggio}/recensioni")
    public List<Recensione> list(@PathVariable long idParcheggio) {
        return service.findAllRecensioni(idParcheggio);
    }
}
