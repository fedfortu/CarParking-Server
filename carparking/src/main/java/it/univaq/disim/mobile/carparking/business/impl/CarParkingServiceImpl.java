package it.univaq.disim.mobile.carparking.business.impl;

import it.univaq.disim.mobile.carparking.api.RegistrazioneRequest;
import it.univaq.disim.mobile.carparking.business.BusinessException;
import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.business.impl.repositories.ParcheggioRepository;
import it.univaq.disim.mobile.carparking.business.impl.repositories.UtenteRepository;
import it.univaq.disim.mobile.carparking.domain.Parcheggio;
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

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
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
}
