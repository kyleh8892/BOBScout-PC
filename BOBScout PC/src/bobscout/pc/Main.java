/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import my.gui.AddFullMatch;
import my.gui.AddSingleMatch;
import my.gui.AddTeams;
import my.gui.CompetitionName;
import my.gui.DataView;
import my.gui.StartUp;

/**
 *
 * @author kyleh
 */
public class Main {
    
            
    public static void main(String[] args){
        showStartUp();
    }
    
    public static String competitionName = "";
    
    public static ArrayList<Team> teamList = new ArrayList<Team>();
    public static ArrayList<Integer> teamNumbers = new ArrayList<>();
    
    public static void setCompetitionName(String name){
        competitionName = name;
    }
    
    public static String getCompetitionName(){
        return competitionName;
    }
    
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
    
    public static void showDataView(){
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataView().setVisible(true);
            }
        });
    }
    
    public static void showAddTeams(){
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTeams(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    public static void showAddMatch(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new AddFullMatch(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    public static void showStartUp(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new StartUp().setVisible(true);
            }
        });
    }
    
    public static void showAddSingleMatch(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new AddSingleMatch(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    public static void showNameComp(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompetitionName(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
}
