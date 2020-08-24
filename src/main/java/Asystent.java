import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity (name = "Asystent")
public class Asystent extends Osoba implements Serializable {
    // TODO atrybuty kl. Asystent
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idAsystenta;
    private Date dataRozpoczeciaPraktyk;
    private double pensja;
    private String pesel;
    private Date dataUrodzenia;

    // TODO ASOCJACJE
    @OneToMany
    private List<Wizyta> wizytaLista = new ArrayList<>();

    //TODO konstruktor
    public Asystent () {}

    public Asystent(String imie, String nazwisko, int idAsystenta, Date dataRozpoczeciaPraktyk, double pensja, String pesel, Date dataUrodzenia) {
        super(imie, nazwisko);
        this.idAsystenta = idAsystenta;
        this.dataRozpoczeciaPraktyk = dataRozpoczeciaPraktyk;
        this.pensja = pensja;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }

    public int getIdAsystenta() {
        return idAsystenta;
    }

    public void setIdAsystenta(int idAsystenta) {
        this.idAsystenta = idAsystenta;
    }

    public Date getDataRozpoczeciaPraktyk() {
        return dataRozpoczeciaPraktyk;
    }

    public void setDataRozpoczeciaPraktyk(Date dataRozpoczeciaPraktyk) {
        this.dataRozpoczeciaPraktyk = dataRozpoczeciaPraktyk;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
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

    @OneToMany(
            mappedBy = "asystent",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Wizyta> getWizytaLista() {
        return wizytaLista;
    }

    public void setWizytaLista(List<Wizyta> wizytaLista) {
        this.wizytaLista = wizytaLista;
    }

    // TODO dodajOsobe() met. klasowa
    @Override
    public Osoba dodajOsobe() {
        return null;
    }
}
