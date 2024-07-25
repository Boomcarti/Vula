import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopularColourTest {

    public static void main(String[] args) {
        String usersFile = "data/users.txt";
        String favouritesFile = "data/favourites.txt";

        Map<String, String> userMap = readUsers(usersFile);
        Map<String, Integer> colourCount = new HashMap<>();
        Map<String, List<String>> colourUsers = new HashMap<>();

        readFavourites(favouritesFile, userMap, colourCount, colourUsers);

        String mostPopularColour = findMostPopularColour(colourCount);
        System.out.println("Most Popular Colour: " + mostPopularColour);

        List<String> users = getUsersForColour(mostPopularColour, colourUsers);
        printUsers(mostPopularColour, users);
    }

    private static Map<String, String> readUsers(String filePath) {
        Map<String, String> userMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+", 2);
                String userId = parts[0].trim();
                String userName = parts[1].trim();
                userMap.put(userId, userName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userMap;
    }

    private static void readFavourites(String filePath, Map<String, String> userMap, Map<String, Integer> colourCount, Map<String, List<String>> colourUsers) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+", 2);
                String userId = parts[0].trim();
                String colour = parts[1].trim();

                colourCount.put(colour, colourCount.getOrDefault(colour, 0) + 1);
                colourUsers.computeIfAbsent(colour, k -> new ArrayList<>()).add(userMap.get(userId));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findMostPopularColour(Map<String, Integer> colourCount) {
        return Collections.max(colourCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static List<String> getUsersForColour(String colour, Map<String, List<String>> colourUsers) {
        List<String> users = colourUsers.getOrDefault(colour, new ArrayList<>());
        Collections.sort(users);
        return users;
    }

    private static void printUsers(String colour, List<String> users) {
        System.out.println("Users who voted for " + colour + ":");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
