package Entities;
// Generated 19 mai 2016 09:30:32 by Hibernate Tools 4.3.1



/**
 * Niveau generated by hbm2java
 */
public class Niveau  implements java.io.Serializable {


     private Integer codeNiv;
     private String nomNiv;
     private int nombreGrp;

    public Niveau() {
    }

    public Niveau(String nomNiv) {
       this.nomNiv = nomNiv;
       this.nombreGrp = 0;
    }
   
    public Integer getCodeNiv() {
        return this.codeNiv;
    }
    
    public void setCodeNiv(Integer codeNiv) {
        this.codeNiv = codeNiv;
    }
    public String getNomNiv() {
        return this.nomNiv;
    }
    
    public void setNomNiv(String nomNiv) {
        this.nomNiv = nomNiv;
    }
    public int getNombreGrp() {
        return this.nombreGrp;
    }
    
    public void setNombreGrp(int nombreGrp) {
        this.nombreGrp = nombreGrp;
    }




}

