/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

import java.util.ArrayList;

/**
 *
 * @author kyleh
 */
public class Team implements Comparable<Team>{
    
    private int teamNumber;
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
    
    public ArrayList<MatchData> getMatches(){
        return matches;
    }
    
    @Override
    public String toString(){
        return String.format("%5d %-30s", teamNumber, teamName); //format strings lol
    }
    
    @Override
    public int compareTo(Team team){
        if(team.getTeamNumber() == teamNumber){
            return 0;
        }else if(team.getTeamNumber() > teamNumber){
            return -1;
        }else{
            return 1;
        }
    }
}
