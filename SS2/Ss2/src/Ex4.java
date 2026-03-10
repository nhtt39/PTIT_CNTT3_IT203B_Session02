import java.util.*;
import java.util.function.*;

class User {
    private String username;
    public User() {
        this.username = "defaultUser";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("nhat"));
        users.add(new User("duy"));
        users.add(new User("son"));
        Function<User, String> getName = User::getUsername;

        for (User u : users) {
            System.out.println(getName.apply(u));
        }
        Consumer<String> print = System.out::println;
        print.accept("Hello Java");
        Supplier<User> createUser = User::new;

        User newUser = createUser.get();
        System.out.println(newUser.getUsername());
    }
}