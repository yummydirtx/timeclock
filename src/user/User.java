package user;

import java.io.Serializable;

public class User implements Serializable {
    // Each user should have a password
    private String password;
    private Long clockInTime;
    private boolean clockedIn = false;

    // Two basic constructors
    public User() {
        this.password = "";
    }

    public User(String password) {
        this.password = password;
    }

    // Getters and setters, with validation for password

    public void setPassword(String oldPass, String password) {
        if (oldPass.equals(this.password)) {
            this.password = password;
        }
    }

    public Long getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(Long clockInTime) {
        this.clockInTime = clockInTime;
    }

    public boolean isClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(boolean clockedIn) {
        this.clockedIn = clockedIn;
    }

    // Allow outside classes to check the password
    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    // Users are not admins by default
    public boolean isAdmin() {
        return false;
    }
}
