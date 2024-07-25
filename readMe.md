### README for Popular Colour Finder Java Application

#### Overview
This Java application determines the most popular colour based on user preferences stored in two text files. The application reads user data and their favourite colours, computes the frequency of each colour, and identifies the most popular one. It then lists all users who prefer this colour.

#### Files Description
1. **users.txt**: Contains user IDs and names, formatted as `userID userName`.
2. **favourites.txt**: Contains user IDs and their favourite colours, formatted as `userID colour`.

#### Application Components
- **PopularColourTest**: The main class that orchestrates the reading of files, computation of the most popular colour, and output of results.

#### Functions
- **readUsers(String filePath)**: Reads the users file and maps user IDs to names.
- **readFavourites(String filePath, Map<String, String> userMap, Map<String, Integer> colourCount, Map<String, List<String>> colourUsers)**: Reads the favourites file, updates the count of each colour, and maps colours to users.
- **findMostPopularColour(Map<String, Integer> colourCount)**: Determines the colour with the highest count.
- **getUsersForColour(String colour, Map<String, List<String>> colourUsers)**: Retrieves a sorted list of users who favour a particular colour.
- **printUsers(String colour, List<String> users)**: Displays the colour and the users who favour it.

#### How to Run the Application
1. Ensure Java is installed on your system.
2. Place the `users.txt` and `favourites.txt` in a directory named `data` at the same level as the Java program.
3. Compile the Java program using:
javac PopularColourTest.java


4. Run the compiled class:
java PopularColourTest



#### Dependencies
- Java SE Development Kit 8 or later.

#### Output
The program prints the most popular colour followed by a list of users who favour that colour, formatted as:
Most Popular Colour: [Colour]
Users who voted for [Colour]:
[User1]
[User2]
...