package net.gps.model;

import java.io.Serializable;


public class Gps implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private String Latitude;
    private String Longitude;
    private long HeureDePassage;
    private String IdActivite;
    
  
    public String getLatitude() {
        return Latitude;
    }
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }
   
    public String getLongitude() {
        return Longitude;
    }
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }
    
    public long getHeureDePassage() {
        return HeureDePassage;
    }
    public void setHeureDePassage(long HeureDePassage) {
        this.HeureDePassage = HeureDePassage;
    }
    
    public String getIdActivite() {
        return IdActivite;
    }
    public void setIdActivite(String IdActivite) {
        this.IdActivite = IdActivite;
    }
    
}
