import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity (name = "PracownikAdministracyjny")
public class PracownikAdministracyjny extends Osoba implements Serializable {
    // TODO atrybuty kl. PracownikAdministracyjny
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idPracownikaAdministracyjnego;
    private double pensja;
    private String pesel;
    private Date dataUrodzenia;

    // TODO ASOCJACJE
    @OneToMany
    private List<Wizyta> wizytLista = new ArrayList<>();

    // TODO konstruktor
    public PracownikAdministracyjny() {}

    public PracownikAdministracyjny(String imie, String nazwisko, int idPracownikaAdministracyjnego, double pensja, String pesel, Date dataUrodzenia) {
        super(imie, nazwisko);
        this.idPracownikaAdministracyjnego = idPracownikaAdministracyjnego;
        this.pensja = pensja;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }

    // TODO metody dla klasy
    public int getIdPracownikaAdministracyjnego() {
        return idPracownikaAdministracyjnego;
    }

    public void setIdPracownikaAdministracyjnego(int idPracownikaAdministracyjnego) {
        this.idPracownikaAdministracyjnego = idPracownikaAdministracyjnego;
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
            mappedBy = "pracownikAdministracyjny",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Wizyta> getWizytLista() {
        return wizytLista;
    }

    public void setWizytLista(List<Wizyta> wizytLista) {
        this.wizytLista = wizytLista;
    }

    @Override
    public Osoba dodajOsobe() {
        return null;
    }
}
