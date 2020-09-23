/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author kyleh
 */
public class Team{ //implements Comparable<Team>{
    
    private int teamNumber;
    private int teamPower;
    private String teamName;
    private ArrayList<MatchData> matches = new ArrayList<>();
    
    
    public Team(int number, String name){
        teamNumber = number;
        teamName = name;
    }
    
    public void addMatch(int matchNumber, int[] cellData, boolean[] boolData ){
        matches.add(new MatchData(matchNumber, cellData, boolData));
    }
    
    public int getTeamNumber(){
        return teamNumber;
    }
    
    public String getTeamName(){
        return teamName;
    }
    
    public void updateTeamPower(){
        for (MatchData match : matches) {
            teamPower += match.getPower();
        }
    }
    
    public int getTeamPower(){
        return teamPower;
    }
    
    public ArrayList<MatchData> getMatches(){
        return matches;
    }
    
    @Override
    public String toString(){
        return String.format("%5d %-30s", teamNumber, teamName); //format strings lol
    }
}

class Sortbynumber implements Comparator<Team>{
    public int compare(Team a, Team b){
        return a.getTeamNumber() - b.getTeamNumber();
    }
}

class Sortbypower implements Comparator<Team>{
    public int compare(Team a, Team b){
        return a.getTeamPower() - b.getTeamPower();
    }
}
