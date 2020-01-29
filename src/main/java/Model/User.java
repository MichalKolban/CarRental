package Model;

public class User {

    private int userId;
//    private String login;            solve it later
//    private String password;         solve it later
    private String user_name;
    private String lastName;
    private UserPersonalInfo personalInfo;

    public User() {
    }

    public User(int userId, String name, String lastName, UserPersonalInfo personalInfo) {
        this.userId = userId;
        this.user_name = name;
        this.lastName = lastName;
        this.personalInfo = personalInfo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserPersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(UserPersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}
