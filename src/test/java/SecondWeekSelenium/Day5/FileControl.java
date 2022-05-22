package SecondWeekSelenium.Day5;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class FileControl {
    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir")); //C:\Users\himer\IdeaProjects\NewProjectJUnit
        //C:\Users\himer\IdeaProjects\NewProjectJUnit it is comes from our staying file path
        System.out.println(System.getProperty("user.home")); //C:\Users\himer
        //get to us pc specific place
        String filePathh=System.getProperty("user.home") + "\\Masaüstü\\jyjyjy.txt";
        System.out.println(System.getProperty("user.home"  +"\\IdeaProjects\\NewProjectJUnit\\src\\test\\java\\SecondWeekSelenium\\Day1\\DropDownSample.java"));
        System.out.println(System.getProperty("user.home") + "\\Masaüstü\\kendim");
        System.out.println(filePathh);
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\himer\\OneDrive\\Masaüstü\\ece")));
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\himer\\IdeaProjects\\NewProjectJUnit\\src\\test\\java\\SecondWeekSelenium\\Day1\\DropDownSample.java")));
        System.out.println(Files.exists(Paths.get("C:\\Users\\himer\\IdeaProjects\\NewProjectJUnit\\src\\test\\java\\SecondWeekSelenium\\Day1\\DropDownSample.java")));
    }
}
