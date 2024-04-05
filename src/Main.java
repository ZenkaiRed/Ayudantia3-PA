import list.ProductList;
import list.UserList;
import model.Product;
import model.User;

public class Main {
    public static void main(String[] args) {

        // Crear usuarios.
        User user1 = new User("Marcelo", "Cespedes", "11111111-1");
        User user2 = new User("Jorge", "Rivera", "22222222-2", "PREMIUM");
        User user4 = new User("Jose", "Alcayaga", "44444444-4");

        // Crear productos.
        Product product1 = new Product(780282044, "Botella de Agua", 3);
        Product product2 = new Product(184622123, "Bolsa 1KG de Papas", 9);
        Product product4 = new Product(583295233, "Especias de arabia", 29);

        // Crear lista de usuarios y agregar usuarios.
        UserList userList = new UserList(100);
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser("David", "Araya", "33333333-3", "PREMIUM");
        userList.addUser(user4);


        // Crear lista de productos y agregar productos.
        ProductList productList = new ProductList(150);
        productList.addProduct(product1);
        productList.addProduct(product2);
        productList.addProduct(129385698, "Horno Microondas", 10);
        productList.addProduct(product4);

        // Imprimir lista de usuarios de manera alfabética.
        System.out.println("Lista de usuarios:");
        for (String user : userList.getUsersAlphabetically()) {
            System.out.println(user);
            System.out.println("\n");
        }

        // Imprimir lista de productos de manera descendente.
        System.out.println("Lista de productos:");
        for (String product : productList.getProductsDescendent()) {
            System.out.println(product);
            System.out.println("\n");
        }

        // Eliminar usuario.
        userList.deleteUser("33333333-3");

        // Eliminar producto.
        productList.deleteProduct(583295233);

        // Imprimir lista de usuarios de manera alfabética.
        System.out.println("Lista de usuarios:");
        for (String user : userList.getUsersAlphabetically()) {
            System.out.println(user);
            System.out.println("\n");
        }

        // Imprimir lista de productos de manera descendente.
        System.out.println("Lista de productos:");
        for (String product : productList.getProductsDescendent()) {
            System.out.println(product);
            System.out.println("\n");
        }


    }
}