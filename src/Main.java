import Model.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User(new Bookmark(new ArrayList<>()));
        Owner owner = new Owner(new ArrayList<>());
        Catalog catalog = new Catalog(new ArrayList<>());

        // Use case pendataan coworking space
        CoworkingSpace cospace = new CoworkingSpace("cospace 1", "Outdoor, Indoor", "Jl Veteran, Malang", new ArrayList<>(), new HashMap<>(), new ArrayList<>());
        owner.registerCoworkingSpace(cospace);
        catalog.insertCoworkingSpace(cospace);

        Room room1 = new Room("Mewah SS", "Mewah banget", "Kamar mandi, Wifi, AC, Proyektor", new ArrayList<>());
        Room room2 = new Room("Mewah S", "Mewah aja", "Kamar mandi, Wifi, AC, Proyektor", new ArrayList<>());

        cospace.addRoom(room1);
        cospace.addRoom(room2);

        // Use case pencarian
        List<CoworkingSpace> hasilSearch = catalog.searchCoworkingSpace("cospace 1");
        for (CoworkingSpace c : hasilSearch) {
            System.out.println(c.getName());
        }

        List<CoworkingSpace> hasilRekomendasi = catalog.makeRecommendations(user);
        for (CoworkingSpace c : hasilRekomendasi) {
            System.out.println(c.getName());
        }

        // Use case bookmark

        // Use case reservasi

        // Use case menambahkan review

    }
}