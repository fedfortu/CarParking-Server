package it.univaq.disim.mobile.carparking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parcheggio")
public class Parcheggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARCHEGGIO", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "DESCRIZIONE", nullable = false, length = 255)
    private String descrizione;

    @Column(name = "COSTO", nullable = false, length = 50)
    private String costo;

    @Column(name = "ORARIO", nullable = false, length = 10)
    private String orario;

    @Column(name= "RATING", nullable = false, length = 2)
    private int rating;

    @Column(name = "PROVINCIA", nullable = false)
    private String provincia;

    @Enumerated(EnumType.STRING)
    private ValutazioneParcheggio valutazioneParcheggio;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public ValutazioneParcheggio getValutazioneParcheggio() {
        return valutazioneParcheggio;
    }

    public void setValutazioneParcheggio(ValutazioneParcheggio valutazioneParcheggio) {
        this.valutazioneParcheggio = valutazioneParcheggio;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
