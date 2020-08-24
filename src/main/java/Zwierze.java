import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity (name = "Zwierze")
public class Zwierze {
    // TODO atrybuty kl. Zwierze
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idZwierzecia;
    private String imie;
    private Date dataUrodzenia;
    private String plec;
    private double wysokosc;
    private double waga;

    // TODO ASOCJACJE
    @ManyToMany
    private List<Wizyta> wizytaLista = new ArrayList<>();

    @ManyToOne
    private WlascicielZwierzecia wlascicielZwierzecia;

    @ManyToMany
    private List<Choroba> chorobaLista = new ArrayList<>();

    // do przechowywania kompozycji - HistoriaLeczenia
    @OneToOne(cascade = CascadeType.ALL)
    private HistoriaLeczenia historiaLeczenia;

    // TODO konstruktor
    public Zwierze(int idZwierzecia, String imie, Date dataUrodzenia, String plec, double wysokosc, double waga) {
        this.idZwierzecia = idZwierzecia;
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        this.wysokosc = wysokosc;
        this.waga = waga;
    }

    public Zwierze() {}

    // TODO metody
    public int getIdZwierzecia() {
        return idZwierzecia;
    }

    public void setIdZwierzecia(int idZwierzecia) {
        this.idZwierzecia = idZwierzecia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    @ManyToMany(cascade= CascadeType.ALL)
    public List<Wizyta> getWizytaLista() {
        return wizytaLista;
    }

    public void setWizytaLista(List<Wizyta> wizytaLista) {
        this.wizytaLista = wizytaLista;
    }

    @ManyToOne
    public WlascicielZwierzecia getWlascicielZwierzecia() {
        return wlascicielZwierzecia;
    }

    public void setWlascicielZwierzecia(WlascicielZwierzecia wlascicielZwierzecia) {
        this.wlascicielZwierzecia = wlascicielZwierzecia;
    }

    @ManyToMany
    public List<Choroba> getChorobaLista() {
        return chorobaLista;
    }

    public void setChorobaLista(List<Choroba> chorobaLista) {
        this.chorobaLista = chorobaLista;
    }

    public HistoriaLeczenia getHistoriaLeczenia() {
        return historiaLeczenia;
    }

    public void setHistoriaLeczenia(HistoriaLeczenia historiaLeczenia) {
        this.historiaLeczenia = historiaLeczenia;
    }

    // TODO wyswietlListeZwierzat()
    /*public static List<Zwierze> wyswietlListeZwierzat() {
        for (Zwierze z : ) {

        }
    }*/

    // TODO wyswietlChoroby(ID zwierzecia)

    // TODO dodajZwierze() -> klasowa
    // TODO wyswietlChoroby()
    // TODO przypiszChorobe(ID choroby)

    // TODO KLASA WEW. HistoriaLeczenia
    @Entity (name = "HistoriaLeczenia")
    private class HistoriaLeczenia {
        // TODO atrybuty
        @Id
        int idHistoriaLeczenia;
        Date dataRozpoczecia;
        @OneToOne
        Weterynarz weterynarzProwadzacy;

        //TODO konstruktor
        public HistoriaLeczenia() {
        }

        public HistoriaLeczenia(Date dataRozpoczecia, Weterynarz weterynarzProwadzacy) {
            this.dataRozpoczecia = dataRozpoczecia;
            this.weterynarzProwadzacy = weterynarzProwadzacy;
        }

        // TODO metody
        public int getIdHistoriaLeczenia() {
            return idHistoriaLeczenia;
        }

        public void setIdHistoriaLeczenia(int idHistoriaLeczenia) {
            this.idHistoriaLeczenia = idHistoriaLeczenia;
        }

        public Date getDataRozpoczecia() {
            return dataRozpoczecia;
        }

        public void setDataRozpoczecia(Date dataRozpoczecia) {
            this.dataRozpoczecia = dataRozpoczecia;
        }

        public Weterynarz getWeterynarzProwadzacy() {
            return weterynarzProwadzacy;
        }

        public void setWeterynarzProwadzacy(Weterynarz weterynarzProwadzacy) {
            this.weterynarzProwadzacy = weterynarzProwadzacy;
        }

        // TODO przypiszWeterynarza()
        // public void przypiszWeterynarza(idWeterynarza)
    }
}
