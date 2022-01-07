
import java.util.ArrayList;
import java.util.Collections;

import com.cpjd.main.TBA;
import com.cpjd.models.events.Event;
import com.cpjd.models.events.EventOPR;
import com.cpjd.models.teams.Team;


public class OPRAverager {

    private final static String AUTHTOKEN = "wi5cNwKSrOnIJeeePTFtd9fR82gDmRgPBZj7dQLwp169sMVnv1UYudtaLSxjxEKz";
    private final static String EVENTKEY = "2022miwmi";
    public static void main(String[] args) throws Exception {
        TBA.setAuthToken(AUTHTOKEN);
        TBA tba = new TBA();
        Team[] teamList = tba.getEventTeams(EVENTKEY);
        
        ArrayList<MyTeam> teams = new ArrayList<>();
        
        
        for(Team team : teamList){
            double avg = 0;
            int eventCount = 0;
            try{
                Event[] events = tba.getTeamEvents((int)team.getTeamNumber());
                for(Event event : events){
                    if(event.getYear() == 2019){
                        //System.out.println(event.getName() + "   " + event.getYear());
                        try{
                            EventOPR[] OPRs = tba.getOprs(event.getKey());
                            for (EventOPR opr : OPRs) {
                                if(opr.getTeamKey().equals(team.getKey())){
                                    //System.out.println(opr.getOpr());
                                    avg += opr.getOpr();
                                    eventCount++;
                                }   
                            }
                        }catch(NullPointerException e){
    
                        }
                        
                    }
                }
                avg /= (double)eventCount;
                //System.out.println(team.getTeamNumber() + "  " + avg);
                teams.add(new MyTeam((int)team.getTeamNumber(), avg));
            }catch(Exception e){
                teams.add(new MyTeam((int)team.getTeamNumber(), 0));
            }
        }

        Collections.sort(teams);

        for(MyTeam team : teams){System.out.println(team.getNumber() + "  " + team.getOpr());}
    }
}

class MyTeam implements Comparable<MyTeam>{

    public int number;
    public double opr;

    public MyTeam(int number, double opr){
        this.number = number;
        this.opr = opr;
    }

    public int getNumber() {
        return number;
    }

    public double getOpr() {
        return opr;
    }

    public int compareTo(MyTeam anotherInstance) {
        return (anotherInstance.getOpr() >= this.getOpr()) ? 1 : -1;
    }
}
