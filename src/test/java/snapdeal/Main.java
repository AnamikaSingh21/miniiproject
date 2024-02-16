package snapdeal;

import java.io.IOException;
import java.util.Scanner;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.WebElement;

public class Main {
 
public static void main(String[] args) throws IOException {

     String z;
     Scanner sc = new Scanner(System.in);
     Implementation implementation = new Implementation();
     
     //for selecting the browser
     
     System.out.println("Enter 1 for Chrome \nEnter 2 for Edge"); 
     int ch = sc.nextInt(); 
     Implementation.createDriver(ch);

    try {
    	
    //launch Browser
    	
    implementation.openBrowser();
    
    //Taking screenshot of screen after opening Browser
    
    Implementation.fullScreenShot1("pagename.png");
    
    try {
    	
     //Reading data from excel file
    	
     z= FileIO.readData();
     
     //Searching Bluethooth devices on snapdeal
     
     Implementation.searchElement(z) ;
     
     }
    
    catch(Exception e) {
    }
     //Sorted the Bluetooth devices by popularity
    
    Implementation.sortByPopularity();
    
    //Set the price of Bluetooth devices as instructed
    
    Implementation.setPrice();
    Thread.sleep(5000);
    
    //Getting first five element and printing it in consol
    
    Implementation.getFirstFiveElement();
    Thread.sleep(5000);
    
    //Taking Screenshot after getting first five element
    Implementation.fullScreenShot1("page.png");
    Implementation.screenShot();
    Implementation.apachi();
    
    // Writing data in Excel file
    FileIO.writeData();
    }
    
    catch (InterruptedException  e) {
    e.printStackTrace();
    }
    Implementation.closeBrowser();
    }

    }

