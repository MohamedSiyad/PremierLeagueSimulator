/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1758050_footballmanager;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author msiyad
 */
public class PremierLeagueManager implements LeagueManager {

    private final int numberOfTeams;
    public static ArrayList<FootballClub> league;
    private final Scanner scan;
    private final ArrayList<match> matches;

    public PremierLeagueManager(int numberOfTeams) {
        this.numberOfTeams = 20;
        league = new ArrayList<>();
        matches = new ArrayList<>();
        scan = new Scanner(System.in);
        displayMenu();

    }

    private void displayMenu() {

        while (true) {
            System.out.println("Premier League Menu");
            System.out.println("Press 1 to Create a new football club and add it in the premier league");
            System.out.println("Press 2 to Delete (relegate) an existing football club from the premier league. ");
            System.out.println("Press 3 to Display the various statistics for a selected club.");
            System.out.println("Press 4 to Display the Premier League Table");
            System.out.println("Press 5 to Add a played match with its score and its date");
            System.out.println("Press 6 to save this information in a file");
            System.out.println("Press 7 to recover this information from a saved file");
            System.out.println("Press 8 to open GUI");
            String input = scan.nextLine();
            int num = 0;
            try {
                num = Integer.parseInt(input);

            } catch (NumberFormatException n) {
            }
            switch (num) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    deleteTeam();
                    break;
                case 3:
                    displayStats();
                    break;
                case 4:
                    displayPremierLeagueTable();
                    break;
                case 5:
                    AddPlayedMatch();
                    break;
                case 6:
                    SaveToFile();
                    break;
                case 8:
                    OpenGUI();
                    break;
                default:
                    System.out.println("Please input a number between 1 and 7");
            }
        }
    }

    private void createTeam() {

        if (league.size() == numberOfTeams) {
            System.out.println("This league is full");
            return;
        }

        FootballClub club = new FootballClub();
        System.out.println("Please enter a club name: ");
        String input = scan.nextLine();
        club.setName(input);

        //can't have duplicate clubs
        if (league.contains(club)) {
            System.out.println("Duplicate clubs");
            return;
        }
        league.add(club);

    }

    private void deleteTeam() {
        System.out.println("Please enter the club name: ");
        String input = scan.nextLine();
        for (FootballClub club : league) {
            if (club.getName().equals(input)) {
                league.remove(club);
                System.out.println(club.getName() + " has been removed");
                return;
            }
        }
        System.out.println("This club doesn't exist");
    }

    private void displayStats() {
        System.out.println("Please enter the club name: ");
        String input = scan.nextLine();
        for (FootballClub club : league) {
            if (club.getName().equals(input)) {
                System.out.println(club.getName() + " has won " + club.getWinsAmount() + " games");
                System.out.println(club.getName() + " has lost " + club.getLossAmount() + " games");
                System.out.println(club.getName() + " has drew " + club.getDrawsAmount() + " games");
                System.out.println(club.getName() + " has scored " + club.getGoalsScored() + " goals");
                System.out.println(club.getName() + " has conceded " + club.getGoalsConceded() + " goals");
                System.out.println(club.getName() + " has " + club.getNumberOfPoints() + " points");
                return;
            }

        }
        System.out.println("This club doesn't exist");
    }

    public void displayPremierLeagueTable() {
        Collections.sort(league, new TableComparator());
        for (FootballClub club : league) {
            System.out.println("Club: " + club.getName() + " Points: " + club.getNumberOfPoints() + " GD: " + (club.getGoalsScored() - club.getGoalsConceded()));
        }
    }

    private void AddPlayedMatch() {
        System.out.println("Enter match date: ");
        String input = scan.nextLine();
        Date MatchDate;
        try {
            MatchDate = new SimpleDateFormat("dd-MM-yy").parse(input);
        } catch (ParseException formatproblem) {
            System.out.println("The date must be in the format dd-mm-yy");
            return;
        }
        System.out.println("Enter the home team: ");
        input = scan.nextLine();
        FootballClub home = null;
        for (FootballClub club : league) {
            if (club.getName().equals(input)) {
                home = club;
            }
        }
        if (home == null) {
            System.out.println("This club doesn't exist");
            return;
        }
        System.out.println("Enter Away Team: ");
        input = scan.nextLine();
        FootballClub away = null;
        for (FootballClub club : league) {
            if (club.getName().equals(input)) {
                away = club;
            }
        }
        if (away == null) {
            System.out.println("No such club in league");
            return;
        }
        System.out.println("Enter home team goals: ");
        input = scan.nextLine();
        int homeGoals = -1;
        try {
            homeGoals = Integer.parseInt(input);
        } catch (NumberFormatException e) {
        }
        if (homeGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }

        System.out.println("Enter away team goals: ");
        input = scan.nextLine();
        int awayGoals = -1;
        try {
            awayGoals = Integer.parseInt(input);
        } catch (NumberFormatException e) {
        }
        if (awayGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }

        match match = new match();
        match.setMatchDate(MatchDate);
        match.setHomeTeam(home);
        match.setAwayTeam(away);
        match.setHomeTeamScore(awayGoals);
        match.setAwayTeamScore(homeGoals);
        matches.add(match);
        home.setGoalsScored(home.getGoalsScored() + homeGoals);
        away.setGoalsScored(away.getGoalsScored() + awayGoals);
        home.setGoalsConceded(home.getGoalsConceded() + awayGoals);
        away.setGoalsConceded(away.getGoalsConceded() + homeGoals);
        home.setMatchesPlayed(home.getMatchesPlayed() + 1);
        away.setMatchesPlayed(away.getMatchesPlayed() + 1);

        if (homeGoals > awayGoals) {
            home.setNumberOfPoints(home.getNumberOfPoints() + 3);
            home.setWinsAmount(home.getWinsAmount() + 1);
            away.setLossAmount(away.getLossAmount() + 1);
        } else if (homeGoals < awayGoals) {
            away.setNumberOfPoints(away.getNumberOfPoints() + 3);
            away.setWinsAmount(away.getWinsAmount() + 1);
            home.setLossAmount(home.getLossAmount() + 1);
        } else {
            home.setNumberOfPoints(home.getNumberOfPoints() + 1);
            away.setNumberOfPoints(away.getNumberOfPoints() + 1);
            home.setDrawsAmount(home.getDrawsAmount() + 1);
            away.setDrawsAmount(away.getDrawsAmount() + 1);
        }
    }

    private void SaveToFile() {
        try {
            File file = new File("allinformation.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            Collections.sort(league, new TableComparator());
            for (FootballClub club : league) {
                try (PrintWriter infowriter = new PrintWriter(file)) {
                    infowriter.print("Club: " + club.getName() + " Points: " + club.getNumberOfPoints() + " GD: " + (club.getGoalsScored() - club.getGoalsConceded()));
                }
            }
            System.out.println("Saved.");
        } catch (IOException e) {

        }
    }

    private void OpenGUI() {
        GUI form = new GUI();
        form.setVisible(true);
    }

}
