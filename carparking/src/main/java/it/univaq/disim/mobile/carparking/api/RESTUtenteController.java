package it.univaq.disim.mobile.carparking.api;

import javax.servlet.http.HttpServletResponse;

import it.univaq.disim.mobile.carparking.domain.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import it.univaq.disim.mobile.carparking.business.CarParkingService;
import it.univaq.disim.mobile.carparking.common.spring.security.JWTTokenUtil;
import it.univaq.disim.mobile.carparking.common.spring.security.UserDetailsImpl;
import it.univaq.disim.mobile.carparking.domain.Utente;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

	@Value("${jwt.token.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private CarParkingService carParkingService;

	@PostMapping("/login")
	public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
		// Effettuo l'autenticazione
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Genero Token e lo inserisco nell'header di risposta
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtTokenUtil.generateToken(userDetails);
		response.setHeader(tokenHeader, token);

		// Ritorno l'utente
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@PostMapping("/utente/updateprofilo")
	public UtenteResponse updateProfilo(@RequestBody Utente utente) {
		Utente nuovoUtente = carParkingService.updateProfilo(utente);
		return new UtenteResponse(nuovoUtente);
	}

	@PostMapping("/login/registrazione")
	public UtenteResponse nuovoUtente(@RequestBody RegistrazioneRequest registrazioneRequest, HttpServletResponse response) {
		Utente nuovoUtente = carParkingService.nuovoUtente(registrazioneRequest);
		return new UtenteResponse(nuovoUtente);
	}
	@GetMapping("/utente/recensioni")
	public List<Recensione> findRecensioniUtente() { return carParkingService.findRecensioniUtente();
	}
	
}
