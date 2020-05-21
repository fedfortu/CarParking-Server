package it.univaq.disim.mobile.carparking.domain;

import javax.persistence.*;
import java.util.Objects;

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

    @Column(name = "INDIRIZZO", nullable = false, length = 255)
    private String indirizzo;

    @Column(name = "TELEFONO", nullable = false, length = 255)
    private String telefono;


    @Column(name = "COSTO_1_ORA", nullable = false, length = 50)
    private String costo1ora;

    @Column(name = "COSTO_24_ORE", nullable = false, length = 50)
    private String costo24ore;

    @Column(name = "COSTO_MENSILE", nullable = false, length = 50)
    private String costoMensile;

    @Column(name = "ORARIO", nullable = false, length = 100)
    private String orario;

    @Column(name= "RATING", nullable = false, length = 2)
    private int rating;

    @Column(name = "PROVINCIA", nullable = false)
    private String provincia;

    @Enumerated(EnumType.STRING)
    private ValutazioneParcheggio valutazioneParcheggio;

    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;

    @Transient
    public boolean piaciuto;

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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCosto1ora() {
        return costo1ora;
    }

    public void setCosto1ora(String costo1ora) {
        this.costo1ora = costo1ora;
    }

    public String getCosto24ore() {
        return costo24ore;
    }

    public void setCosto24ore(String costo24ore) {
        this.costo24ore = costo24ore;
    }

    public String getCostoMensile() {
        return costoMensile;
    }

    public void setCostoMensile(String costoMensile) {
        this.costoMensile = costoMensile;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcheggio that = (Parcheggio) o;
        return indirizzo.equals(that.indirizzo) &&
                latitude.equals(that.latitude) &&
                longitude.equals(that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indirizzo, latitude, longitude);
    }
}
