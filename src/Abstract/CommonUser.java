package Abstract;

import java.util.UUID;

public abstract class CommonUser {
    private String id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;

    public CommonUser(String name, String password, String email, String address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public boolean login(String email, String password) {
        return email.equals(this.email) && password.equals(this.password);
    }

    abstract public boolean logout();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
