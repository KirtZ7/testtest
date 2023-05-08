package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class SWAPI {

    public static void main(String[] args) throws IOException {
        // create a new instance of the Random class
        Random rand = new Random();

        // generate two random numbers between 1 and 15 (inclusive)
        int id1 = rand.nextInt(15) + 1;
        int id2 = rand.nextInt(15) + 1;

        // use the two generated IDs to form URLs for the two characters
        String url1 = "https://swapi.dev/api/people/" + id1 + "/";
        String url2 = "https://swapi.dev/api/people/" + id2 + "/";

        // create new URL objects for the two character URLs
        URL urlObj1 = new URL(url1);
        URL urlObj2 = new URL(url2);

        // create new Scanner objects to read data from the character URLs
        Scanner scanner1 = new Scanner(urlObj1.openStream());
        Scanner scanner2 = new Scanner(urlObj2.openStream());

        // read the data from the character URLs and store it in two Strings
        String character1 = scanner1.nextLine();
        String character2 = scanner2.nextLine();

        // extract the character names and genders from the two Strings
        String name1 = character1.split("\"name\":\"")[1].split("\",\"")[0];
        String name2 = character2.split("\"name\":\"")[1].split("\",\"")[0];
        String gender1 = character1.split("\"gender\":\"")[1].split("\",\"")[0];
        String gender2 = character2.split("\"gender\":\"")[1].split("\",\"")[0];

        // determine the honorifics for the two characters based on gender
        String honorific1 = gender1.equals("male") ? "Mr." : "Ms.";
        String honorific2 = gender2.equals("male") ? "Mr." : "Ms.";

        // generate a random number between 1 and 30 (inclusive)
        int shipId = rand.nextInt(30) + 1;

        // use the generated ship ID to form a URL for the starship
        String shipUrl = "https://swapi.dev/api/starships/" + shipId + "/";

        // create a new URL object for the starship URL
        URL shipUrlObj = new URL(shipUrl);

        // create a new Scanner object to read data from the starship URL
        Scanner shipScanner = new Scanner(shipUrlObj.openStream());

        // read the data from the starship URL and store it in a String
        String shipData = shipScanner.nextLine();

        // extract the starship name from the String
        String shipName = shipData.split("\"name\":\"")[1].split("\",\"")[0];

        // print the sentence with the randomly generated values
        System.out.println(honorific1 + " " + name1 + " and " + honorific2 + name2 +
                " cruising around in their " + shipName);
    }
}