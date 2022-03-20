package br.com.bar.interfaces;

import java.text.ParseException;

public interface AnalistaInterface {
	
	public abstract String ObterUltimaVisita() throws ParseException;
	
	public abstract int ObterFrequencia();
	
	public abstract double ObterMedia();
	
	public abstract String ObterFavorito();
}
