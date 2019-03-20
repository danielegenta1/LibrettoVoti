package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr = new Libretto();
		libr.add(new Voto(30, "Analisi I", LocalDate.of(2019, 01, 15)));
		libr.add(new Voto(21, "Analisi II", LocalDate.of(2018, 01, 25)));
		libr.add(new Voto(25, "Fisica I", LocalDate.of(2017, 06, 10)));
		libr.add(new Voto(28, "Fisica II", LocalDate.of(2018, 01, 15)));
		libr.add(new Voto(18, "Programmazione a oggetti", LocalDate.of(2019, 01, 19)));
		libr.add(new Voto(20, "Geometria", LocalDate.of(2018, 01, 30)));
		libr.add(new Voto(25, "Economia", LocalDate.of(2018, 06, 15)));
		libr.add(new Voto(24, "Ricerca operativa", LocalDate.of(2017, 02, 15)));
		libr.add(new Voto(25, "Complementi di economia", LocalDate.of(2019, 01, 15)));
		libr.add(new Voto(25, "Logistica", LocalDate.of(2019, 01, 15)));
		
		List<Voto> venticinque =  libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1 = libr.cercaEsame("Analisi I");
		Voto a3 = libr.cercaEsame("Analisi III");
		
		System.out.println(a1);
		System.out.println(a3);
		
		Voto giusto = new Voto(20, "Geometria", LocalDate.now());
		Voto sbagliato = new Voto(28, "Geometria", LocalDate.now());
		Voto mancante = new Voto(30, "Merendine", LocalDate.now());
		System.out.format("Il voto %s è %s\n", giusto.toString(), libr.esisteGiaVoto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), libr.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), libr.esisteGiaVoto(mancante));

	}

}
