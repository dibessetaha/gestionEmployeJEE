package com.webproject.beans;

public class User {
	private int id ; 
	private String username  ; 
	private String password  ; 
	private String nom  ; 
	private String email  ; 
	private String prenom  ; 
	private String role ; 
	private String dateNaissance ; 
	private String contrat ; 
	private String cv ; 
	private boolean validPass = false;
	private boolean validId = false;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String date) {
		this.dateNaissance = date;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getContrat() {
		return contrat;
	}
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}
	public boolean isValidPass(String username, String pass ) {
		if(pass.equals(password) && username.equals(username)) validPass = true ;
			return validPass ; 
	}
	public boolean isValidId(int id ) {
		if(this.id == id) validId = true ;
			return validId ; 
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}

