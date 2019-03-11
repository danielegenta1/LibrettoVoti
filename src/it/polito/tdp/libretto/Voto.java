package it.polito.tdp.libretto;
import java.time.LocalDate;

public class Voto
{
	public Voto(int voto, String corso, LocalDate data) {
		super();
		this.voto = voto;
		this.corso = corso;
		this.data = data;
	}
	
	private int voto;
	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
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
	
	

	
	
	
	
}
