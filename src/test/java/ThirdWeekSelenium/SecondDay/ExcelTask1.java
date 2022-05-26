package ThirdWeekSelenium.SecondDay;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelTask1 {
    @Test
    public void excel() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String filePath="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInp=new FileInputStream(filePath);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook  workbook= WorkbookFactory.create(fileInp);
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(4);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        System.out.println(cell);
    }
}
