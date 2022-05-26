package ThirdWeekSelenium.SecondDay;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.ShortSeqHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelSample {
    @Test
    public void test() throws IOException {
        int x = 0,y = 0;
        //input olarak verilen satirNo,sutunno degelerini parametre olarak alip o cell'deki datalari String olarak donduren bir method yap
        cellToString(x,y);// x-1 y-1 seklinde yapalim 0'dan index basladıgı icin
        String expected="her neyse";
        Assert.assertEquals(expected,cellToString(x,y));
    }

    public String cellToString(int x, int y) throws IOException {
        String file="src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(file);
        Workbook workbook= WorkbookFactory.create(fis);
        return workbook.getSheet("Sayfa1").getRow(x).getCell(y).toString();
         //cell.toString();
    }
}
