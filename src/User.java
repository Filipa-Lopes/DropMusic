import java.util.ArrayList;

public class User {
    private String name;
    private String password;

    private ArrayList<Playlist> musicLists;

    public User(String name, String pass) {
        this.name = name;
        this.password = pass;
        //iniciar RMI Client
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Playlist> getMusicLists() {
        return musicLists;
    }
}
