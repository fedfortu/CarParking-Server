package it.univaq.disim.mobile.carparking.api;

import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.domain.Preferiti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferiti")
public class RESTPreferitiController  {

    @Autowired
    private CarParkingService service;

    @GetMapping
    public List<Preferiti> list() {
        return service.findAllPreferiti();
    }

    @GetMapping("/{idUtente}")
    public List<Preferiti> findAllByIdUtente(@PathVariable long idUtente) {
        return service.findAllByIdUtente(idUtente);
    }

    @PostMapping
    public void createPreferito(@RequestBody Preferiti preferito) {
        List<Preferiti> pref = service.findAllByIdUtente(preferito.getUtente().getId());
        if (! pref.contains(preferito)) {
            service.createPreferito(preferito);
        }
    }

    @DeleteMapping("/{idPreferiti}")
    public void deletePreferito(@PathVariable long idPreferiti){
        service.deletePreferito(idPreferiti);
    }
}
