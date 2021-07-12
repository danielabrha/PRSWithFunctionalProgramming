import java.time.LocalDateTime;
import java.util.List;

public class User extends Person {
    private String userName;
    private String password;
    private List<Role> roleList;

    public User(String fName, String lName, String mName, String gender, String email, String phoneNumber,
                String address, LocalDateTime dateOfBirth, String userName, String password, List<Role> roleList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
    }

    public User(String userName, String password, List<Role> roleList) {
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
