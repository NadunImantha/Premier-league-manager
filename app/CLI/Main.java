package CLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input number of clubs
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager(10);
        Scanner input = new Scanner(System.in);

        // premier league menu
        while (true){
            System.out.println();
            System.out.println("<---- PREMIER LEAGUE MENU ---->");
            System.out.println("Press 1 -- Create a new football club and add it in the premier league");
            System.out.println("Press 2 -- Delete an existing club from the premier league");
            System.out.println("Press 3 -- Display the statics for a club");
            System.out.println("Press 4 -- Display the premier league table");
            System.out.println("Press 5 -- Add a played match");
            System.out.println("Press 0 -- To quit");
            System.out.print("Choose number : ");
            String menuChoice = input.nextLine();

            if (menuChoice.equals("1"))
                premierLeagueManager.addNewClub();

            else if (menuChoice.equals("2"))
                premierLeagueManager.deleteClub();

            else if (menuChoice.equals("3"))
                premierLeagueManager.displayStatics();

            else if (menuChoice.equals("4"))
                premierLeagueManager.displayTable();

            else if (menuChoice.equals("5"))
                premierLeagueManager.addPlayedMatch();

            else if (menuChoice.equals("0")){
                System.out.println("Thank You.");
                break;
            }

            else
                System.out.println("Invalid Input..!");

            // save update records to the file
            premierLeagueManager.saveFile();
        }
    }
}
