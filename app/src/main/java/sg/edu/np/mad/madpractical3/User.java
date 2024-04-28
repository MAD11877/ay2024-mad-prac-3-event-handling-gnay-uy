package sg.edu.np.mad.madpractical3;
public class User {
    String name;
    String description;
    int id;
    boolean followed;

    public User() {
        name = "default";
        description = "default";
        id = 0;
        followed = false;
    }

    public User(String n, String d, int i, boolean f) {
        name = n;
        description = d;
        id = i;
        followed = f;
    }
}