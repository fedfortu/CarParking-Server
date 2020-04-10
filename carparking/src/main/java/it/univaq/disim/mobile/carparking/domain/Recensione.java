package it.univaq.disim.mobile.carparking.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Column(name = "DATA_PUBBLICAZIONE", nullable = false)
    private Date dataPubblicazione;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente pubblicatoDa;

    @ManyToOne
    @JoinColumn(name = "ID_PARCHEGGIO", nullable = false)
    private Parcheggio riferitoA;

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

    public Utente getPubblicatoDa() {
        return pubblicatoDa;
    }

    public void setPubblicatoDa(Utente pubblicatoDa) {
        this.pubblicatoDa = pubblicatoDa;
    }

    public Parcheggio getRiferitoA() {
        return riferitoA;
    }

    public void setRiferitoA(Parcheggio riferitoA) {
        this.riferitoA = riferitoA;
    }

}


