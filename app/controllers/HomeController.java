package controllers;

import CLI.FootballClub;
import CLI.PlayedMatch;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;


public class HomeController extends Controller {

//    club details
    ArrayList<FootballClub> footballClubArrayList = new ArrayList<>();
    public Result readClubs(){
        footballClubArrayList.clear();  // clear array list before displaying the list

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
        } catch (Exception ignored){}


        JsonNode jsonNode = Json.toJson(footballClubArrayList);
        return ok(jsonNode).as("application/json");
    }

    ArrayList<PlayedMatch> playedMatchArrayList = new ArrayList<>();
    public Result readMatches(){
        playedMatchArrayList.clear();   // clear array before displaying the table

        try{
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


        JsonNode jsonNode = Json.toJson(playedMatchArrayList);
        return ok(jsonNode).as("application/json");
    }

    // add played match
    public Result addMatch(){
        Random random = new Random();

        // create random date
        int day = random.nextInt(31) + 1;
        int month = random.nextInt(12) + 1;
        int year = 2000 + random.nextInt(21);
        String date = day + "/" + month + "/" + year;

        // get random teams
        FootballClub teamA, teamB;
        int teamAIndex, teamBIndex;
        while (true){
            teamAIndex = random.nextInt(footballClubArrayList.size());
            teamBIndex = random.nextInt(footballClubArrayList.size());

            if (teamAIndex != teamBIndex){
                teamA = footballClubArrayList.get(teamAIndex);
                teamB = footballClubArrayList.get(teamBIndex);
                break;
            }
        }

        // get random goals
        int teamAGoals = random.nextInt(11);
        int teamBGoals = random.nextInt(11);

        // team names
        String teamAName = teamA.getClubName();
        String teamBName = teamB.getClubName();

        // update statistics
        teamA.setNoOfScoredGoals(teamA.getNoOfScoredGoals() + teamAGoals);
        teamA.setNoOfReceivedGoals(teamA.getNoOfReceivedGoals() + teamBGoals);
        teamA.setNoOfPlayedMatches(teamA.getNoOfPlayedMatches() + 1);

        teamB.setNoOfScoredGoals(teamB.getNoOfScoredGoals() + teamBGoals);
        teamB.setNoOfReceivedGoals(teamB.getNoOfReceivedGoals() + teamAGoals);
        teamB.setNoOfPlayedMatches(teamB.getNoOfPlayedMatches() + 1);

        // calculate points, wins, defeats, draws counts
        if (teamAGoals > teamBGoals){
            teamA.setNoOfPoints(teamA.getNoOfPoints() + 3);
            teamA.setNoOfWins(teamA.getNoOfWins() + 1);
            teamB.setNoOfDefeats(teamB.getNoOfDefeats() + 1);
        }
        else if(teamAGoals < teamBGoals){
            teamB.setNoOfPoints(teamB.getNoOfPoints() + 3);
            teamB.setNoOfWins(teamB.getNoOfWins() + 1);
            teamA.setNoOfDefeats(teamA.getNoOfDefeats() + 1);
        }
        else {
            teamA.setNoOfPoints(teamA.getNoOfPoints() + 1);
            teamB.setNoOfPoints(teamB.getNoOfPoints() + 1);
            teamB.setNoOfDraws(teamB.getNoOfDraws() + 1);
            teamA.setNoOfDraws(teamA.getNoOfDraws() + 1);
        }

        // add played match
        PlayedMatch randomMatch = new PlayedMatch(date,teamAName,teamBName,teamAGoals,teamBGoals);
        playedMatchArrayList.add(randomMatch);

        // save records to file
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

        JsonNode jsonNode = Json.toJson(playedMatchArrayList);
        return ok(jsonNode).as("application/json");
    }
}