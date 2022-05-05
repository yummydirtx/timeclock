/*
    Copyright (c) 2022 Alex Frutkin and Hannah Behrend
    
    This file is part of TimeClock.

    TimeClock is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TimeClock is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TimeClock.  If not, see <https://www.gnu.org/licenses/>.

*/

package user;

import java.io.Serializable;

public class User implements Serializable {
    // Each user should have a password
    private String username;
    private String password;
    private Long clockInTime;
    private boolean clockedIn = false;
    private double wage;

    // Two basic constructors
    public User() {
        this.password = "";
    }

    public User(String password, String username, double wage) {
        this.password = password;
        this.username = username;
        this.wage = wage;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
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