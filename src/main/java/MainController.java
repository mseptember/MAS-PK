import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")
public class MainController {
    //tu pojda rest endpointy do get, delete, post, put
    //przykladowe uzycie

    @Path("/dodaj")
    @POST
    public Osoba dodajOsobe(Osoba osoba) {
        return osoba.dodajOsobe();
    }
}
