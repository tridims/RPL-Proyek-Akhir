package Model;

import Abstract.CommonUser;

import java.util.ArrayList;
import java.util.List;

public class Owner extends CommonUser {
    private ArrayList<CoworkingSpace> coworkingPlaces;

    public Owner(ArrayList<CoworkingSpace> coworkingPlaces){
        this.coworkingPlaces = coworkingPlaces;
    }

    @Override
    public boolean logout() {
        return true;
    }

    public List<CoworkingSpace> getCoworkingSpaces() {
        return this.coworkingPlaces;
    }

    public boolean registerCoworkingSpace(CoworkingSpace coworkingSpace) {
        try {
            coworkingPlaces.add(coworkingSpace);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
