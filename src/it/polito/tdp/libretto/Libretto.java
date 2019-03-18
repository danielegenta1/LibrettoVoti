package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto 
{
	private List<Voto> voti;
	
	public Libretto()
	{
		this.voti = new ArrayList<Voto>();
	}
	
	//m1
	/*public void add(int voto, String corso, LocalDate data) 
	{
		
	}*/
	
	//m2 - meglio (per modifiche future...)
	/**
	 * Aggiunge nuovo voto al libretto
	 * @param v il {@link Voto} da aggiungere
	 */
	public void add(Voto v) 
	{
		voti.add(v);
	}
}
