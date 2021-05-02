import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        StandardServiceRegistry registry = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure() // configures settings from hibernate.cfg.xml
                    .build();

            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Main main = new Main();

            // Do something within the session, e.g. create/retrieve objects, // etc.

            // utworzenie rekordu Zwierze
           /* Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse("20-04-2018");
            Integer zwierze1 = main.dodajZwierze(1, "Kluska", date1, "k", 4, 1);*/

            // wyswietl liste zwierzat - test
            Zwierze zwierze = new Zwierze();
            //main.wyswietlListeZwierzat();
            zwierze.wyswietlListeZwierzat(sessionFactory);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public List<Zwierze> wyswietlListeZwierzat() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Zwierze> lz = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List listaZwierzat = session.createQuery("FROM Zwierze").list();
            for (Iterator iterator = listaZwierzat.iterator(); iterator.hasNext(); ) {
                Zwierze zwierze = (Zwierze) iterator.next();
                lz.add(zwierze);
                System.out.print("Imie: " + zwierze.getImie()); //TODO do wywalenia1
                System.out.print("  Płeć: " + zwierze.getPlec()); //TODO do wywalenia2
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }
        return lz;
    }

    //TODO metoda zwracająca listę chorób otrzymująca jako argument idZwierzęcia
}