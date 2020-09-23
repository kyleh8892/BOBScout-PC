/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobscout.pc;

/**
 *
 * @author kyleh
 */
public class MatchData {
    
    private int matchNumber;
    
    private int driverInnerPortShots;
    private int driverOuterPortShots;
    private int driverLowerPortShots;
    
    private int driverShotsMissed;
    
    private int autoInnerPortShots;
    private int autoOuterPortShots;
    private int autoLowerPortShots;
    
    private int autoShotsMissed;
    private int autoCellsCollected;
    
    private boolean autoLine;
    
    private boolean endHang;
    private boolean endHangDouble;
    private boolean endHangTriple;
    
    private boolean endHangLevel;
    
    private boolean endPark;
    
    int[] cell;
    boolean[]bool;
    
    public MatchData (int number, int[] cellData, boolean[] boolData){
        cell = cellData;
        bool = boolData;
        
        matchNumber = number;
        
        driverInnerPortShots = cellData[0];
        driverOuterPortShots = cellData[1];
        driverLowerPortShots = cellData[2];
        
        driverShotsMissed = cellData[3];
    
        autoInnerPortShots = cellData[4];
        autoOuterPortShots = cellData[5];
        autoLowerPortShots = cellData[6];

        autoShotsMissed = cellData[7];
        autoCellsCollected = cellData[8];
        
        autoLine = boolData[0];
        
        endHang = boolData[1];
        endHangDouble = boolData[2];
        endHangTriple = boolData[3];

        endHangLevel = boolData[4];

        endPark = boolData[5];
    }
    
    public int getMatchNumber(){return matchNumber;}
    
    public int getDriverInnerPortShots(){return driverInnerPortShots;}
    public int getDriverOuterPortShots(){return driverOuterPortShots;}
    public int getDriverLowerPortShots(){return driverLowerPortShots;}
    
    public int getDriverShotsMissed(){return driverShotsMissed;}
    
    public int getAutoInnerPortShots(){return autoInnerPortShots;}
    public int getAutoOuterPortShots(){return autoOuterPortShots;}
    public int getAutoLowerPortShots(){return autoLowerPortShots;}
    
    public int getAutoShotsMissed(){return autoShotsMissed;}
    public int getAutoCellsColleced() {return autoCellsCollected;}
    
    public boolean getAutoLine() {return autoLine;}
    
    public boolean getEndHang() {return endHang;}
    public boolean getEndHangDouble() {return endHangDouble;}
    public boolean getEndHangTriple() {return endHangTriple;}
    
    public boolean getEndHangLevel() {return endHangLevel;}
    
    public boolean getEndPark() {return endPark;}
    
    public int getPower(){
        int power = 0;
        
        for (int i : cell) {
            power += i;
        }
        
        for (boolean i : bool) {
            power += Integer.parseInt(String.valueOf(i)) * 5;
        }
        return power;
    }
    
    @Override
    public String toString(){
        String output = "";
        
        output += matchNumber + "," + driverInnerPortShots + "," + driverOuterPortShots + "," + driverLowerPortShots + "," + driverShotsMissed + ","; //Teleop data
        output += autoInnerPortShots + "," + autoOuterPortShots + "," + autoLowerPortShots + "," + autoShotsMissed + "," + autoCellsCollected + "," + autoLine + ","; //Auto data
        output += endHang + "," + endHangDouble + "," + endHangTriple + "," + endHangLevel + "," + endPark; //End data
        
        return output;
    }
    
}
