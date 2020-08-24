import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity (name = "WlascicielZwierzecia")
public class WlascicielZwierzecia extends Osoba implements Serializable {
    // TODO atrybuty kl. WlascicielZwierzecia
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy= "increment")
    private int idWlasciciela;
    //private List<Zwierze> zwierzeta = new ArrayList<>();

    // TODO ASOCJACJE
    @OneToMany
    private List<Zwierze> zwierzeLista = new ArrayList<>();

    //TODO konstruktor
    public WlascicielZwierzecia() {}

    public WlascicielZwierzecia(String imie, String nazwisko, int idWlasciciela) {
        super(imie, nazwisko);
        this.idWlasciciela = idWlasciciela;
    }

    // TODO metody
    public int getIdWlasciciela() {
        return idWlasciciela;
    }

    public void setIdWlasciciela(int idWlasciciela) {
        this.idWlasciciela = idWlasciciela;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<Zwierze> getZwierzeLista() {
        return zwierzeLista;
    }

    public void setZwierzeLista(List<Zwierze> zwierzeLista) {
        this.zwierzeLista = zwierzeLista;
    }

    // TODO przypiszZwierze(ID zwierzecia)
    // TODO dodajOsobe() -> add/create met. klasowa
    @Override
    public Osoba dodajOsobe() {
        return null;
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(idWlasciciela);
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass() ) {
            return false;
        }
        WlascicielZwierzecia wlascicielZwierzecia = (WlascicielZwierzecia) obj;
        return Objects.equals( idWlasciciela, wlascicielZwierzecia.idWlasciciela );
    }*/
}
