package it.polito.tdp.libretto;
import java.time.LocalDate;

public class Voto
{
	public Voto(int voto, String corso, LocalDate data) {
		super();
		this.punti = voto;
		this.corso = corso;
		this.data = data;
	}
	
	private int punti;
	public int getPunti() {
		return punti;
	}


	public void setPunti(int punti) {
		this.punti = punti;
	}


	public String getCorso() {
		return corso;
	}


	public void setCorso(String corso) {
		this.corso = corso;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	private String corso;
	private LocalDate data; //alternative obsolete: date, calendar
	
	//TODO cambiare formattazione
	
	@Override
	public String toString() {
		return punti + " " + corso + " " + data.toString();
	}
	
	
	
	

	
	
	
	
}
