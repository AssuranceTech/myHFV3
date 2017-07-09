package com.org.myHFV3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAppFuncLib {
	
	
	public static void executeFlow(WebDriver driver, String flowName, String testData1, String testData2 ) {		
		
		
		if (flowName.equals("OpenBrowser")) {
						
			driver.get(testData1);
			
		} 
		else if (flowName.equals("ClickLink")) {   				
			System.out.println(testData1);	        	        
	        driver.findElement(By.xpath(testData1)).click();  
	        driver.manage().timeouts().implicitlyWait(4500, TimeUnit.SECONDS);	
		}
		else if (flowName.equals("PopulateText")) {   				
			System.out.println(testData1);
			System.out.println(testData2);
			driver.findElement(By.xpath (testData1)).sendKeys(testData2);	       
			
	        //driver.manage().timeouts().implicitlyWait(4500, TimeUnit.SECONDS);
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (flowName.equals("clickButton")) { 
			System.out.println(testData1);
			driver.findElement(By.xpath(testData1)).click(); 
		}
	}


}
