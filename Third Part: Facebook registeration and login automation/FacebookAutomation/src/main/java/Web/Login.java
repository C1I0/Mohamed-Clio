package Web;

import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    public boolean loginUser(String fileName, WebDriver driver) throws IOException {
        // open test data file
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String csvCell[];
        // read data from file
        while ((csvCell = reader.readNext()) !=null)
        {
            // here we read each cell of the row
            // as user registration is done first so we can use same Test data file to login
            String email = csvCell[2];
            String password = csvCell[3];
           // assertion on facebook using xpath
            driver.findElement(By.xpath("//*[@id='u_1l_g_Aq']")).sendKeys(email);
            driver.findElement(By.xpath("//*[@id='password_step_input']")).sendKeys(password);
            // click on login button for login to the system
            clickLogin(driver);
            // check if an error message appeared
            boolean checkError = driver.getPageSource().contains("The email address or mobile number you entered isn't connected to an account");
            if (checkError != true)
                return true;
            else
                return false;
        }
        return false;
    }
    public void clickLogin(WebDriver driver){
         driver.findElement(By.xpath("//*[@id='u_0_j_nI']")).click();
    }

}

