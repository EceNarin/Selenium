package ThirdWeekSelenium.SecondDay;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelBasicSample {
    @Test
    public void test() throws IOException {
        //print eng countries column
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook   workbook= WorkbookFactory.create(fis);
        ExcelSample method=new ExcelSample();
        int rowLength=workbook.getSheet("Sayfa1").getLastRowNum()+1;
        List<String> engCities=new ArrayList<>();
        for(int i=0;i<rowLength;i++){
            engCities.add(method.cellToString(i,0));
        }
        engCities.stream().forEach(t-> System.out.print(t +"  "));

    }
}
