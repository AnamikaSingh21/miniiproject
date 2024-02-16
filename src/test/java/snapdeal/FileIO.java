package snapdeal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileIO {
      
  static WebDriver driver;
  static List<WebElement> listt;
  static List<WebElement>price;
 
  
	 //constructor of FileIO class
	 public FileIO(WebDriver driver2, List<WebElement> listt, List<WebElement>pricee) {
		 this.driver=driver2;
		 this.listt=listt;
		 this.price=pricee;
    }

	//Writing data in excel file
	public static void writeData() throws IOException {
	 
	 FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src/main/resources\\testdata\\testdat.xlsx");
	 
	 
	 XSSFWorkbook workbook = new XSSFWorkbook();
	 
	 XSSFSheet sheet = workbook.createSheet();{
	 
	 for(int i=0; i<5; i++) {
		 XSSFRow row = sheet.createRow(i);
		 String s1= listt.get(i).getText();
		 String s2= price.get(i).getText();
		 for(int j=0; j<2; j++) {
			 if(j==0) {
			 row.createCell(j).setCellValue(s1);
			 }
		 else 
			 {
				 row.createCell(j).setCellValue(s2);
			 }
			 
		 }
		 
	 }	
	 }
	 
	 workbook.write(file);
	 workbook.close();
	 file.close();
	 }
	 	
	 //Reading data from excel file
	 public static String readData() throws IOException {
		 
		 String file1=System.getProperty("user.dir")+"\\src/main/resources\\testdata\\testdata.xlsx";
		 FileInputStream file2= new FileInputStream(file1);
		 
		 XSSFWorkbook wb=new XSSFWorkbook(file2);
		 XSSFSheet sh =wb.getSheet("sheet1");
		 
		 XSSFRow row= sh.getRow(1);
		 String value= row.getCell(0).toString();
		 
		
		 wb.close();
		 file2.close();
		 return value;
		 
	 }
    }




