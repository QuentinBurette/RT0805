package net.activite.model;

import java.io.Serializable;


public class Activite implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String IdActivite;
    private String TypeActivite;
    private String HeureDebut;
    private String HeureFin;
    private String DistanceParcourue;
    private String CoordonneesGPS;
    private String IdUtilisateur;
    
  
    
    public String getIdActivite() {
        return IdActivite;
    }
   
    
    public String getTypeActivite() {
        return TypeActivite;
    }
    public void setTypeActivite(String TypeActivite) {
        this.TypeActivite = TypeActivite;
    }
    
    
    
    public String getHeureDebut() {
        return HeureDebut;
    }
    public void setHeureDebut(String HeureDebut) {
        this.HeureDebut = HeureDebut;
    }
    
    public String getHeureFin() {
        return HeureFin;
    }
    public void setHeureFin(String HeureFin) {
        this.HeureFin = HeureFin;
    }
    
    public String getDistanceParcourue() {
        return DistanceParcourue;
    }
    public void setDistanceParcourue(String DistanceParcourue) {
        this.DistanceParcourue = DistanceParcourue;
    }
    
    public String getCoordonneesGPS() {
        return CoordonneesGPS;
    }
    public void setCoordonneesGPS(String CoordonneesGPS) {
        this.CoordonneesGPS = CoordonneesGPS;
    }
    
    public String getIdUtilisateur() {
        return IdUtilisateur;
    }
    public void setIdUtilisateur(String IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }
}
