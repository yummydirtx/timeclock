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

public class Admin extends User {
    // Constructor
    public Admin(String password, String username, double wage) {
        super(password, username, wage);
    }

    // Override isAdmin to return true
    public boolean isAdmin() {
        return true;
    }
}
