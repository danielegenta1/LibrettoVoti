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
	
	/*
	public void stampaVoti(int voto)
	{
		
	}
	
	public String stampaVoti2(int voto)
	{
		
	}
	*/
	
	//m3 - meglio
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti punteggio da ricercare
	 * @return lista di {@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int punti) 
	{
		List<Voto> result = new ArrayList<Voto>();
		for (Voto v : this.voti)
		{
			//non sto creando alcun oggetto nuovo, copio solamente la ref. in una lista (op. leggera)
			if (v.getPunti() == punti)
				result.add(v);
		}
		return result;
	}
}
