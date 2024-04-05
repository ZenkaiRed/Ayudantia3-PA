package list;

import model.User;

public class UserList {

    // Una variable final significa que nunca sufrirá cambios.
    private final User[] users;
    private final int maxQuantity;
    private int quantity;

    /**
     * Constructor de la clase UserList.
     * @param maxQuantity Corresponde a la capacidad máxima que tendrá la lista.
     */
    public UserList(int maxQuantity) {

        if (maxQuantity < 0){
            throw new IllegalArgumentException("Valor para la lista inválido.");
        }

        this.maxQuantity = maxQuantity;
        this.users = new User[this.maxQuantity];
        this.quantity = 0;
    }

    /**
     * Método que permite agregar un usuario a la lista.
     * @param user Usuario a agregar.
     * @return Retorna un booleano que indica si se pudo agregar el usuario o no.
     */
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

    /**
     * Método que permite agregar un usuario a la lista.
     * @param firstName Nombre del usuario.
     * @param lastName Apellido del usuario.
     * @param rut Rut del usuario.
     * @param membership Membresía del usuario.
     * @return Retorna un booleano que indica si se pudo agregar el usuario o no.
     */
    public boolean addUser(String firstName, String lastName, String rut, String membership){
        User user = new User(firstName, lastName, rut, membership);
        return this.addUser(user);
    }

    /**
     * Método que permite buscar un usuario en la lista.
     * @param rut Rut del usuario a buscar.
     * @return Retorna la posición del usuario en la lista.
     */
    public int searchUser(String rut){

        for (int i = 0; i < this.quantity; i++) {
            if (this.users[i].getRut().equals(rut)){
                return i;
            }
        }

        return -1;
    }

    /**
     * Método que permite obtener los datos de un usuario en la lista.
     * @param rut Rut del usuario.
     * @return Retorna los datos del usuario.
     */
    public String getUser(String rut){

        int position = this.searchUser(rut);

        if (position == -1){
            return null;
        }

        User user = this.users[position];

        return user.toString();
    }

    /**
     * Método que permite obtener los datos de un usuario en la lista.
     * @param position Posición del usuario en la lista.
     * @return Retorna los datos del usuario.
     */
    public String getUser(int position){
        if (position < 0 || position >= this.quantity){
            return null;
        }

        User user = this.users[position];
        return user.toString();
    }

    /**
     * Método que permite eliminar un usuario de la lista.
     * @param rut Rut del usuario.
     * @return Retorna un booleano que indica si se pudo eliminar el usuario o no.
     */
    public boolean deleteUser(String rut){
        int position = this.searchUser(rut);
        if (position == -1){
            return false;
        }

        for (int i = position; i < this.quantity - 1; i++) {
            this.users[i] = this.users[i + 1];
        }

        this.quantity--;
        return true;
    }

    /**
     * Método que permite eliminar un usuario de la lista.
     * @param position Posición del usuario en la lista.
     * @return Retorna un booleano que indica si se pudo eliminar el usuario o no.
     */
    public boolean deleteUser(int position) {
        if (position < 0 || position >= this.quantity) {
            return false;
        }

        for (int i = position; i < this.quantity - 1; i++) {
            this.users[i] = this.users[i + 1];
        }

        this.quantity--;
        return true;
    }

    /**
     * Método que permite obtener los datos de todos los usuarios en la lista.
     * @return Retorna un arreglo de String con los datos de los usuarios.
     */
    public String[] getUsersAlphabetically(){
        User[] users = new User[this.quantity];

        // Copia los usuarios originales al nuevo arreglo.
        for (int i = 0; i < this.quantity; i++) {
            users[i] = this.users[i];
        }

        /*
            Se puede hacer de esta forma también:
            System.arraycopy(this.users, 0, users, 0, this.quantity);
         */

        // Ordena los usuarios en orden alfabético según su nombre.
        for (int i = 0; i < this.quantity - 1; i++) {
            // Segundo ciclo para comparar los nombres de los usuarios.
            for (int j = 0; j < this.quantity - i - 1; j++) {
                if (users[j].getFirstName().compareTo(users[j + 1].getFirstName()) > 0) {
                    // Intercambia los usuarios
                    User temp = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = temp;
                }
            }
        }

        // Crea un arreglo de String con los datos de los usuarios ordenados alfabéticamente.
        String[] userNames = new String[this.quantity];
        for (int i = 0; i < this.quantity; i++) {
            userNames[i] = users[i].toString();
        }

        return userNames;
    }


    /**
     * Método que permite obtener la cantidad de usuarios en la lista.
     * @return Retorna la cantidad de usuarios en la lista.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Método que permite establecer la cantidad de usuarios en la lista.
     * @param quantity Cantidad de usuarios en la lista.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
