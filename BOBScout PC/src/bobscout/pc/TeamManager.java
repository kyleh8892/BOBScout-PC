/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kyleh
 */
public class TeamManager {
    
    public static ArrayList<Team> teamList = new ArrayList<Team>();
    public static ArrayList<Integer> teamNumbers = new ArrayList<>();
    
    public static ArrayList<Team> getTeamList(){
        return teamList;
    }
    
    public static ArrayList<Integer> getTeamNumbers(){
        return teamNumbers;
    }
    
    public static void sortTeams(){
        Collections.sort(teamList);
        Collections.sort(teamNumbers);
    }
    
    public static void addTeam(Team team){
        teamList.add(team);
        teamNumbers.add(team.getTeamNumber());
        sortTeams();
    }
    
    public static void removeTeam(int i){
        teamList.remove(i);
        teamNumbers.remove(i);
    }
    
    public static Team getTeam(int number){
        for(Team team : teamList){
            if(team.getTeamNumber() == number){
                return team;
            }
        }
        return null;
    }
}
