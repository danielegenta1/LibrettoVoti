package it.polito.tdp.libretto;
import java.time.LocalDate;

public class Voto
{
	public Voto(int voto, String corso, LocalDate data)
	{
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
	
	//TODO cambiare formattazione
	
	@Override
	public String toString() {
		return punti + " " + corso + " " + data.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	
	public Voto clone() {
		return new Voto(this.punti, this.corso, this.data) ;
	}
	
}
