/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import my.gui.AddFullMatch;
import my.gui.AddSingleMatch;
import my.gui.AddTeams;
import my.gui.CompetitionName;
import my.gui.DataView;
import my.gui.MessageDialog;
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
    
    public static void saveCompetitionAs(javax.swing.JFrame frame){
        String output = "";
        JFileChooser fileChooser = new JFileChooser();
        File fileToSave = new File(getCompetitionName() + ".bsc");
        
        fileChooser.setDialogTitle("Save Competition"); 
        fileChooser.setSelectedFile(fileToSave);
        
        for(Team team : getTeamList()){
            output += "#" + team.getTeamNumber() + "," + team.getTeamName() + ",\n";
            
            for(MatchData match : team.getMatches()){
                output += "*" + match.toString() + ",\n";
            }
        }
        
        int userSelection = fileChooser.showSaveDialog(frame);
        
        if(userSelection == JFileChooser.APPROVE_OPTION){
            fileToSave = fileChooser.getSelectedFile();
        }else{
            fileToSave = null;
        }
        
        try {
            FileWriter fileWriter = new FileWriter(fileToSave);
            fileWriter.write(output);
            fileWriter.close();
            MessageDialog dialog = new MessageDialog(new javax.swing.JFrame(), true,"File Saved!");
            dialog.setVisible(true);
        } catch (IOException e) {
            MessageDialog dialog = new MessageDialog(new javax.swing.JFrame(), true, "Error Saving File!");
            dialog.setVisible(true);
        }
    }
    
    public static void openCompetition(javax.swing.JFrame frame){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("BOB Scout Competition Files", "bsc");
        File fileToOpen = new File("");
        
        fileChooser.setDialogTitle("Open Competition"); 
        fileChooser.setFileFilter(fileNameExtensionFilter);
        
        int userSelection = fileChooser.showOpenDialog(frame);
        
        if(userSelection == JFileChooser.APPROVE_OPTION){
            fileToOpen = fileChooser.getSelectedFile();
        }else{
            MessageDialog dialog = new MessageDialog(new javax.swing.JFrame(), true, "Error Opening File!");
            dialog.setVisible(true);
        }
        
        try {
            Scanner fileIn = new Scanner(fileToOpen);
            fileIn.useDelimiter(",");
            while (fileIn.hasNextLine()){
                String data = fileIn.next();
                if(data.startsWith("#")){
                    String replace = data.replace("#", "");
                    int teamNumber = Integer.parseInt(replace);
                    Team team = new Team(teamNumber, fileIn.next());
                    teamList.add(team);
                    teamNumbers.add(teamNumber);
                }else if (data.startsWith("*")) {
                    int matchNumber = Integer.parseInt(fileIn.next());
                    int[] cellData = new int[10];
                    boolean[] boolData = new boolean[5];
                    
                    for(int i = 0; i < 10; i++){
                        cellData[i] = Integer.parseInt(fileIn.next());
                    }
                    
                    for(int i = 0; i < 5; i++){
                        boolData[i] = Boolean.getBoolean(fileIn.next());
                    }
                    
                    teamList.get(teamList.size()).addMatch(matchNumber, cellData, boolData);
                }
            }
        } catch (Exception e) {
            MessageDialog dialog = new MessageDialog(new javax.swing.JFrame(), true, "Error Reading File" + e.toString());
            dialog.setVisible(true);
        }
        
        showDataView();
    }
    
    
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
