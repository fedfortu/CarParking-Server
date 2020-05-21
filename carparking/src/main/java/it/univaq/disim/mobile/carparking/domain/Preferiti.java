package it.univaq.disim.mobile.carparking.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "preferiti")
public class Preferiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PREFERITO", nullable = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente utente;



    @ManyToOne
    @JoinColumn(name = "ID_PARCHEGGIO", nullable = false)
    private Parcheggio parcheggio;

    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }

    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Parcheggio getParcheggio() {
        return parcheggio;
    }
    public void setParcheggio(Parcheggio parcheggio) {
        this.parcheggio = parcheggio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preferiti preferiti = (Preferiti) o;
        return utente.equals(preferiti.utente) &&
                parcheggio.equals(preferiti.parcheggio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utente, parcheggio);
    }
}

