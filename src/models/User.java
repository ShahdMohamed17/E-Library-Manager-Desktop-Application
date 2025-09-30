package models;

public class User {
    private static int id_cnt=2;
    private int id;
    private String username;
    private String password;


    public User(String username, String password, int id) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public User() {
        this.id = 0;
        this.username = null;
        this.password = null;
    }

    public static int get_and_add_id_cnt(){
        id_cnt++;
        return id_cnt-1;
    }

    public int getID() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
