/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gui;

import bobscout.pc.Main;
import bobscout.pc.MatchData;
import bobscout.pc.Team;
import bobscout.pc.Main;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author kyleh
 */
public class DataView extends javax.swing.JFrame {
    
    public static ArrayList<javax.swing.JPanel> tabList = new ArrayList<>();
    public static ArrayList<Stats> statTabList = new ArrayList<>();
        
    int teamIndex = 0;
    int matchIndex = 0;
    
    /**
     * Creates new form DataView
     */
    public DataView() {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        initComponents();
        
        messgeCenter.setVisible(false);
        
        updateTabs();
        
        this.setTitle("BOBScout PC - " + Main.getCompetitionName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        messgeCenter = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BOBScout PC");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("Icons/bobupscale.png")).getImage());
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel1.setText("Go To Team:");

        jButton1.setText("Add Match");
        jButton1.setDoubleBuffered(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        messgeCenter.setForeground(new java.awt.Color(255, 51, 0));
        messgeCenter.setText("Message Center");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(messgeCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(messgeCenter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Save");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setText("Save As...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem6.setText("Show Overview");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Edit Team List");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);
        jMenu2.add(jSeparator1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        updateTabs();
        if(jTabbedPane1.getTabCount() > 0){jTabbedPane1.setSelectedIndex(teamIndex);}
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Main.showAddTeams();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Main.showAddSingleMatch();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
    }//GEN-LAST:event_formFocusGained

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                goToTab(Integer.parseInt(jTextField1.getText()));
            } catch (NumberFormatException e) {
                messgeCenter.setText("Please enter only numbers!");
                messgeCenter.setVisible(true);
            }            
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Main.saveCompetitionAs(this);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Main.saveCompetition();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Main.showOverview();
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    private void close(){
        
        if(Main.getChangesMade() == true){
            SaveCheck saveDialog = new SaveCheck(this, true, Main.getCompetitionName());
            int status = saveDialog.getReturnStatus();
            System.out.println(status);
            switch (status) {
                case SaveCheck.RET_CANCEL:
                    
                case SaveCheck.RET_NOSAVE:
                    System.exit(0);
                    
                case SaveCheck.RET_SAVE:
                    Main.saveCompetition();
                    System.exit(0);
                    
                default:
                    MessageDialog dialog = new MessageDialog(new javax.swing.JFrame(), true, "Error With Save Dialog!");
                    dialog.setVisible(true);
                    
            }
        }else{
            System.exit(0);
        }
    }
    
    private void updateTabs(){
        tabList.clear();
        jTabbedPane1.removeAll();
        for(Team team : Main.getTeamList()){ 
            tabList.add(new javax.swing.JPanel()); 
            statTabList.add(new Stats());
        }
        
        int k = 0;
        for(javax.swing.JPanel panel : tabList){
            javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
            panel.setLayout(panelLayout);
            
            jTabbedPane1.addTab(Integer.toString(Main.getTeamList().get(tabList.indexOf(panel)).getTeamNumber()), panel);
            
            javax.swing.JScrollPane teamMatchListPane = new javax.swing.JScrollPane();
            javax.swing.JList teamMatchList = new javax.swing.JList();
            
            DefaultListModel listModel = new DefaultListModel();

            statTabList.get(k).getAverageStats(Main.getTeamList().get(k).getMatches(), Main.getTeamNumbers().get(k));
            
            teamMatchListPane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

            teamMatchList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            
            for(MatchData match : Main.getTeam(Main.getTeamNumbers().get(k)).getMatches()){          
                listModel.addElement(match.getMatchNumber());
            }
            
            javax.swing.JButton averageButton = new javax.swing.JButton();
            
            averageButton.setText("Average");
            
            averageButton.addActionListener(new java.awt.event.ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    averageButtonActionPerformed(evt);
                } 
            });
            
            teamMatchList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    matchSelectionChanged(evt);
                }
            });
            
            teamMatchList.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    teamMatchListFocusGained(evt);
                }
            });

            teamMatchList.setModel(listModel);
            teamMatchListPane.setViewportView(teamMatchList);
            
            jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jTabbedPane1StateChanged(evt);
                }
            });
            

            panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(teamMatchListPane, 0, 34, 34)
                        .addComponent(averageButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(statTabList.get(k))
                    .addContainerGap())
            );

            panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {averageButton, teamMatchListPane});

            panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(statTabList.get(k), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(teamMatchListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(averageButton, 0, 33, 50)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            
            panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Main.getTeamList().get(k).getTeamName(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
            
            k++;
        }
        
        if(Main.changesMade && Main.competitionFile.exists()){
            jMenuItem5.setEnabled(true);
        }else{
            jMenuItem5.setEnabled(false);
        }
    }
    
    private void goToTab(int number){
        if(Main.teamNumbers.indexOf(number) > -1){
            jTabbedPane1.setSelectedIndex(Main.teamNumbers.indexOf(number));
            messgeCenter.setVisible(false);
            jTextField1.setText("");
        } else{
            messgeCenter.setText("Team " + number + " dosen't exist!");
            messgeCenter.setVisible(true);
        } 
    }

    
    private void matchSelectionChanged (javax.swing.event.ListSelectionEvent evt){
        matchIndex = evt.getFirstIndex();
        statTabList.get(jTabbedPane1.getSelectedIndex()).getMatchStats(Main.getTeamList().get(teamIndex).getMatches().get(matchIndex), Main.getTeamNumbers().get(teamIndex));
    }
    
    private void averageButtonActionPerformed (java.awt.event.ActionEvent evt){
        statTabList.get(teamIndex).getAverageStats(Main.getTeamList().get(teamIndex).getMatches(), Main.getTeamNumbers().get(teamIndex));
    }
    
    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {                                          
        if(jTabbedPane1.getSelectedIndex() > -1){teamIndex = jTabbedPane1.getSelectedIndex();}
        statTabList.get(teamIndex).getAverageStats(Main.getTeamList().get(teamIndex).getMatches(), Main.getTeamNumbers().get(teamIndex));
    }
    
    private void teamMatchListFocusGained(java.awt.event.FocusEvent evt){ 
        if(evt.getCause().toString().equalsIgnoreCase("mouse_event")){
            statTabList.get(teamIndex).getMatchStats(Main.getTeamList().get(teamIndex).getMatches().get(matchIndex), Main.getTeamNumbers().get(teamIndex));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel messgeCenter;
    // End of variables declaration//GEN-END:variables
}
