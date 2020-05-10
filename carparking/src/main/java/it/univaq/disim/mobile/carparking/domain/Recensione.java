package it.univaq.disim.mobile.carparking.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recensioni")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECENSIONE", nullable = false)
    private Long id;

    @Column(name = "TITOLO", nullable = false, length = 255)
    private String titolo;

    @Column(name = "DESCRIZIONE", nullable = false, length = 255)
    private String descrizione;

    @Column(name = "DATA_PUBBLICAZIONE")
    private Date dataPubblicazione;

    @Column(name= "RATING", nullable = false)
    private int rating;


    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "ID_PARCHEGGIO", nullable = false)
    private Parcheggio parcheggio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return titolo;
    }

    public void setNome(String nome) {
        this.titolo = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}


