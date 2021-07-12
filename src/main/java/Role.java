import java.util.List;

public class Role {

    private String roleName;
    private List<User> userList;

    public Role(String roleName, List<User> userList) {
        this.roleName = roleName;
        this.userList = userList;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
