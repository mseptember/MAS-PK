import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lek {
    // TODO atrybuty kl. Lek
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idLeku;
    private String nazwa;
    private double koszt;

    // TODO asocjacje
    @ManyToMany
    private List<Wizyta> wizytaLista = new ArrayList<>();

    // TODO konstruktor
    public Lek() {
    }

    public Lek(int idLeku, String nazwa, double koszt) {
        this.idLeku = idLeku;
        this.nazwa = nazwa;
        this.koszt = koszt;
    }

    // TODO metody

    public int getIdLeku() {
        return idLeku;
    }

    public void setIdLeku(int idLeku) {
        this.idLeku = idLeku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    @ManyToMany
    public List<Wizyta> getWizytaLista() {
        return wizytaLista;
    }

    public void setWizytaLista(List<Wizyta> wizytaLista) {
        this.wizytaLista = wizytaLista;
    }
    // TODO dodajLek() met. klasowa

}
