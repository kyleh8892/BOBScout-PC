import java.io.File;
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

public class App {
    public static void main(String[] args) throws Exception {
        TBA.setAuthToken("wi5cNwKSrOnIJeeePTFtd9fR82gDmRgPBZj7dQLwp169sMVnv1UYudtaLSxjxEKz");
        TBA tba = new TBA();
        Team[] teamList = tba.getEventTeams("2022migul");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

        for(Team team : teamList){
            System.out.println(team.getTeamNumber() + "  " + team.getNickname());
            HSSFSheet temp = workbook.cloneSheet(0);

            Row row = temp.createRow(0);
            Cell name = row.createCell(3);
            Cell number = row.createCell(4);

            name.setCellValue(team.getNickname());
            number.setCellValue(team.getTeamNumber());
        } 

        try {
            FileOutputStream out =
                new FileOutputStream(new File("D:\\2022 Robotics\\new.xls"));
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
