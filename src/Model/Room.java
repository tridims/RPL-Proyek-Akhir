package Model;

public class Room {
    private String name;
    private String description;
    private String facility;

    public boolean updateData(String name, String description, String facility) {
        this.name = name;
        this.description = description;
        this.facility = facility;
        return true;
    }
}
