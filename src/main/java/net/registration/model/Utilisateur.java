package net.registration.model;

import java.io.Serializable;


public class Utilisateur implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String NomUtilisateur;
    private String MotDePasseUtilisateur;
    private String MailUtilisateur;
    private String AgeUtilisateur;
  
    
    public String getNomUtilisateur() {
        return NomUtilisateur;
    }
    public void setNomUtilisateur(String NomUtilisateur) {
        this.NomUtilisateur = NomUtilisateur;
    }
    
    public String getMotDePasseUtilisateur() {
        return MotDePasseUtilisateur;
    }
    public void setMotDePasseUtilisateur(String MotDePasseUtilisateur) {
        this.MotDePasseUtilisateur = MotDePasseUtilisateur;
    }
    
    public String getMailUtilisateur() {
        return MailUtilisateur;
    }
    public void setMailUtilisateur(String MailUtilisateur) {
        this.MailUtilisateur = MailUtilisateur;
    }
    
    public String getAgeUtilisateur() {
        return AgeUtilisateur;
    }
    public void setAgeUtilisateur(String ageUtilisateur) {
        this.AgeUtilisateur = ageUtilisateur;
    }
}
