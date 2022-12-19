import Model.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("user 1", "password", "email", "address", "phone number", new Bookmark(new ArrayList<>()));
        Owner owner = new Owner("Owner 1", "password", "email", "address", "phone number", new ArrayList<>());
        Catalog catalog = new Catalog(new ArrayList<>());

        // =========== USE CASE PENDATAAN COWORKING SPACE ===========
        CoworkingSpace cospace = new CoworkingSpace("cospace 1", "Outdoor, Indoor", "Jl Veteran, Malang", new ArrayList<>(), new HashMap<>(), new ArrayList<>());
        owner.registerCoworkingSpace(cospace);
        catalog.insertCoworkingSpace(cospace);

        Room room1 = new Room("Mewah SS", "Mewah banget", "Kamar mandi, Wifi, AC, Proyektor", new ArrayList<>());
        Room room2 = new Room("Mewah S", "Mewah aja", "Kamar mandi, Wifi, AC, Proyektor", new ArrayList<>());

        cospace.addRoom(room1);
        cospace.addRoom(room2);

        System.out.println("HASIL PENDATAAN : ");
        for (CoworkingSpace space : catalog.getListCoworkingSpace()) {
            System.out.println("Coworking Space : " + space.getName());
            System.out.println("Alamat : " + space.getAddress());
            System.out.println("Daftar Ruangan : ");
            for (Room room : space.getListRoom()) {
                System.out.println(" " + room.getName() + " " + room.getDescription() + " " + room.getFacility());
            }
        }
        System.out.println("END PENDATAAN\n");

        // =========== USE CASE PENCARIAN ===========
        System.out.println("USE CASE PENCARIAN");
        List<CoworkingSpace> hasilSearch = catalog.searchCoworkingSpace("cospace 1");
        System.out.println("Hasil Pencarian : ");
        for (CoworkingSpace c : hasilSearch) {
            System.out.println(" " + c.getId() + " " + c.getName() + " " + c.getAddress());
        }

        System.out.println("\nHasil Rekomendasi : ");
        List<CoworkingSpace> hasilRekomendasi = catalog.makeRecommendations(user);
        for (CoworkingSpace c : hasilRekomendasi) {
            System.out.println(" " + c.getId() + " " + c.getName() + " " + c.getAddress());
        }

        System.out.println("END PENCARIAN\n");

        // =========== USE CASE BOOKMARK ===========
        System.out.println("USE CASE BOOKMARK");
        List<CoworkingSpace> daftar = catalog.getListCoworkingSpace();
        CoworkingSpace selected = daftar.get(0);

        user.addToBookmark(selected);
        List<CoworkingSpace> daftarBookmark = user.getListBookmarked();
        System.out.println("Hasil Add Bookmark : ");
        for (CoworkingSpace c : daftarBookmark) {
            System.out.println(c.getName());
        }

        user.removeFromBookmark(selected);
        daftarBookmark = user.getListBookmarked();
        System.out.println("Hasil Remove Bookmark : ");
        for (CoworkingSpace c : daftarBookmark) {
            System.out.println(c.getName());
        }

        System.out.println("END BOOKMARK\n");

        // =========== USE CASE RESERVASI TEMPAT ===========
        System.out.println("USE CASE RESERVASI TEMPAT");

        // user membuat reservasi
        CoworkingSpace selectedCoworkingSpace = catalog.getListCoworkingSpace().get(0);
        Room selectedRoom = selectedCoworkingSpace.getListRoom().get(0);
        selectedCoworkingSpace.makeReservation(user, selectedRoom, new Date(), 5, "Reservasi untuk 10 Orang ya");

        // owner melihat permintaan reservasi dan menerima permintaan reservasi
        List<Reservation> daftarReservasi = selectedCoworkingSpace.getListReservation();
        System.out.println("Daftar Reservasi : ");
        for (Reservation reservation: daftarReservasi) {
            System.out.println("Nama User : " + reservation.getUser().getName());
            System.out.println("Durasi : " + reservation.getDuration());
            System.out.println("Note : " + reservation.getNote());
            System.out.println("Status Reservasi : " + reservation.getStatus());
        }

        Reservation selectedReservation = daftarReservasi.get(0);
        selectedReservation.setStatus(ReservationStatus.ACCEPTED);
        System.out.println("\nDaftar Reservasi Setelah Diterima : ");
        for (Reservation reservation: daftarReservasi) {
            System.out.println("Nama User : " + reservation.getUser().getName());
            System.out.println("Durasi : " + reservation.getDuration());
            System.out.println("Note : " + reservation.getNote());
            System.out.println("Status Reservasi : " + reservation.getStatus());
        }

        System.out.println("END RESERVASI TEMPAT\n");

        // =========== USE CASE REVIEW ===========
        System.out.println("USE CASE REVIEW");
        user.makeReview(selectedCoworkingSpace, 5, "Bagus banget");
        List<Review> daftarReview = selectedCoworkingSpace.getListUserReviews();
        System.out.println("Daftar Review : ");
        for (Review review: daftarReview) {
            System.out.println("Score : " + review.getScore());
            System.out.println("Komentar : " + review.getReview());
        }
        System.out.println("END");
    }
}