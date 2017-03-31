package wxb.com.mvvmdemo.bean;

/**
 * Created by 黑月 on 2017/3/29.
 */

public class User {
    private String firstName;
    private String lastName;
    private String displayName;
    private int age;

    public User(String firstName, String lastName, String displayName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

}
