
import java.util.ArrayList;


public class Avlastningsstation {

    ArrayList<Lastbil> dockadeLastbilar = new ArrayList<>();

    public void visaDockadeLastbilar() {
        System.out.println("\nDockade lastbilar:");
        for (Lastbil lastbil : dockadeLastbilar) {
            System.out.println("Typ: " + lastbil.typ + ", Vikt: " + lastbil.vikt + " ton");
        }
    }

    public void registreraLastbil(String typ, double vikt) {
        String kajplats = bestamKajplats(typ, vikt);
        if (kajplats != null) {
            Lastbil lastbil = new Lastbil(typ, vikt);
            dockadeLastbilar.add(lastbil);
            System.out.println("Lastbil registrerad framgångsrikt på kajplats " + kajplats);
        } else {
            System.out.println("Ingen tillgänglig kajplats för den angivna lastbilen.");
        }
    }


    private String bestamKajplats(String typ, double vikt) {
        if (typ.equals("Skåpbil") && vikt > 0) {
            // Skåpbilar används typiskt på kaj A och B
            return (vikt <= 5) ? "A" : "B";
        } else if (typ.equals("Lätt lastbil")) {
            // Lätta lastbilar används på kaj C och D, samt A om vikten är under 5 ton
            return (vikt <= 5) ? "A" : ((vikt <= 5) ? "C" : "D");
        } else if (typ.equals("Tung lastbil")) {
            // Tunga lastbilar används på kaj E, samt D om vikten är under 9 ton
            return (vikt <= 9) ? "D" : "E";
        } else {
            return null; // Åtgärda om andra typer stöds i framtiden
        }
    }

}

