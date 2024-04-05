import list.ProductList;
import list.UserList;
import model.User;

public class Main {
    public static void main(String[] args) {

        /* Ayudantia Martes
        User user = new User("Marcelo", "Cespedes", "20723668-3");

        UserList userList = new UserList(150);

        userList.addUser(user);

        // Aquí realizo un print
        System.out.println(userList.getUser("20723668-3"));
         */

        ProductList productList = new ProductList(150);

        System.out.println(productList.addProduct(780282044, "Botella de Agua", 3));

        System.out.println(productList.addProduct(780282044, "Botella de Agua", 3));


    }
}