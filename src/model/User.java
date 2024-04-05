package model;

public class User {

    private String firstName;
    private String lastName;
    private String rut;
    private String membership;

    public User(String firstName, String lastName, String rut) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rut = rut;
        this.membership = "NORMAL";
    }

    public User(String firstName, String lastName, String rut, String membership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rut = rut;
        this.membership = membership;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String toString(){
        return "Nombre: " + this.firstName +
                "\nApellido: " + this.lastName +
                "\nRUT: " + this.rut +
                "\nMembresía: " + this.membership;
    }
}
