package it.polito.tdp.anagrammi.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {
	
	public ArrayList<Parola> getDictionary(){
		
		final String sql = "SELECT * FROM parola";
		
		ArrayList<Parola> dictionary = new ArrayList<Parola>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery()
;			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				Parola nuova = new Parola(id, nome);
				dictionary.add(nuova);
				
			}
			
			return dictionary;
			
		} catch (SQLException e) {

			throw new RuntimeException("Errore Db");
		}
	}
	
	
	
	public Boolean isCorrect(Anagramma a) {
		
		final String sql = "SELECT * FROM parola WHERE nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			boolean result = false;
			
			String anagr = a.getString();
			
			st.setString(1, anagr);
			
			ResultSet rs = st.executeQuery()
;			
			if(rs.next())
				result = true;
			
			return result;
			
		} catch (SQLException e) {

			throw new RuntimeException("Errore Db");
		}
	}
}
