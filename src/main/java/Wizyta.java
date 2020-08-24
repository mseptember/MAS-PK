import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity (name = "Wizyta")
public class Wizyta {
    // TODO atrybuty kl. Wizyta
    @Id
    @GeneratedValue (generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idWizyty;
    private Date dataWizyty;
    private String status; // z określonej listy ze statusami
    private double kosztWizyty; // atrybut wyliczany za pomocą metody

    // TODO asocjacje
    @ManyToOne
    private PracownikAdministracyjny pracownikAdministracyjny;

    @ManyToOne
    private Weterynarz weterynarz;

    @ManyToOne
    private Asystent asystent;

    @OneToMany
    private List<ZabiegRehabilitacyjny> zabiegRehabilitacyjnyLista;

    @OneToMany
    private List<Badanie> badanieLista;

    @ManyToMany
    private List<Lek> lekLista = new ArrayList<>();

    @ManyToMany
    private List<Zwierze> zwierzeLista = new ArrayList<>();

    // do przechowywania kompozycji - Notatka
    @OneToOne(cascade = CascadeType.ALL)
    private Notatka notatka;

    // TODO konstruktor
    public Wizyta(int idWizyty, Date dataWizyty, String status, double kosztWizyty) {
        this.idWizyty = idWizyty;
        this.dataWizyty = dataWizyty;
        this.status = status;
        this.kosztWizyty = kosztWizyty;
    }

    public Wizyta () {}

    // TODO metody

    public int getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(int idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Date getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(Date dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getKosztWizyty() {
        return kosztWizyty;
    }

    public void setKosztWizyty(double kosztWizyty) {
        this.kosztWizyty = kosztWizyty;
    }

    @ManyToOne
    public PracownikAdministracyjny getPracownikAdministracyjny() {
        return pracownikAdministracyjny;
    }

    public void setPracownikAdministracyjny(PracownikAdministracyjny pracownikAdministracyjny) {
        this.pracownikAdministracyjny = pracownikAdministracyjny;
    }

    @ManyToOne
    public Weterynarz getWeterynarz() {
        return weterynarz;
    }

    public void setWeterynarz(Weterynarz weterynarz) {
        this.weterynarz = weterynarz;
    }

    @ManyToOne
    public Asystent getAsystent() {
        return asystent;
    }

    public void setAsystent(Asystent asystent) {
        this.asystent = asystent;
    }

    @OneToMany(
            mappedBy = "wizyta",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<ZabiegRehabilitacyjny> getZabiegRehabilitacyjnyLista() {
        return zabiegRehabilitacyjnyLista;
    }

    public void setZabiegRehabilitacyjnyLista(List<ZabiegRehabilitacyjny> zabiegRehabilitacyjnyLista) {
        this.zabiegRehabilitacyjnyLista = zabiegRehabilitacyjnyLista;
    }

    @OneToMany(
            mappedBy = "wizyta",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Badanie> getBadanieLista() {
        return badanieLista;
    }

    public void setBadanieLista(List<Badanie> badanieLista) {
        this.badanieLista = badanieLista;
    }

    @ManyToMany
    public List<Lek> getLekLista() {
        return lekLista;
    }

    public void setLekLista(List<Lek> lekLista) {
        this.lekLista = lekLista;
    }

    @ManyToMany(cascade= CascadeType.ALL)
    public List<Zwierze> getZwierzeLista() {
        return zwierzeLista;
    }

    public void setZwierzeLista(List<Zwierze> zwierzeLista) {
        this.zwierzeLista = zwierzeLista;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }

    // TODO umowWizyte() -> met. klasowa

    // TODO przypiszBadanie(ID badania) ?

    // TODO przypiszZabieg(ID zabiegu) ?

    // TODO przypiszLek(ID leku) ?

    // TODO obliczKoszt()

    // TODO KLASA WEW. Notatka
    @Entity (name = "Notatka")
    private class Notatka {
        // TODO atrybuty
        @Id
        int idNotatki;
        Date dataSporzadzenia;
        String tresc;

        // TODO konstruktor
        public Notatka() {
        }

        public Notatka(int idNotatki, Date dataSporzadzenia, String tresc) {
            this.idNotatki = idNotatki;
            this.dataSporzadzenia = dataSporzadzenia;
            this.tresc = tresc;
        }

        // TODO metody
        public int getIdNotatki() {
            return idNotatki;
        }

        public void setIdNotatki(int idNotatki) {
            this.idNotatki = idNotatki;
        }

        public Date getDataSporzadzenia() {
            return dataSporzadzenia;
        }

        public void setDataSporzadzenia(Date dataSporzadzenia) {
            this.dataSporzadzenia = dataSporzadzenia;
        }

        public String getTresc() {
            return tresc;
        }

        public void setTresc(String tresc) {
            this.tresc = tresc;
        }

        // TODO dodajNotatke()
        //public void dodajNotatke(int idWizyty)
    }
}
