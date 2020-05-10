package it.univaq.disim.mobile.carparking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.domain.Recensione;

@RestController
@RequestMapping("/api/recensioni")
public class RESTRecensioniController {


    @Autowired
    private CarParkingService service;

    @GetMapping("/{idRecensione}")
    public Recensione findRecensioneById(@PathVariable long idRecensione) {
        return service.findRecensioneById(idRecensione);
    }

    @PostMapping
    public void createRecensione(@RequestBody Recensione recensione) {
        service.createRecensione(recensione);
    }

    @PutMapping
    public void updateRecensione(@RequestBody Recensione recensione) {
        service.updateRecensione(recensione);
    }

    @DeleteMapping("/{idRecensione}")
    public void deleteRecensione(@PathVariable long idRecensione) { service.deleteRecensione(idRecensione); }


}
