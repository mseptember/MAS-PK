import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity (name = "Badanie")
public class Badanie {
    // TODO atrybuty kl. Badanie
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idBadania;
    private double koszt;
    private boolean czyDofinansowane;
    // USUNĄŁEM POLE -> uzywaneMaszyny (musiałbym uwzględnić klasę Maszyna w diagramie)

    // TODO asocjacje
    @ManyToOne
    private Wizyta wizyta;

    // TODO konstruktor
    public Badanie() {
    }

    public Badanie(int idBadania, double koszt, boolean czyDofinansowane) {
        this.idBadania = idBadania;
        this.koszt = koszt;
        this.czyDofinansowane = czyDofinansowane;
    }

    // TODO metody

    public int getIdBadania() {
        return idBadania;
    }

    public void setIdBadania(int idBadania) {
        this.idBadania = idBadania;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public boolean isCzyDofinansowane() {
        return czyDofinansowane;
    }

    public void setCzyDofinansowane(boolean czyDofinansowane) {
        this.czyDofinansowane = czyDofinansowane;
    }

    @ManyToOne
    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }


    // TODO dodajNoweBadanie() met. klasowa

}
