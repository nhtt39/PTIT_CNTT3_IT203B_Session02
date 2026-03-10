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
//Kiểm tra xem một User có phải là Admin hay không (trả về true/false). - Predicate vì Predicate đại diện cho 1 phép thử
//Chuyển đổi một đối tượng User thành một chuỗi String chứa thông tin username. - Function vì function nhận vào 1 tham số kiểu T và biến đổi nó thành kiểu khác
//In thông tin chi tiết của User ra màn hình Console. - Consumer vì consumer nhận vào 1 đối tượng để thực hiện 1 hành động nào đó nhưng ko trả về kết quả nào
//Khởi tạo một đối tượng User mới với các giá trị mặc định - Supplier vì supllier không nhận vào giá trị nào nhưng trả về 1 đối tượng
