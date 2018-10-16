import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    /*Aqui faz-se o registo*/

    ArrayList<User> userList = new ArrayList<User>();
    User activeUser;

    public static void main(String[] args) {
        Main main = new Main();

        main.userLogin(true);
        main.userLogin(false);
    }

    void userLogin(boolean newAccount) {
        String user = "";
        String pass = "";
        boolean registrySuccess = false;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (!registrySuccess) {
            try {
                System.out.println("Nome de Utilizador: ");
                user = reader.readLine();
                System.out.println("Password: ");
                pass = reader.readLine();

                registrySuccess = true;

            } catch (Exception e) {
                if (newAccount) {
                    System.out.println("Erro ao registar a conta. Tente outra vez..");
                }
            }
        }
        if (newAccount) {
            User newUser = new User(user, pass);
            System.out.println("New account created!");

            userList.add(newUser);
        } else {
            User oldUser = findUser(user, pass);
            if (oldUser != null) {
                activeUser = oldUser;
                System.out.println("Welcome to DropMusic " + user + "!");
            }
        }

    }

    User findUser(String name, String pass) {
        User match = null;
        for (User element : userList) {
            if (name.equals(element.getName()) && pass.equals(element.getPassword())) {
                match = element;
            }
        }
        if (match == null) {
            System.out.println("No user found.");
        }
        return match;

    }
}