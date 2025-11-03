package conversionTaux.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Taux")
public class TauxEntity  {
    private int idTaux;
    private String monnaieA;
    private String monnaieB;
    private double taux;

    public TauxEntity() {
    }

    public TauxEntity(int idTaux, String monnaieA, String monnaieB, double taux)
	{
        this.idTaux = idTaux;
        this.monnaieA = monnaieA;
        this.monnaieB = monnaieB;
        this.taux = taux;
    }

    @Id
    @GeneratedValue
    public int getIdTaux() {
        return this.idTaux;
    }
    
    public void setIdTaux(int idTaux) {
        this.idTaux = idTaux;
    }

    public String getMonnaieA() {
        return this.monnaieA;
    }

     public String getMonnaieB() {
        return this.monnaieB;
    }

   public double getTaux() {
        return this.taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void setMonnaieA(String MonnaieA) {
        this.monnaieA = MonnaieA;
    }

    public void setMonnaieB(String MonnaieB) {
        this.monnaieB = MonnaieB;
    }
}
