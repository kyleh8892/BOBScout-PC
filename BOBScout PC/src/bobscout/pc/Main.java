/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

import my.gui.AddFullMatch;
import my.gui.AddSingleMatch;
import my.gui.AddTeams;
import my.gui.DataView;
import my.gui.StartUp;

/**
 *
 * @author kyleh
 */
public class Main {
    
            
    public static void main(String[] args){
        //showDataView();
        //showAddTeams();
        showStartUp();
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
}
