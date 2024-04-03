import list.UserList;
import model.User;

public class Main {
    public static void main(String[] args) {

        User user = new User("Marcelo", "Cespedes", "20723668-3");

        UserList userList = new UserList(150);

        userList.addUser(user);

        // Aquí realizo un print
        System.out.println(userList.getUser("20723668-3"));


    }
}