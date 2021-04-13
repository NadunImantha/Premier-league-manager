package CLI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    private final int noOfFootballClubs;
    private final Scanner input = new Scanner(System.in);
    public static ArrayList<FootballClub> footballClubArrayList = new ArrayList<FootballClub>();
    public static ArrayList<PlayedMatch> playedMatchArrayList = new ArrayList<PlayedMatch>();
    private FootballClub footballClub;
    private int wins, draws, defeats, scoredGoals, receivedGoals, points, playedMatches;
    private String clubTypeNo, clubName, clubLocation, schoolName, universityName;

    public PremierLeagueManager(int noOfFootballClubs) {
        this.noOfFootballClubs = noOfFootballClubs;
        readFile();
    }


    // getter
    public int getNoOfFootballClubs() {
        return noOfFootballClubs;
    }


    // add a new football club
    public void addNewClub(){
        // check if have free slots to add a new match
        if (footballClubArrayList.size() == noOfFootballClubs){
            System.out.println("No free slots to add more clubs.");
            return;
        }

        // prompt to user type of football clubs
        System.out.println("Press 1 -- Create a new Football Club");
        System.out.println("Press 2 -- Create a new School Football Club (U-18)");
        System.out.println("Press 3 -- Create a new University Football Club (U-23)");
        System.out.print("Choose club type : ");
        clubTypeNo = input.nextLine();

        // check user input is 1, 2, or 3
        if (clubTypeNo.equals("1") || clubTypeNo.equals("2") || clubTypeNo.equals("3")){
            System.out.print("Enter Club Name : ");
            clubName = input.nextLine();

            // check club is already exist
            for (FootballClub club : footballClubArrayList){
                if (club.getClubName().equals(clubName)){
                    System.out.println("'" + clubName + "' ,Club Is Already Exist..!");
                    return;
                }
            }

            // enter club location
            System.out.print("Enter Club Location : ");
            clubLocation = input.nextLine();


            switch (clubTypeNo){
                case "1":
                    inputStatistics();
                    footballClub = new FootballClub(clubName,clubLocation,wins,draws,defeats,scoredGoals,receivedGoals,points,playedMatches);
                    break;

                case "2":
                    System.out.print("Enter School Name : ");
                    schoolName = input.nextLine();
                    inputStatistics();
                    footballClub = new SchoolFootballClub(clubName,schoolName, clubLocation,wins,draws,defeats,scoredGoals,receivedGoals,points,playedMatches);
                    break;

                case "3":
                    System.out.print("Enter University Name : ");
                    universityName = input.nextLine();
                    inputStatistics();
                    footballClub = new UniversityFootballClub(clubName,universityName, clubLocation,wins,draws,defeats,scoredGoals,receivedGoals,points,playedMatches);
                    break;
            }
            // add club to the array
            footballClubArrayList.add(footballClub);
            System.out.println("Club " + clubName + " have been record successfully.");
        }

        else
            System.out.println("Invalid Input..!");
    }



    // user input club statistics
    public void inputStatistics(){
        wins = integerCheck("Enter number of won matches : ");
        draws = integerCheck("Enter number of draw matches : ");
        defeats = integerCheck("Enter number of defeat matches : ");
        scoredGoals = integerCheck("Enter number of scored goals : ");
        receivedGoals = integerCheck("Enter number of received goals : ");
        points = integerCheck("Enter number of points : ");
        playedMatches = integerCheck("Enter number of played matches : ");

    }
    // input validation
    public int integerCheck(String msg){
        Scanner integerCheckInput = new Scanner(System.in);
        int value = 0;

        while (true){
            System.out.print(msg);  // display message
            String userInput = integerCheckInput.next();

            // check user input is valid
            try{
                value = Integer.parseInt(userInput);
                break;
            } catch (Exception e){
                System.out.println(" Invalid input..!");
            }
        }

        return value;
    }



    // delete a club
    public void deleteClub(){
        System.out.print("Enter Club Name To Delete : ");
        String deleteClubName = input.nextLine();

        // check the user input club is in the list
        for (FootballClub footballClub : footballClubArrayList){
            if (footballClub.getClubName().equals(deleteClubName)){
                footballClubArrayList.remove(footballClub);
                System.out.println(footballClub.getClubName() + " Club Removed Successfully.");
                return;
            }
        }
        // if the club not found then system prompt this message
        System.out.println(deleteClubName + " Club Not Fond..!");
    }



    // display statics for a club
    public void displayStatics(){
        System.out.print("Enter Club Name : ");
        String displayClubName = input.nextLine();

        // check if user input club is currently exist
        for (FootballClub footballClub : footballClubArrayList){
            if (footballClub.getClubName().equals(displayClubName)){
                System.out.println(displayClubName + " club statics ---->");
                System.out.println("  Number of won matches : " + footballClub.getNoOfWins());
                System.out.println("  Number of defeat matches : " + footballClub.getNoOfDefeats());
                System.out.println("  Number of draw matches : " + footballClub.getNoOfDraws());
                System.out.println("  Number of scored goals : " + footballClub.getNoOfScoredGoals());
                System.out.println("  Number of received goals : " + footballClub.getNoOfReceivedGoals());
                System.out.println("  Number of points : " + footballClub.getNoOfPoints());
                System.out.println("  Number of played matches : " + footballClub.getNoOfPlayedMatches());
                return;
            }
        }
        System.out.println(displayClubName + " club not found...!");
    }



    // display league table
    public void displayTable(){
        Collections.sort(footballClubArrayList,new GoalDeferenceComparator());

        // check if have any clubs to display the in table
        if (footballClubArrayList.size() == 0){
            System.out.println("Premier League Table Is Empty...!");
            return;
        }

        // table format
        String format = "| %-13s | %-14d | %-4d | %-5d | %-7d | %-6d | %-14d |%n";

        System.out.format("+---------------+----------------+------+-------+---------+--------+----------------+%n");
        System.out.format("|   Club Name   | Played Matches | Wins | Draws | Defeats | Points | Goal Deference |%n");
        System.out.format("+---------------+----------------+------+-------+---------+--------+----------------+%n");
        for (FootballClub club : footballClubArrayList) {
            System.out.format(format,
                    club.getClubName(),
                    club.getNoOfPlayedMatches(),
                    club.getNoOfWins(),
                    club.getNoOfDraws(),
                    club.getNoOfDefeats(),
                    club.getNoOfPoints(),
                    (club.getNoOfScoredGoals()-club.getNoOfReceivedGoals()) );
        }
        System.out.format("+---------------+----------------+------+-------+---------+--------+----------------+%n");
    }



    // add a played match
    public void addPlayedMatch(){
        Scanner addMatchInputs = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FootballClub ATeam = null, BTeam = null;
        String goals;

        System.out.print("Enter match played date (dd/mm/yyyy) : ");
        String inputDate = addMatchInputs.nextLine();
        // check the input date format
        try{
            Date date = dateFormat.parse(inputDate);

            // check if input date is valid date or not
            if (!inputDate.equals(dateFormat.format(date))){
                System.out.println("Input date is not valid...!");
                return;
            }
        } catch(Exception e){
            System.out.println("You have to enter date in dd/mm/yyyy format...!");
            return;
        }


        // enter A team and check if team is in the list
        System.out.print("Enter Team A Name : ");
        String ATeamName = addMatchInputs.nextLine();
        for (FootballClub club : footballClubArrayList){
            if (club.getClubName().equals(ATeamName))
                ATeam = club;
        }
        if (ATeam == null){
            System.out.println(ATeamName + " club not found...!");
            return;
        }


        // enter B team and check if team is in the list
        System.out.print("Enter Team B Name : ");
        String BTeamName = addMatchInputs.nextLine();
        for (FootballClub club : footballClubArrayList){
            if (club.getClubName().equals(BTeamName))
                BTeam = club;
        }
        if (BTeam == null){
            System.out.println(BTeamName + " club not found...!");
            return;
        }


        // A team goals
        System.out.print("Enter Team A Scored Goals : ");
        goals = addMatchInputs.next();
        int ATeamGoals = 0;
        try {
            ATeamGoals = Integer.parseInt(goals);
        }catch (Exception e){
            System.out.println("You have to enter number of goals..!");
            return;
        }


        // B team goals
        System.out.print("Enter Team B Scored Goals : ");
        goals = addMatchInputs.next();
        int BTeamGoals = 0;
        try {
            BTeamGoals = Integer.parseInt(goals);
        }catch (Exception e){
            System.out.println("You have to enter number of goals..!");
            return;
        }


        // set up team statistics (auto update statistics)
        ATeam.setNoOfScoredGoals(ATeam.getNoOfScoredGoals() + ATeamGoals);
        ATeam.setNoOfReceivedGoals(ATeam.getNoOfReceivedGoals() + BTeamGoals);
        ATeam.setNoOfPlayedMatches(ATeam.getNoOfPlayedMatches() + 1);

        BTeam.setNoOfScoredGoals(BTeam.getNoOfScoredGoals() + BTeamGoals);
        BTeam.setNoOfReceivedGoals(BTeam.getNoOfReceivedGoals() + ATeamGoals);
        BTeam.setNoOfPlayedMatches(BTeam.getNoOfPlayedMatches() + 1);

        // calculate points, wins, defeats, draws counts
        if (ATeamGoals > BTeamGoals){
            ATeam.setNoOfPoints(ATeam.getNoOfPoints() + 3);
            ATeam.setNoOfWins(ATeam.getNoOfWins() + 1);
            BTeam.setNoOfDefeats(BTeam.getNoOfDefeats() + 1);
        }
        else if(ATeamGoals < BTeamGoals){
            BTeam.setNoOfPoints(BTeam.getNoOfPoints() + 3);
            BTeam.setNoOfWins(BTeam.getNoOfWins() + 1);
            ATeam.setNoOfDefeats(ATeam.getNoOfDefeats() + 1);
        }
        else {
            ATeam.setNoOfPoints(ATeam.getNoOfPoints() + 1);
            BTeam.setNoOfPoints(BTeam.getNoOfPoints() + 1);
            BTeam.setNoOfDraws(BTeam.getNoOfDraws() + 1);
            ATeam.setNoOfDraws(ATeam.getNoOfDraws() + 1);
        }

        // add played match to the arraylist
        PlayedMatch playedMatch = new PlayedMatch(inputDate,ATeamName,BTeamName,ATeamGoals,BTeamGoals);
        playedMatchArrayList.add(playedMatch);
        System.out.println("Record played match successfully.");
    }


    // save football clubs in to file
    public static void saveFile(){
        try{
            // football clubs details file
            FileOutputStream fosClubs = new FileOutputStream("FootballTeams.txt");
            ObjectOutputStream oosClubs = new ObjectOutputStream(fosClubs);

            for (FootballClub club : footballClubArrayList){
                oosClubs.writeObject(club);
            }

            // played matches details file
            FileOutputStream fosMatches = new FileOutputStream("PlayedMatch.txt");
            ObjectOutputStream oosMatches = new ObjectOutputStream(fosMatches);

            for (PlayedMatch match : playedMatchArrayList){
                oosMatches.writeObject(match);
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }


    // read clubs from file and add to the array list
    public static void readFile(){
        try{
            // read file for football clubs array list
            FileInputStream fisClubs = new FileInputStream("FootballTeams.txt");
            ObjectInputStream oisClubs = new ObjectInputStream(fisClubs);

            // read football clubs records from file and add them to the footballClubArrayList
            for (;;){
                try{
                    footballClubArrayList.add((FootballClub) oisClubs.readObject());
                } catch (Exception e){
                    break;
                }
            }

            // read file for played match array list
            FileInputStream fisMatches = new FileInputStream("PlayedMatch.txt");
            ObjectInputStream oisMatches = new ObjectInputStream(fisMatches);

            // read played matches records and add to the playedMatchArrayList
            for (;;){
                try{
                    playedMatchArrayList.add((PlayedMatch) oisMatches.readObject());
                } catch (Exception e){
                    break;
                }
            }

        } catch (Exception ignored){}
    }
}
