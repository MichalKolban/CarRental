package Model;

import javax.persistence.*;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_last_name")
    private String userLastName;



    public User() {
    }

    public User(String name, String userLastName) {
        this.userName = name;
        this.userLastName = userLastName;

    }

    public int getUserId() {
        return userId;
    }

//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String lastName) {
        this.userLastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }
}
