package it.univaq.disim.mobile.carparking.business.impl.repositories;

import it.univaq.disim.mobile.carparking.domain.Preferiti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferitiRepository  extends JpaRepository<Preferiti,Long> {

    @Query("select p from Preferiti p where p.utente like concat('%', :idUtente ,'%')")
    List<Preferiti> findAllByIdUtente(@Param("idUtente") long idUtente);
}
