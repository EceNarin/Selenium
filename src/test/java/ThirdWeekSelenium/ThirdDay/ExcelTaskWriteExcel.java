package ThirdWeekSelenium.ThirdDay;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTaskWriteExcel {
    @Test
    public void WriteExcelTest() throws IOException {
        //3)  Adimlari takip ederek 1.satira kadar gidelim
        String filePath="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fis);
        //4)  4.hucreye yeni bir cell structuralism
        Cell newCell=workbook.getSheet("Sayfa1").createRow(0).createCell(4);
        //5)  Olusturdugumuz hucreye “Nufus” yazdiralim
        newCell.setCellValue("Nüfus");
        String cellName= newCell.getStringCellValue();
        System.out.println(cellName);
        //6)  2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").createRow(1).createCell(4).setCellValue(1500000);
        //7)  10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").createRow(9).createCell(4).setCellValue(250000);
        //8)  15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").createRow(14).createCell(4).setCellValue(54000);
        //9)  Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(filePath);
        workbook.write(fos);
        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(4));
        //10) Dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();
    }


}
