package com.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorOperations {

	//Initiate webdriver interface
	static WebDriver driver;

	//Generic method to send values for textfields
	public static void values(String value1,String value2,String symbol)
	{
		driver.findElement(By.xpath("//input[@ng-model='first']")).sendKeys(value1);
		driver.findElement(By.xpath("//input[@ng-model='second']")).sendKeys(value2);
		driver.findElement(By.xpath("//option[.='"+symbol+"']"));
		System.out.println("values are "+value1+" and "+value2);
		System.out.print("Result of "+value1+symbol+value2);
	}

	//Generic method to select operation
	public static void operators(String element)
	{
		driver.findElement(By.xpath("//select[@ng-model=\"operator\"]")).click();
		driver.findElement(By.xpath("//option[@value='"+element+"']")).click();
		System.out.println("Selected "+element+" operator");
		System.out.println("Performing "+element);
	}

	//Generic method to click on go button
	public static void clickOnGo()
	{
		//click on go button
		driver.findElement(By.id("gobutton")).click();

		//using thread to wait, instead we can also use implicitly and explicitly wait
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Storing result and printing it
		String result=driver.findElement(By.xpath("(//td[@class='ng-binding'])[2]")).getText();
		System.out.println(" is "+result);
		System.out.println();

	}

	public static void main(String[] args) 
	{
		//create object of chrome driver
		driver=new ChromeDriver();

		//maximize browser window
		driver.manage().window().maximize();

		//navigate to url
		driver.get("https://juliemr.github.io/protractor-demo/");

		//Perform addition
		operators("ADDITION");
		values("1","2","+");
		clickOnGo();

		//Perform substraction
		operators("SUBTRACTION");
		values("5","2","-");
		clickOnGo();

		//Perform division
		operators("DIVISION");
		values("6","2","/");
		clickOnGo();

		//Perform multiplication
		operators("MULTIPLICATION");
		values("5","2","*");
		clickOnGo();

		//Perform modulo
		operators("MODULO");
		values("10","2","%");
		clickOnGo();

		//To close the browser window
		driver.close();

	}

}
