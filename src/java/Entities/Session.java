package Entities;
// Generated 19 mai 2016 09:30:32 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Session generated by hbm2java
 */
public class Session  implements java.io.Serializable {


     private Integer idSession;
     private String libelle;
     private Date anneeUniversitaire;

    public Session() {
    }

    public Session(String libelle, Date anneeUniversitaire) {
       this.libelle = libelle;
       this.anneeUniversitaire = anneeUniversitaire;
    }
   
    public Integer getIdSession() {
        return this.idSession;
    }
    
    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Date getAnneeUniversitaire() {
        return this.anneeUniversitaire;
    }
    
    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }




}


