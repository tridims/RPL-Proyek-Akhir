package Model;

import java.util.ArrayList;
import java.util.List;

public class Bookmark {
    private List<CoworkingSpace> daftarCoworkingSpace;

    public Bookmark(List<CoworkingSpace> daftarCoworkingSpace) {
        this.daftarCoworkingSpace = daftarCoworkingSpace;
    }

    public List<CoworkingSpace> getListCoworkingSpace() {
        return daftarCoworkingSpace;
    }

    public boolean insert(CoworkingSpace cospace) {
        return daftarCoworkingSpace.add(cospace);
    }

    public boolean remove(CoworkingSpace cospace) {
        return daftarCoworkingSpace.remove(cospace);
    }
}
