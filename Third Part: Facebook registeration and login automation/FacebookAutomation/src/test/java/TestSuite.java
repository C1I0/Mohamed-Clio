//import org.junit.Test;
import Web.Registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Web.*;
import java.io.IOException;

public class TestSuite {
    // define the chrome driver and filename
   WebDriver driver = new ChromeDriver();
   String fileName = "TestData.csv";
   // access the chrome driver
   @BeforeSuite
    public static void main(String [] args){
    System.setProperty("webdriver.chrome.driver","chromedriver");
   }
   // register to facebook test case
   @Test(testName = "Register on Facebook")
   public void registerOnFacebook() throws IOException {
    driver.get("https://web.facebook.com/?_rdc=1&_rdr");
    Web.Registration registration = new Registration();
    if (registration.registerUser(fileName , driver) == true){
        System.out.println("User successfully Registered ");
    }
    else{
        System.out.println("User Registration Failed");
    }
   }
   // login to facebook test case
   @Test(testName = "Login on Facebook")
   public void loginOnFacebook () throws IOException {
       driver.get("https://web.facebook.com/?_rdc=1&_rdr");
       Web.Login login = new Login();
       if (login.loginUser(fileName , driver) == true){
           System.out.println("User successfully logged in ");
       }
       else{
           System.out.println("User login Failed");
       }
   }
   @AfterSuite
   public void cleanUp(){
       driver.manage().deleteAllCookies();
       driver.close();
   }
}
