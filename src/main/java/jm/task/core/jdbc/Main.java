package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userServ = new UserServiceImpl();
    public static void main(String[] args) {
        userServ.cleanUsersTable();

        userServ.saveUser("Alex", "Li", (byte)22);
        userServ.saveUser("Nina", "Lim", (byte)26);
        userServ.saveUser("Stew", "Kim", (byte)67);
        userServ.saveUser("Mike", "Li", (byte) 52);

        userServ.removeUserById(1);
        userServ.getAllUsers();
        userServ.cleanUsersTable();
        userServ.dropUsersTable();

    }
}
