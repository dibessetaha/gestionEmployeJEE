package com.webproject.bdd;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webproject.beans.User;

public class Users {
	private Connection conn ; 
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>() ; 
		
		Statement st=null;
		ResultSet rs = null;
		//Connection a la base de donnees 
		loadDatabase() ; 
	
		try {
    		String sql="select * from users";
    		st = conn.createStatement();
    		System.out.println("Succes d'exec de la requete!!");
    		rs=st.executeQuery(sql);	
			while(rs.next()) {
				int id = rs.getInt("id")  ;
				String username = rs.getString("username") ; 
				String nom = rs.getString("nom") ; 
				String prenom = rs.getString("prenom") ; 
				String pass = rs.getString("password") ; 
				String role = rs.getString("role") ; 
				String dateNaissance = rs.getString("dateNaissance") ; 
				String email = rs.getString("email") ; 
				String cv = rs.getString("cv") ; 
				User user = new User() ;
				user.setId(id);
				user.setUsername(username);
				user.setPassword(pass);
				user.setRole(role);
				user.setNom(nom);
				user.setCv(cv);
				user.setPrenom(prenom);
				user.setDateNaissance(dateNaissance);
				user.setEmail(email);
				users.add(user) ; 
			
		
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
		return users ; 
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
	    
	  public void addUser(User user) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `users` (`nom`, `prenom`, `email`, `password`, `username`, `cv`, `dateNaissance`, `role`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.setString(5, user.getUsername());
	            preparedStatement.setString(6, user.getCv());
	            preparedStatement.setString(7, user.getDateNaissance());
	            preparedStatement.setString(8, user.getRole());
	            preparedStatement.executeUpdate();
	            System.out.println("requete insert ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void updateUser(User user, int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `users` SET "
	            		+ "`nom` = ?, `prenom` = ?, `email` = ?,"
	            		+ " `password` = ?, `username` = ?, `cv` = ?,"
	            		+ " `dateNaissance` = ?, `role` = ?  WHERE `users`.`id` = ?;");
	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getPassword());
	            preparedStatement.setString(5, user.getUsername());
	            preparedStatement.setString(6, user.getCv());
	            preparedStatement.setString(7, user.getDateNaissance());
	            preparedStatement.setString(8, user.getRole());
	            preparedStatement.setInt(9,id);
	            preparedStatement.executeUpdate();
	            System.out.println("requete update ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public void deleteUser(int id) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `users` WHERE id = ?");
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate(); 
	            System.out.println(id);
	            System.out.println("requete delete ok");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

