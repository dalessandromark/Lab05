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
			if(pdao.isCorrect(parziale) && isIn(parziale, soluzioniC)==false) {
				soluzioniC.add(parziale.clone());
			} else if(!pdao.isCorrect(parziale) && isIn(parziale, soluzioniE)==false){
				soluzioniE.add(parziale.clone());
			}
				
			return;
		}
		
		for(Character c : p.toCharArray()) {
			
			if(contaLettera(c, p)>contaLettera(c, parziale.getString())) {
				parziale.add(c);
				
				calcolaAnagrammi(p, parziale, L+1);
				
				//backtrack
				parziale.remove(c);
			}
			
		}
		
	}
	
	
	
	public int contaLettera(Character c, String iniziale) {
		int count = 0;
		for(int i=0; i<iniziale.length(); i++) {
			if(iniziale.charAt(i)==c)
				count++;
		}
		return count;
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

	public boolean isIn(Anagramma a, List<Anagramma> l) {
		boolean check = false;
		for(Anagramma x : l) {
			if(x.getString().equals(a.getString())) {
				check = true;
			}
		}
		return check;
	}




}
