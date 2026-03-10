import java.util.function.*;

class User1 {
    String username;
    String role;

    public User1() {
        this.username = "defaultUser";
        this.role = "user";
    }

    public User1(String username, String role) {
        this.username = username;
        this.role = role;
    }
}

public class Ex1 {
    public static void main(String[] args) {

        User1 u = new User1("nhat", "admin");

        //1. Predicate: kiểm tra có phải admin không
        Predicate<User1> isAdmin = user -> user.role.equalsIgnoreCase("admin");
        System.out.println("Is admin: " + isAdmin.test(u));

        //2. Function: chuyển User -> String
        Function<User1, String> getUsername = user -> user.username;
        System.out.println("Username: " + getUsername.apply(u));

        //3. Consumer: in thông tin User
        Consumer<User1> printUser = user ->
                System.out.println("User: " + user.username + " - Role: " + user.role);
        printUser.accept(u);

        //4. Supplier: tạo User mặc định
        Supplier<User1> createUser = () -> new User1();
        User1 newUser = createUser.get();
        System.out.println("New User: " + newUser.username + " - " + newUser.role);
    }
}