package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	
	private List<Character> caratteri;
	
	public Anagramma() {
		caratteri = new ArrayList<Character>();
	}
	
	
	
	public List<Character> getCaratteri() {
		return caratteri;
	}

	public void setCaratteri(List<Character> caratteri) {
		this.caratteri = caratteri;
	}
	

	public Anagramma clone() {
		Anagramma a = new Anagramma();
		a.caratteri = new ArrayList<>(this.caratteri);
		return a;
	}

	public boolean contains(Character c) {
		return this.caratteri.contains(c);
	}
	
	public void add(Character c) {
		this.caratteri.add(c);
	}
	
	public void remove(Character c) {
		this.caratteri.remove(c);
	}

	@Override
	public String toString() {
		return String.format("Anagramma %s", caratteri);
	}

	public String getString() {
		String s = new String();
		for(Character c : this.caratteri) {
			s = s +""+c;
		}
		return s;
	}
	

	
	
}
