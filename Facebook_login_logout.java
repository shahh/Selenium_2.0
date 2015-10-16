import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

public class Facebook_login_logout {

	public static void main(String[] args) throws InterruptedException {
		String UserID; 
		String Password;
		String Address;
		String Location;
		
		Scanner input=new Scanner(System.in);
		
		//	Location=input.nextLine();
		//System.out.print("Enter the location address of the browser executable file: ");
		
		System.out.print("Enter the webaddress you want to visit: ");
		Address=input.nextLine();
		
		System.out.print("Enter your Username: ");
		UserID=input.nextLine();
	
		System.out.print("Enter your Password: ");
		Password=input.nextLine();
	
		
		// Sets the path for the firefox driver
		System.setProperty("webdriver.Firefox.driver", "C:\\Users\\Shah Zaib\\Downloads\\Compressed\\firefox.exe");
		// Creates a driver object for firefox
		WebDriver driver_xpath = new FirefoxDriver();

		// Goto page
		driver_xpath.get(Address);
		// email box-->email address-->click
		driver_xpath.findElement(By.xpath(".//*[@id='email']")).sendKeys(UserID);
		// password box-->password-->click
		driver_xpath.findElement(By.xpath(".//*[@id='pass']")).sendKeys(Password);
		// login button-->click
		driver_xpath.findElement(By.xpath(".//*[@id='loginbutton']")).click();
		// Navigation drop button-->click
		driver_xpath.findElement(By.xpath(".//*[@id='userNavigationLabel']")).click();
		//Waits for the drop down menu to show
		driver_xpath.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// logout button-->click
		driver_xpath.findElement(By.xpath("//li[12]/a/span/span")).click();
		//Close
		driver_xpath.close();

		WebDriver driver_CSS = new FirefoxDriver();
		// Goto page
		driver_CSS.get(Address);
		// email box-->email address-->click
		driver_CSS.findElement(By.cssSelector("input[id='email']")).sendKeys(UserID);
		// password box-->password-->click
		driver_CSS.findElement(By.cssSelector("input[id='pass']")).sendKeys(Password);
		// Click on the checkbox "Keep me logged in"
		driver_CSS.findElement(By.cssSelector("input[id='persist_box']")).click();
		// login button-->click
		driver_CSS.findElement(By.cssSelector("input[value='Log In']")).click();
		// Navigation drop button-->click
		driver_CSS.findElement(By.cssSelector("div[id='userNavigationLabel']")).click();
		//Waits for the drop down menu to show
		driver_CSS.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// (Not in english) usernavigation block jaha logout hay us main 16 li k blocks hain ,  logout wala 12 main hay , kholo to a aata hay , phir 2 span span aatay hay , yeh address hay button ka
		// logout button-->click
		driver_CSS.findElement(By.xpath("//li[12]/a/span/span")).click();
		//Close
		driver_CSS.close();

	}

}
