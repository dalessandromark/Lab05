package it.polito.tdp.anagrammi.model;


import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	List<Anagramma> soluzioniC;
	List<Anagramma> soluzioniE;
	ParolaDAO pdao;
	
	public Model() {
		pdao = new ParolaDAO();
	}
	
	
	
	public void calcolaAnagrammiPubblico(String p) {
		Anagramma parziale = new Anagramma();
		this.soluzioniC = new ArrayList<Anagramma>();
		this.soluzioniE = new ArrayList<Anagramma>();
		this.calcolaAnagrammi(p, parziale, 0);	
	}
	

	private void calcolaAnagrammi(String p, Anagramma parziale, int L) {
		
		if(L == p.length()) {
			if(pdao.isCorrect(parziale)) {
				soluzioniC.add(parziale.clone());
			} else {
				soluzioniE.add(parziale.clone());
			}
				
			return;
		}
		
		for(Character c : p.toCharArray()) {
			
			if(!parziale.contains(c)) {
				parziale.add(c);
				
				calcolaAnagrammi(p, parziale, L+1);
				
				//backtrack
				parziale.remove(c);
			}
			
		}
		
	}
	
	
	
	public String getSoluzioniCToString() {
		String s = new String();
		for(Anagramma a : soluzioniC) {
			s = s+""+a.getString()+"\n";
		}
		return s;
	}
	
	public String getSoluzioniEToString() {
		String s = new String();
		for(Anagramma a : soluzioniE) {
			s = s+""+a.getString()+"\n";
		}
		return s;
	}





}
