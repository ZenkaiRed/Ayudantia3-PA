package model;

public class User {

    private String firstName;
    private String lastName;
    private String rut;
    private Membership membership;

    public User(String firstName, String lastName, String rut) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rut = rut;
        this.membership = Membership.NORMAL;
    }

    public User(String firstName, String lastName, String rut, Membership membership) {
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

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public String toString(){
        return this.rut;
    }
}
