import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor;

import com.cpjd.main.TBA;
import com.cpjd.models.teams.Team;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Labeler {

    private final static int ID_ROW = 0;
    private final static int NUMBER_COLUMN = 3;
    private final static int NAME_COLUMN = 4;

    private final static String AUTHTOKEN = "wi5cNwKSrOnIJeeePTFtd9fR82gDmRgPBZj7dQLwp169sMVnv1UYudtaLSxjxEKz";
    private final static String EVENTKEY = "2022migul";
    private final static String SCOUTINGFILEPATHNAME = "D:\\2022 Robotics\\2022 Scout Template.xls";
    public static void main(String[] args) throws Exception {
        TBA.setAuthToken(AUTHTOKEN);
        TBA tba = new TBA();
        Team[] teamList = tba.getEventTeams(EVENTKEY);

        File scoutingFile = null;
        FileInputStream inStream = null;
        try{
            scoutingFile = new File(SCOUTINGFILEPATHNAME);
            inStream = new FileInputStream(scoutingFile);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } 
        
        HSSFWorkbook workbook = new HSSFWorkbook(inStream);

        for(Team team : teamList){
            //System.out.println(team.getTeamNumber() + "  " + team.getNickname());
            HSSFSheet temp = workbook.cloneSheet(0);

            Row row = temp.createRow(ID_ROW);
            Cell name = row.createCell(NUMBER_COLUMN);
            Cell number = row.createCell(NAME_COLUMN);

            name.setCellValue(team.getNickname());
            number.setCellValue(team.getTeamNumber());
        } 

        try {
            FileOutputStream out =
                new FileOutputStream(scoutingFile);
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Excel written successfully..");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
