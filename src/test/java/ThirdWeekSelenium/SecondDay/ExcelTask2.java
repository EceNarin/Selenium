package ThirdWeekSelenium.SecondDay;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelTask2 {
    Workbook workbook;
    List<String> arr=new ArrayList<>();
    @Test
    public void excel() throws IOException {
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(filePath);
        workbook= WorkbookFactory.create(fis);
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //1+1==2 excate satir 2+1 ==3 excat cell
        String FirstRowSecondCell=findCell(1,2);
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actual=findCell(2,4);
        String expected="kabil";
        Assert.assertTrue(expected.equalsIgnoreCase(actual));
        //- Satir sayisini bulalim
        int rowNums=workbook.getSheet("Sayfa1").getLastRowNum();
        //- Fiziki olarak kullanilan satir sayisini bulun
        int realRownum=workbook.getSheet("Sayfa1").getLastRowNum()-1;
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
       // listOfExcel(realRownum);
        //Object ArrayList;
        //Map(ArrayList<String> arr,ArrayList<String>)
    }

      private ArrayList<String> listOfExcel(int row) {
          for(int i=0;i<row;i++){
            arr.add(workbook.getSheet("Sayfa1").getRow(1).getCell(i).toString());
        }
        return (ArrayList<String>) arr;
    }


    private String findCell(int x, int y) {
        return workbook.getSheet("Sayfa1").getRow(x-1).getCell(y-1).toString();
    }
}
