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
	 * @return {@code true} nel caso normale, {@code false} se non è riuscito ad aggiungere il vuoto
	 */
	public boolean add(Voto v) 
	{
		if (!this.esisteGiaVoto(v) && !this.votoInConflitto(v))
		{
			voti.add(v);
			return true;
		}
		else
			return false;
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
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esiste
	 */
	public Voto cercaEsame(String nomeEsame)
	{
		//M1
		/*for (Voto v :this.voti)
		{
			if (v.getCorso().equals(nomeEsame))
				return v;
		}*/
		
		//meglio, non mi prendo carico della complessità, ma utilizzo metodo apposito
		Voto voto = new Voto(0, nomeEsame, null); //oggetto voto fasullo
		int pos = this.voti.indexOf(voto);
		if (pos == -1)
			return null;
		else
			return this.voti.get(pos);
	}
	
	/**
	 * Dato un {lLink Voto}, determina se esiste già un voto con uguale corso e punteggio
	 * @param v
	 * @return {@code true}, se ha trovato un corso e punteggio uguali,  {@code false} se non ha trovato corso o lo ha trovato con un voto diverso
	 */
	public boolean esisteGiaVoto(Voto v)
	{
		//meglio
		int pos = this.voti.indexOf(v);
		if (pos == -1)
			return false;
		else
			return v.getPunti() == this.voti.get(pos).getPunti();
		
		/*
		Voto trovato = this.cercaEsame(v.getCorso());
		if (trovato == null)
			return false;
		if (trovato.getPunti() == v.getPunti())
			return true;
		else
			return false;
		*/
	}
	
	/**
	 * Mi dice se il {@link Voto} {@code v} è in confrillo con uno dei voti esistenti
	 * Se il voto non esiste non c'è conflitto, se esiste ed ha punteggio diverso c'è conflitto
	 * @param v
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso,
	 * 			{@code false} se il voto non eiste, oppure esiste ma ha lo stesso punteggio
	 */
	public boolean votoInConflitto(Voto v)
	{
		int pos = this.voti.indexOf(v);
		if (pos == -1)
			return false;
		else
			return v.getPunti() != this.voti.get(pos).getPunti();
	}

	@Override
	public String toString() 
	{	
		return this.voti.toString();
	}
	
	public Libretto LibrettoMigliorato()
	{
		Libretto nuovo = new Libretto();
		for (Voto v : this.voti)
			//senza istanza new, nuovo e vecchio hanno stesse referenze, così invece creo clone indipendente
			//clone è un metodo di factory (fa new)
		{
			nuovo.add(v.clone());
		}
		for (Voto v : nuovo.voti)
		{
			int punti = v.getPunti();
			if (punti < 24)
				punti = punti + 1;
			else if (punti <= 28)
				punti = punti + 2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi()
	{
		//non posso cancellare elementi mentre itero
		/*
		for (Voto v : this.voti)
		{
			if (v.getPunti() < 24)
				this.voti.remove(v);
		}
		*/
		List<Voto> cancellare = new ArrayList<Voto>();
		for (Voto v : this.voti)
		{
			if (v.getPunti() < 24)
				cancellare.add(v);
		}
		this.voti.removeAll(cancellare);
	}
	
}
