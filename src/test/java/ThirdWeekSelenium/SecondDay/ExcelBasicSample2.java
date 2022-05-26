package ThirdWeekSelenium.SecondDay;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelBasicSample2 extends ExcelSample{
    @Test
    public void test() throws IOException {
        //copy all excel data's in the excel and store in java object (Map)
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
        //Map<String,String> excelData=new HashMap<>();
        Map<List<String>, List<String>> excelData = new HashMap<>();

        int rowNum= workbook.getSheet("Sayfa1").getLastRowNum();
        List<String> capitalRng=new ArrayList<>();
        List<String> capitalTurkish=new ArrayList<>();
        List<String> cityTurkish=new ArrayList<>();
        List<String> Key=new ArrayList<>();
        for(int i=0;i<rowNum;i++){
            capitalRng.add(cellToString(i,1));
        }
        for(int i=0;i<rowNum;i++){
            Key.add(cellToString(i,0));
        }
        for(int i=0;i<rowNum;i++){
            capitalTurkish.add(cellToString(i,2));
        }
        for(int i=0;i<rowNum;i++){
            cityTurkish.add(cellToString(i,3));
        }
      capitalRng.addAll(capitalTurkish);
      capitalRng.addAll(cityTurkish);
      capitalRng.stream().forEach(t-> System.out.println(t));
      System.out.println(capitalRng.size());
    }
}
