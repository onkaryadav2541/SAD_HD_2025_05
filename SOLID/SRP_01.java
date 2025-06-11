package SOLID;

import java.io.FileWriter;
import java.io.IOException;

public class SRP_01 {

    /*
     * TASK:
     * Please apply to the following class "User" the
     * SRP (Single Responsibility Principle)
     */

    // Responsibility 1: Manages user data
    public static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    // Responsibility 2: Handles persistence (saving to file)
    public static class UserPersistence {
        public void saveToFile(User user) {
            try (FileWriter fileWriter = new FileWriter(user.getName() + ".txt")) {
                fileWriter.write("Name: " + user.getName() + "\n");
                fileWriter.write("Email: " + user.getEmail() + "\n");
                System.out.println("User data saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        User user = new User("Clemens", "clemens@company.com");
        UserPersistence userPersistence = new UserPersistence();
        userPersistence.saveToFile(user);
    }
}