package list;

import model.Membership;
import model.User;

public class UserList {

    private User[] users;
    private int maxQuantity;
    private int quantity;

    public UserList(int maxQuantity) {

        if (maxQuantity < 0){
            throw new IllegalArgumentException("Valor para la lista inválido.");
        }

        this.maxQuantity = maxQuantity;
        this.users = new User[this.maxQuantity];
        this.quantity = 0;
    }

    public boolean addUser(User user) {

        if (this.quantity >= this.maxQuantity) {
            throw new IllegalArgumentException("El arreglo o lista está lleno.");
        }

        if (this.quantity == 0) {
            this.users[this.quantity] = user;
            this.quantity++;
            return true;
        }

        if (this.searchUser(user.getRut()) != -1){
            return false;
        }

        this.users[this.quantity] = user;
        this.quantity++;

        return true;
    }

    public boolean addUser(String firstName, String lastName, String rut, Membership membership){
        User user = new User(firstName, lastName, rut, membership);
        return this.addUser(user);
    }

    public int searchUser(String rut){

        for (int i = 0; i < this.quantity; i++) {
            if (this.users[i].getRut().equals(rut)){
                return i;
            }
        }

        return -1;
    }

    public String getUser(String rut){

        int position = this.searchUser(rut);

        if (position == -1){
            return null;
        }

        User user = this.users[position];

        String data = "Nombre: " + user.getFirstName() +
                "\nApellido: " + user.getLastName() +
                "\nRUT: " + user.getRut() +
                "\nMembresía: " + user.getMembership().name();

        return data;
    }


    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
