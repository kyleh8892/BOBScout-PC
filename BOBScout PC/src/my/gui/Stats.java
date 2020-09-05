/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gui;

import bobscout.pc.MatchData;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kyleh
 */
public class Stats extends javax.swing.JPanel {
    
    boolean average = true;
    
    int colorTransition = 85;
    
    double matches = 0;
    int matchNumber = 0;
    int team = 0;
    
    int autoInnerValue = 0;
    int autoOuterValue = 0;
    int autoLowerValue = 0;
    int autoCollectedValue = 0;
    int autoMissedValue = 0;
    int autoLineValue = 0;

    int teleopInnerValue = 0;
    int teleopOuterValue = 0;
    int teleopLowerValue = 0;
    int teleopMissedValue = 0;
    
    int endHangValue = 0;
    int endParkValue = 0;
    int endDoubleValue = 0;
    int endTripleValue = 0;
    int endLevelValue = 0;
    /**
     * Creates new form AverageStats
     */
    public Stats() {
        initComponents();
    }
    
    public void getAverageStats(ArrayList<MatchData> matches, int teamNumber){
        resetData();
        team = teamNumber;
        average = true;
        
        for(MatchData match : matches){
            autoInnerValue += match.getAutoInnerPortShots();
            autoOuterValue += match.getAutoOuterPortShots();
            autoLowerValue += match.getAutoLowerPortShots();
            autoCollectedValue += match.getAutoCellsColleced();
            autoMissedValue += match.getAutoShotsMissed();
            autoLineValue += (match.getAutoLine()) ? 1 : 0;
            
            teleopInnerValue += match.getDriverInnerPortShots();
            teleopOuterValue += match.getDriverOuterPortShots();
            teleopLowerValue += match.getDriverLowerPortShots();
            teleopMissedValue += match.getDriverShotsMissed();
            
            endHangValue += (match.getEndHang()) ? 1 : 0;
            endParkValue += (match.getEndPark()) ? 1 : 0;
            endDoubleValue += (match.getEndHangDouble()) ? 1 : 0;
            endTripleValue += (match.getEndHangTriple()) ? 1 : 0;
            endLevelValue += (match.getEndHangLevel()) ? 1 : 0;
            
        }
        
        this.matches = matches.size();
        
        update();
    }
    
    public void getMatchStats(MatchData match, int teamNumber){
        resetData();
        team = teamNumber;
        average = false;
        
        autoInnerValue = match.getAutoInnerPortShots();
        autoOuterValue = match.getAutoOuterPortShots();
        autoLowerValue = match.getAutoLowerPortShots();
        autoCollectedValue = match.getAutoCellsColleced();
        autoMissedValue = match.getAutoShotsMissed();
        autoLineValue = (match.getAutoLine()) ? 1 : 0;

        teleopInnerValue = match.getDriverInnerPortShots();
        teleopOuterValue = match.getDriverOuterPortShots();
        teleopLowerValue = match.getDriverLowerPortShots();
        teleopMissedValue = match.getDriverShotsMissed();

        endHangValue = (match.getEndHang()) ? 1 : 0;
        endParkValue = (match.getEndPark()) ? 1 : 0;
        endDoubleValue = (match.getEndHangDouble()) ? 1 : 0;
        endTripleValue = (match.getEndHangTriple()) ? 1 : 0;
        endLevelValue = (match.getEndHangLevel()) ? 1 : 0;
        
        matchNumber = match.getMatchNumber();
        
        update();
    }
    
    private void update(){
        resetColor();
        
        if(average){
            if(matches > 0){
                autoInner.setText(String.format("%2.1f", autoInnerValue/matches));
                autoOuter.setText(String.format("%2.1f", autoOuterValue/matches));
                autoLower.setText(String.format("%2.1f", autoLowerValue/matches));
                autoCollected.setText(String.format("%2.1f", autoCollectedValue/matches));
                autoMade.setText(String.format("%3.0f", ((autoInnerValue + autoOuterValue + autoLowerValue)/(double)autoMissedValue) * 100));
                applyColor(autoMade);
                autoLine.setText(String.format("%3.0f", (autoLineValue/matches)*100));
                applyColor(autoLine);

                teleopInner.setText(String.format("%2.1f", teleopInnerValue/matches));
                teleopOuter.setText(String.format("%2.1f", teleopOuterValue/matches));
                teleopLower.setText(String.format("%2.1f", teleopLowerValue/matches));
                teleopMade.setText(String.format("%3.0f", ((teleopInnerValue + teleopOuterValue + teleopLowerValue)/(double)teleopMissedValue) * 100));
                applyColor(teleopMade);

                endHang.setText(String.format("%3.0f", (endHangValue/matches)*100));
                applyColor(endHang);
                endPark.setText(String.format("%3.0f", (endParkValue/matches)*100));
                //applyColor(endPark);
                endDouble.setText(String.format("%3.0f", (endDoubleValue/matches)*100));
                //applyColor(endDouble);
                endTriple.setText(String.format("%3.0f", (endTripleValue/matches)*100));
                //applyColor(endTriple);
                endLevel.setText(String.format("%3.0f", (endLevelValue/matches)*100));
                //applyColor(endLevel);
                
                setAverageLabels();
            }
        }else{
            autoInner.setText(String.format("%2d", autoInnerValue));
            autoOuter.setText(String.format("%2d", autoOuterValue));
            autoLower.setText(String.format("%2d", autoLowerValue));
            autoCollected.setText(String.format("%2d", autoCollectedValue));
            autoMade.setText(String.format("%3.0f", ((autoInnerValue + autoOuterValue + autoLowerValue)/(double)autoMissedValue) * 100));
            applyColor(autoMade);
            autoLine.setText(String.format("%3s", (autoLineValue > 1) ? "Yes" : "No"));
            applyColor(autoLine);

            teleopInner.setText(String.format("%2d", teleopInnerValue));
            teleopOuter.setText(String.format("%2d", teleopOuterValue));
            teleopLower.setText(String.format("%2d", teleopLowerValue));
            teleopMade.setText(String.format("%3.0f", ((teleopInnerValue + teleopOuterValue + teleopLowerValue)/(double)teleopMissedValue) * 100));
            applyColor(teleopMade);

            endHang.setText(String.format("%3s", (endHangValue > 1) ? "Yes" : "No"));
            applyColor(endHang);
            endPark.setText(String.format("%3s", (endParkValue > 1) ? "Yes" : "No"));
            if(endHang.getText().equals("No")){applyColor(endPark);}
            endDouble.setText(String.format("%3s", (endDoubleValue > 1) ? "Yes" : "No"));
            //applyColor(endDouble);
            endTriple.setText(String.format("%3s", (endTripleValue > 1) ? "Yes" : "No"));
            //applyColor(endTriple);
            endLevel.setText(String.format("%3s", (endLevelValue > 1) ? "Yes" : "No"));
            applyColor(endLevel);
            
            setMatchLabels();
        }
        
    }
    
    private void setMatchLabels(){
        title.setText("Match " + matchNumber + " Stats");
        hangLabel.setText("Hang:");
        doubleLabel.setText("Double:");
        tripleLabel.setText("Triple:");
        parkLabel.setText("Park:");
        levelLabel.setText("Level:");
    }
    
    private void setAverageLabels(){
        title.setText("Team " + team + " Average Stats");
        hangLabel.setText("%Hang:");
        doubleLabel.setText("%Double:");
        tripleLabel.setText("%Triple:");
        parkLabel.setText("%Park:");
        levelLabel.setText("%Level:");
    }
    
    private void resetData(){
        matches = 0;

        autoInnerValue = 0;
        autoOuterValue = 0;
        autoLowerValue = 0;
        autoCollectedValue = 0;
        autoMissedValue = 0;
        autoLineValue = 0;

        teleopInnerValue = 0;
        teleopOuterValue = 0;
        teleopLowerValue = 0;
        teleopMissedValue = 0;

        endHangValue = 0;
        endParkValue = 0;
        endDoubleValue = 0;
        endTripleValue = 0;
        endLevelValue = 0;
        
    }
    
    private void resetColor(){
        autoMade.setForeground(Color.BLACK);
        autoLine.setForeground(Color.BLACK);
        
        teleopMade.setForeground(Color.BLACK);
        
        endHang.setForeground(Color.BLACK);
        endPark.setForeground(Color.BLACK);
        endLevel.setForeground(Color.BLACK);
    }
    
    private void applyColor(javax.swing.JLabel label){ //Exists to catch any exceptions like NaN and not being able to parse an int 
        try{
            label.setForeground((Integer.parseInt(label.getText()) >= colorTransition) ? Color.BLUE : Color.RED);
        }catch(NumberFormatException e){
            label.setForeground(label.getText().equals("Yes") ? Color.BLUE : Color.RED);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        averageStats = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        autoMade = new javax.swing.JLabel();
        autoLine = new javax.swing.JLabel();
        autoInner = new javax.swing.JLabel();
        autoOuter = new javax.swing.JLabel();
        autoLower = new javax.swing.JLabel();
        autoCollected = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        teleopMade = new javax.swing.JLabel();
        teleopInner = new javax.swing.JLabel();
        teleopOuter = new javax.swing.JLabel();
        teleopLower = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        hangLabel = new javax.swing.JLabel();
        parkLabel = new javax.swing.JLabel();
        endHang = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        endLevel = new javax.swing.JLabel();
        doubleLabel = new javax.swing.JLabel();
        tripleLabel = new javax.swing.JLabel();
        endDouble = new javax.swing.JLabel();
        endPark = new javax.swing.JLabel();
        endTriple = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(260, 260));

        averageStats.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Average Stats:");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Auto"));

        jLabel3.setText("Inner:");

        jLabel4.setText("Outer:");

        jLabel5.setText("Lower:");

        jLabel6.setText("Collected:");

        jLabel11.setText("% Made:");

        jLabel12.setText("% Line:");

        autoMade.setText("###");

        autoLine.setText("###");

        autoInner.setText("##");

        autoOuter.setText("##");

        autoLower.setText("##");

        autoCollected.setText("##");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(autoOuter)
                    .addComponent(autoInner))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(autoCollected)
                    .addComponent(autoLower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(autoMade)
                    .addComponent(autoLine, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addGap(20, 20, 20))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(autoLower)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(autoCollected))))
            .addComponent(jLabel3)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(autoInner)
                    .addGap(20, 20, 20))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(autoMade))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(autoLine)
                        .addComponent(jLabel4)
                        .addComponent(autoOuter))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tele-op"));

        jLabel16.setText("Inner:");

        jLabel17.setText("Outer:");

        jLabel18.setText("Lower:");

        jLabel20.setText("% Made:");

        teleopMade.setText("###");

        teleopInner.setText("##");

        teleopOuter.setText("##");

        teleopLower.setText("##");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(teleopOuter)
                    .addComponent(teleopInner))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(teleopLower)
                    .addComponent(teleopMade))
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18)
            .addComponent(teleopLower)
            .addComponent(jLabel16)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(teleopInner)
                    .addGap(20, 20, 20))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(teleopOuter)
                    .addComponent(jLabel20)
                    .addComponent(teleopMade)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("End"));

        hangLabel.setText("% Hang:");

        parkLabel.setText("% Park:");

        endHang.setText("###");

        levelLabel.setText("% Level:");

        endLevel.setText("###");

        doubleLabel.setText("% Double:");

        tripleLabel.setText("% Triple:");

        endDouble.setText("###");

        endPark.setText("###");

        endTriple.setText("###");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hangLabel)
                    .addComponent(levelLabel)
                    .addComponent(doubleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(endHang)
                    .addComponent(endLevel)
                    .addComponent(endDouble))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parkLabel)
                    .addComponent(tripleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endPark)
                    .addComponent(endTriple))
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hangLabel)
                    .addComponent(parkLabel)
                    .addComponent(endHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelLabel)
                    .addComponent(endLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doubleLabel)
                    .addComponent(tripleLabel)
                    .addComponent(endDouble)
                    .addComponent(endTriple)))
            .addComponent(endPark)
        );

        javax.swing.GroupLayout averageStatsLayout = new javax.swing.GroupLayout(averageStats);
        averageStats.setLayout(averageStatsLayout);
        averageStatsLayout.setHorizontalGroup(
            averageStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, averageStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(averageStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        averageStatsLayout.setVerticalGroup(
            averageStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, averageStatsLayout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(averageStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(averageStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autoCollected;
    private javax.swing.JLabel autoInner;
    private javax.swing.JLabel autoLine;
    private javax.swing.JLabel autoLower;
    private javax.swing.JLabel autoMade;
    private javax.swing.JLabel autoOuter;
    private javax.swing.JPanel averageStats;
    private javax.swing.JLabel doubleLabel;
    private javax.swing.JLabel endDouble;
    private javax.swing.JLabel endHang;
    private javax.swing.JLabel endLevel;
    private javax.swing.JLabel endPark;
    private javax.swing.JLabel endTriple;
    private javax.swing.JLabel hangLabel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel parkLabel;
    private javax.swing.JLabel teleopInner;
    private javax.swing.JLabel teleopLower;
    private javax.swing.JLabel teleopMade;
    private javax.swing.JLabel teleopOuter;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tripleLabel;
    // End of variables declaration//GEN-END:variables
}
