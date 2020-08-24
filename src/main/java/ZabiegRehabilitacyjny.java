import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name = "ZabiegRehabilitacyjny")
public class ZabiegRehabilitacyjny {
    // TODO atrybuty kl. ZabiegRehabilitacyjny
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idZabiegu;
    private String nazwa;
    private static int minimalnaIloscPowtorzen; // = 2
    private double koszt;

    // TODO asocjacje
    @ManyToOne
    private Wizyta wizyta;

    // TODO konstruktor
    public ZabiegRehabilitacyjny() {
    }

    public ZabiegRehabilitacyjny(int idZabiegu, String nazwa, double koszt) {
        this.idZabiegu = idZabiegu;
        this.nazwa = nazwa;
        this.koszt = koszt;
    }

    // TODO metody
    public int getIdZabiegu() {
        return idZabiegu;
    }

    public void setIdZabiegu(int idZabiegu) {
        this.idZabiegu = idZabiegu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public static int getMinimalnaIloscPowtorzen() {
        return minimalnaIloscPowtorzen;
    }

    public static void setMinimalnaIloscPowtorzen(int minimalnaIloscPowtorzen) {
        ZabiegRehabilitacyjny.minimalnaIloscPowtorzen = minimalnaIloscPowtorzen;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    @ManyToOne
    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }
}
