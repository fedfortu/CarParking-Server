package it.univaq.disim.mobile.carparking.business.impl;

import it.univaq.disim.mobile.carparking.api.RegistrazioneRequest;
import it.univaq.disim.mobile.carparking.business.BusinessException;
import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.business.impl.repositories.ParcheggioRepository;
import it.univaq.disim.mobile.carparking.business.impl.repositories.PreferitiRepository;
import it.univaq.disim.mobile.carparking.business.impl.repositories.RecensioneRepository;
import it.univaq.disim.mobile.carparking.business.impl.repositories.UtenteRepository;
import it.univaq.disim.mobile.carparking.common.Utility;
import it.univaq.disim.mobile.carparking.domain.Parcheggio;
import it.univaq.disim.mobile.carparking.domain.Preferiti;
import it.univaq.disim.mobile.carparking.domain.Recensione;
import it.univaq.disim.mobile.carparking.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarParkingServiceImpl implements CarParkingService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ParcheggioRepository parcheggioRepository;

	@Autowired
	private RecensioneRepository recensioneRepository;

	@Autowired
	private PreferitiRepository preferitiRepository;

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		utente.setImmagineProfilo(profilo.getImmagineProfilo());
		return utente;
	}

	@Override
	public Utente updatePosition(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setLatitude(profilo.getLatitude());
		utente.setLongitude(profilo.getLongitude());
		return utente;
	}

	@Override
	public Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException{
		Utente nuovo = new Utente();
		nuovo.setNome(registrazioneRequest.getNome());
		nuovo.setCognome(registrazioneRequest.getCognome());
		nuovo.setEmail(registrazioneRequest.getEmail());
		nuovo.setUsername(registrazioneRequest.getUsername());
		nuovo.setPassword((passwordEncoder.encode(registrazioneRequest.getPassword())));
		utenteRepository.save(nuovo);
		return nuovo;
	}

	@Override
	public Parcheggio findParcheggioById(Long id) throws BusinessException {
		return parcheggioRepository.findById(id).get();
	}

	@Override
	public List<Parcheggio> findAllParcheggi() throws BusinessException {
		return parcheggioRepository.findAll(JpaSort.unsafe(Sort.Direction.DESC, "nome"));
	}

	@Override
	public List<Recensione> findAllRecensioni(long idParcheggio) throws BusinessException {
		return recensioneRepository.findRecensioneByParcheggioId(idParcheggio);
	}

	@Override
	public void createRecensione(Recensione recensione) throws BusinessException {
		recensione.setUtente(Utility.getUtente());
		recensioneRepository.save(recensione);
	}

	@Override
	public Recensione findRecensioneById(long idRecensione) throws BusinessException {
		return recensioneRepository.findById(idRecensione).get();
	}

	@Override
	public void updateRecensione(Recensione recensione) throws BusinessException {
		recensione.setUtente(Utility.getUtente());
		recensioneRepository.save(recensione);
	}

	public List<Recensione> findRecensioniUtente() {
		return recensioneRepository.findRecensioneByUtente(Utility.getUtente());
	}

	@Override
	public void deleteRecensione(long idRecensione) throws BusinessException {
		recensioneRepository.deleteById(idRecensione);

	}

	@Override
	public List<Preferiti> findAllPreferiti() throws BusinessException {
		return preferitiRepository.findAll();
	}

	@Override
	public List<Preferiti> findAllByIdUtente(long idUtente) throws BusinessException {
		return preferitiRepository.findAllByIdUtente(idUtente);
	}

	@Override
	public void createPreferito(Preferiti preferito) throws BusinessException {
		preferito.setUtente(Utility.getUtente());
		preferitiRepository.save(preferito);
	}

	@Override
	public void deletePreferito(long idPreferiti) throws BusinessException {
		preferitiRepository.deleteById(idPreferiti);
	}

}
