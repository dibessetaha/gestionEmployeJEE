package com.webproject.bdd;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webproject.beans.CongeEnDemande;


public class CongEnAttente {
	private Connection conn ; 
	public List<CongeEnDemande> getConges() {
		List<CongeEnDemande> demander = new ArrayList<CongeEnDemande>() ; 
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from congedemander ";
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				int user_id = rs.getInt("user_id") ; 
				int congee_id = rs.getInt("congee_id") ; 
				String dateDebut = rs.getString("dateDebut") ; 
				String dateFin = rs.getString("dateFin") ; 
				boolean etat = rs.getBoolean("etat") ; 
				CongeEnDemande congeEndemande = new CongeEnDemande() ;
				congeEndemande.setId(id);
				congeEndemande.setUser_id(user_id);
				congeEndemande.setCongee_id(congee_id);
				congeEndemande.setDateDebut(dateDebut);
				congeEndemande.setDateFin(dateFin);				
				congeEndemande.setEtat(etat);
				demander.add(congeEndemande) ; 
			
		
		}
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			try {
				
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
		}catch(SQLException e) {
			
		}
		}
		return demander ; 
	}
	
	public List<CongeEnDemande> getUserCongee(int user_id) {
		List<CongeEnDemande> demander = new ArrayList<CongeEnDemande>() ; 
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select distinct * from congedemander cd join congees c where cd.congee_id = c.id and user_id = ?";
    		PreparedStatement preparedStatement = conn.prepareStatement(sql);
    		preparedStatement.setInt(1,user_id);
    		rs = preparedStatement.executeQuery() ; 
    		System.out.println("Succes d'exec de la requete!!");
			while(rs.next()) {
				int id = rs.getInt("id") ; 
				boolean etat = rs.getBoolean("etat") ; 
				String dateDebut = rs.getString("dateDebut") ; 
				String raison = rs.getString("reason") ; 
				String dateFin = rs.getString("dateFin") ; 
				String intitule = rs.getString("intitule") ; 
				int nbJour = rs.getInt("nbJour") ; 
				boolean affectSalaire = rs.getBoolean("affectSalaire") ; 
 				CongeEnDemande cd = new CongeEnDemande() ;
				cd.setId(id);
				cd.setUser_id(user_id);
				cd.setDateDebut(dateDebut);
				cd.setDateFin(dateFin);				
				cd.setEtat(etat);
				cd.setIntitule(intitule);
				cd.setReason(raison);
				cd.setNbJour(nbJour);
				cd.setAffectSalaire(affectSalaire);
				demander.add(cd) ; 
			
		
		}
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			try {
				
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
		}catch(SQLException e) {
			
		}
		}
		return demander ; 
	}
	  private void loadDatabase() {
	        // Chargement du driver
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjee","root","");
	            System.out.println("Connexion OK");
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	    }
	    
	  public void addCongeEnDemande(CongeEnDemande conge ) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `congedemander` (`dateDebut`, `dateFin`, `congee_id`, `user_id`) VALUES (?, ?,?,?)");
	            preparedStatement.setString(1, conge.getDateDebut());
	            preparedStatement.setString(2, conge.getDateFin());
	            preparedStatement.setInt(3, conge.getCongee_id());
	            preparedStatement.setInt(4, conge.getUser_id());
	            preparedStatement.executeUpdate();
	            System.out.println("requete insert ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
//	  
//	  public void updateUser(User user, int id) {
//	        loadDatabase();
//	        
//	        try {
//	            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `users` SET "
//	            		+ "`nom` = ?, `prenom` = ?, `email` = ?,"
//	            		+ " `password` = ?, `username` = ?, `cv` = ?,"
//	            		+ " `dateNaissance` = ?, `role` = ?  WHERE `users`.`id` = ?;");
//	            preparedStatement.setString(1, user.getNom());
//	            preparedStatement.setString(2, user.getPrenom());
//	            preparedStatement.setString(3, user.getEmail());
//	            preparedStatement.setString(4, user.getPassword());
//	            preparedStatement.setString(5, user.getUsername());
//	            preparedStatement.setString(6, user.getCv());
//	            preparedStatement.setString(7, user.getDateNaissance());
//	            preparedStatement.setString(8, user.getRole());
//	            preparedStatement.setInt(9,id);
//	            preparedStatement.executeUpdate();
//	            System.out.println("requete update ok");
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
	  
//	  public void deleteUser(int id) {
//	        loadDatabase();
//	        
//	        try {
//	            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `users` WHERE `users`.`id` = ?");
//	            preparedStatement.setInt(1, id);
//	      
//	            System.out.println("requete delete ok");
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
}

