package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Catalog {
    private ArrayList<CoworkingSpace> listCoworkingSpace;

    public Catalog(ArrayList<CoworkingSpace> listCoworkingSpace) {
        this.listCoworkingSpace = listCoworkingSpace;
    }
    public boolean insertCoworkingSpace(CoworkingSpace coworking) {
        // check if coworking space already exist
        for (CoworkingSpace c : listCoworkingSpace) {
            if (c.getId().equals(coworking.getId())) {
                return false;
            }
        }

        return listCoworkingSpace.add(coworking);
    }

    public boolean removeCoworkingSpace(CoworkingSpace coworking) {
        return listCoworkingSpace.remove(coworking);
    }

    public List<CoworkingSpace> getListCoworkingSpace() {
        return this.listCoworkingSpace;
    }

    public List<CoworkingSpace> getSortedBy(String text) {
        List<CoworkingSpace> sortedList = new ArrayList<CoworkingSpace>(listCoworkingSpace);

        switch (text) {
            case "name" -> sortedList.sort(Comparator.comparing(CoworkingSpace::getName));
            case "rating" -> sortedList.sort((o1, o2) -> Float.compare(o2.calculateRating(), o1.calculateRating()));
            default -> {
            }
        }

        return sortedList;
    }

    public List<CoworkingSpace> searchCoworkingSpace(String query) {
        List<CoworkingSpace> result = new ArrayList<CoworkingSpace>();

        for (CoworkingSpace c : listCoworkingSpace) {
            if (c.getName().contains(query) || c.getCategory().contains(query) || c.getAddress().contains(query)) {
                result.add(c);
            }
        }

        return result;
    }

    public List<String> getCategories() {
        ArrayList<String> listCategories = new ArrayList<>();

        for (CoworkingSpace c : listCoworkingSpace) {
            if (!listCategories.contains(c.getCategory())) {
                listCategories.add(c.getCategory());
            }
        }

        return listCategories;
    }

    public List<CoworkingSpace> makeRecommendations(User user) {
        return this.listCoworkingSpace;
    }
}
