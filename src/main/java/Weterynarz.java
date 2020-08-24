import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity (name = "Weterynarz")
public class Weterynarz extends Osoba implements Serializable {
    // TODO atrybuty kl. Weterynarz
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idWeterynarza;
    private String pesel;
    private Date dataUrodzenia;
    // private List<> specjalizacje // USUNĄŁEM POLE SPECJALIZACJE!!! (MUSIAŁBYM STWORZYĆ KLASĘ SPECJALIZACJA)
    private double pensja;

    // TODO ASOCJACJE
    @OneToMany
    private List<Wizyta> wizytaLista = new ArrayList<>();

    // TODO konstruktor
    public Weterynarz () {}

    public Weterynarz(String imie, String nazwisko, int idWeterynarza, String pesel, Date dataUrodzenia, double pensja) {
        super(imie, nazwisko);
        this.idWeterynarza = idWeterynarza;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.pensja = pensja;
    }

    // TODO metody dla klasy
    public int getIdWeterynarza() {
        return idWeterynarza;
    }

    public void setIdWeterynarza(int idWeterynarza) {
        this.idWeterynarza = idWeterynarza;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    @OneToMany(
            mappedBy = "weterynarz",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Wizyta> getWizytaLista() {
        return wizytaLista;
    }

    public void setWizytaLista(List<Wizyta> wizytaLista) {
        this.wizytaLista = wizytaLista;
    }

    // TODO kl. wewnętrzna Wykształcenie (kompozycja)

    // TODO dodajOsobe() met. klasowa
    @Override
    public Osoba dodajOsobe() {
        return null;
    }
}
