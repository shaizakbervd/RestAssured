package Utils;

import java.util.Random;

public class RandomStringGenerator {

    public String generateRandomString(int length) {
        // Characters that can be included in the random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Create a Random object
        Random random = new Random();

        // Create a StringBuilder to store the random string
        StringBuilder sb = new StringBuilder(length);

        // Generate random characters and append them to the StringBuilder
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        // Convert the StringBuilder to a String and return it
        return sb.toString();
    }
}
