package EaappPkg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class EappTestCases {
	WebDriver driver;
	String UserName;
	String Password;
	String confirmPassword;
	String Email;

	
	@Test
	public void LoginUser() {
	
		
	}
	
	//Expected = user should register with valid data..
	@Test()
  public void RegisterUser() {
	SoftAssert ObjSoftAssert = new SoftAssert(); 
	  driver.findElement(By.id("registerLink")).click();
	  
	  ObjSoftAssert.assertNotEquals("", UserName, "Username is Blank!!");
	  driver.findElement(By.id("UserName")).sendKeys(UserName);
	  
	  ObjSoftAssert.assertNotEquals("", Password, "Password is Blank!!");
	  driver.findElement(By.id("Password")).sendKeys(Password);
	  
	  ObjSoftAssert.assertNotEquals("", confirmPassword, "Confirm Password is Blank!!!");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
	  
	  driver.findElement(By.name("Email")).sendKeys(Email);
	  
	  driver.findElement(By.xpath("/html/body/div[2]/form/div[6]/div/input")).click();
	  
	  var IfRegister = driver.findElements(By.xpath("//*[@id=\"logoutForm\"]/ul/li[2]/a"));
	  
		//Expected = user should register with valid data..
	  
	  //Soft Assertion

	  
	  ObjSoftAssert.assertEquals(IfRegister.isEmpty(), false, "Log Off Button is not available!!!");
	  ObjSoftAssert.assertTrue(IfRegister.size()>0, "This Assertion is Fail!!!");
	  //Hard Assertion
/*	  assertTrue(IfRegister.size()>0);
	  assertFalse(IfRegister.size()==0);

	  assertEquals(IfRegister.isEmpty(), false);
	  assertEquals(IfRegister.size()==0, false);
*/
	  //Assertion
	  /*assertTrue(false)
	  assertFalse(false)
	  assertNotEquals(null, null)
	  assertEquals(false, false)
	  assertNotNull(Email)
	  assertNull(Email)
	  */
	  
	  
	  //assertTrue(!IfRegister.isEmpty());
	 
	  
	  if(!IfRegister.isEmpty())
	  {
		  IfRegister.get(0).click();
	  }

	  System.out.println("This is End of First Test Case");

	  ObjSoftAssert.assertAll("This Is asserting for all Soft Assertion");

  }
	
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://eaapp.somee.com/");
	  
	  UserName = "ERGTY100";
	  Password = "$aBC$123456$";
	  confirmPassword = "$aBC$123456$";
	  Email = "abcdRTYEFGHI12345658@gmail.com";
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
