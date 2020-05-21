package it.univaq.disim.mobile.carparking.api;

import it.univaq.disim.mobile.carparking.domain.Utente;

public class UtenteResponse {

	private Long id;
	private String username;
	private String nome;
	private String cognome;
	private String email;
	private Double latitude;
	private Double longitude;

	public UtenteResponse() {
	}



	public UtenteResponse(Utente utente) {
		this.id = utente.getId();
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.username = utente.getUsername();
		this.email = utente.getEmail();
		this.latitude = utente.getLatitude();
		this.longitude = utente.getLongitude();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getLatitude() { return latitude; }
	public void setLatitude(Double latitude) { this.latitude = latitude; }
	public Double getLongitude() { return longitude; }
	public void setLongitude(Double longitude) { this.longitude = longitude; }

}
