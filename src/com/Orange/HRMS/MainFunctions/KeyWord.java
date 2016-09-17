package com.Orange.HRMS.MainFunctions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class KeyWord
{
  /* public static void ExecuteKeyWord(WebDriver driver,String Action, String ElementRepo, String input )
   {
	   if(Action.equalsIgnoreCase("Enter"))
	   {
		   driver.findElement(By.xpath(ElementRepo)).sendKeys(input);
	   }
	   else if(Action.equalsIgnoreCase("Click"))
	   {
		   driver.findElement(By.xpath(ElementRepo)).click();
	   }
	   else
	   {
		   System.out.println("invalid action"+Action);
	   }
   } */
   
   
   
   public static void ExecuteKeyWord(WebDriver driver, String Action, String ElementRepo, String input) throws InterruptedException
   {
	   if(Action.equalsIgnoreCase("Enter"))
	   {
		   driver.findElement(Locator.getLocator(ElementRepo)).clear();	
		   driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
	   }
	   else if(Action.equalsIgnoreCase("Click"))
	   {
		   Thread.sleep(2000);
		   driver.findElement(Locator.getLocator(ElementRepo)).click();
		   
		   try{
		Alert alert =driver.switchTo().alert();
		alert.accept();
		   }
		   catch(Exception e)
		   {
			   System.out.println("alert not present");
		   }
		
					
		   //System.out.println("");
	   }
	   else if(Action.equalsIgnoreCase("Select"))
	   {
		   WebElement WeblistEle = driver.findElement(Locator.getLocator(ElementRepo));
		   Select select = new Select(WeblistEle);
		   select.selectByVisibleText(input);
		   System.out.println("Selected value is  : " + input);
	   }
	   else if(Action.equalsIgnoreCase("Calender Check"))
	   {
		   WebElement weblist = driver.findElement(Locator.getLocator(ElementRepo));
		   Select select = new Select(weblist);
		   String weblistText = select.getFirstSelectedOption().getText();
		   if(weblistText.contains(input))
		   {
			   System.out.println("Current Month is:  " + input);
		   }
		   else
		   {
			   System.out.println("Calender doesn't display : " + input + "Month");
			   select.selectByVisibleText(input);
			   System.out.println("Current Month Selected is : " + input);
		   }
	   }
	    else if(Action.equalsIgnoreCase("GetText"))
	   {
		   String text = driver.findElement(Locator.getLocator(ElementRepo)).getText();
		   System.out.println("Link text value is " + text);
	   } 
	    else if(Action.equalsIgnoreCase("IsExist"))
	    {
	    	Thread.sleep(2000);
	    	if(driver.findElement(Locator.getLocator(ElementRepo)).isDisplayed())
	    	{
	    		Thread.sleep(2000);
	    	System.out.println("Element is present :::::"  + input);
	        }
	    	Thread.sleep(2000);
	    }
	    else if(Action.equalsIgnoreCase("upload"))
	    {
	    	System.out.println(driver.getTitle());
	    	
	    	Thread.sleep(2000);
	    	driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
	    	System.out.println("Photo has been Uploaded");
	    }
	   else
	   {
		   System.out.println("invalid action"+Action);
	   }
}
}
