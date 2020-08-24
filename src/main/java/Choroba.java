import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity (name = "Choroba")
public class Choroba {
    // TODO atrybuty kl. Choroba
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idChoroby;
    private String nazwa;
    private Date dataDiagnozy;

    // TODO asocjacje
    @ManyToMany
    private List<Zwierze> zwierzeLista = new ArrayList<>();

    // TODO konstruktor
    public Choroba() {
    }

    public Choroba(int idChoroby, String nazwa, Date dataDiagnozy) {
        this.idChoroby = idChoroby;
        this.nazwa = nazwa;
        this.dataDiagnozy = dataDiagnozy;
    }

    // TODO metody

    public int getIdChoroby() {
        return idChoroby;
    }

    public void setIdChoroby(int idChoroby) {
        this.idChoroby = idChoroby;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataDiagnozy() {
        return dataDiagnozy;
    }

    public void setDataDiagnozy(Date dataDiagnozy) {
        this.dataDiagnozy = dataDiagnozy;
    }

    @ManyToMany
    public List<Zwierze> getZwierzeLista() {
        return zwierzeLista;
    }

    public void setZwierzeLista(List<Zwierze> zwierzeLista) {
        this.zwierzeLista = zwierzeLista;
    }

    // TODO wyswietlSzczegolyChoroby(ID choroby)
    /*public Choroba wyswietlSzczegolyChoroby(int idChoroby) {

    }*/

    // TODO dodajChorobe() met. klasowa

}
