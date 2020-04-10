package it.univaq.disim.mobile.carparking.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import it.univaq.disim.mobile.carparking.common.spring.security.UserDetailsImpl;
import it.univaq.disim.mobile.carparking.domain.Utente;

public class Utility {

	public static Utente getUtente() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
			return userDetailsImpl.getUtente();

		} else {
			return null;
		}
		
	}
}
