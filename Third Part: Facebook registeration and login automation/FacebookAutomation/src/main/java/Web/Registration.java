package Web;

import com.opencsv.CSVReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class Registration {
    public boolean registerUser(String fileName,WebDriver driver) throws IOException {
        // open test data file
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String csvCell[];
        // read data from file
        while ((csvCell = reader.readNext()) !=null)
        {
            // here we read each cell of the row
            String firstName = csvCell[0];
            String lastName = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];
            String day = csvCell[4];
            String month = csvCell[5];
            String year = csvCell[6];
            String gender = csvCell[7];
            clickCreateNewAccount(driver);
            // assertion on facebook using xpath
            driver.findElement(By.xpath("//*[@id='u_1l_b_OA']")).sendKeys(firstName);
            driver.findElement(By.xpath("//*[@id='u_1l_d_cb']")).sendKeys(lastName);
            driver.findElement(By.xpath("//*[@id='u_1l_g_Aq']")).sendKeys(email);
            // reenter email
            driver.findElement(By.xpath("//*[@id='u_4_j_3J']")).sendKeys(email);
            driver.findElement(By.xpath("//*[@id='password_step_input']")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id='day']")).sendKeys(day);
            driver.findElement(By.xpath("//*[@id='month']")).sendKeys(month);
            driver.findElement(By.xpath("//*[@id='year']")).sendKeys(year);
            // check for gender selection
            if (gender =="Male"){
                driver.findElement(By.xpath("//*[@id='u_1l_3_Jb']")).click();
            }
            else if (gender == "female"){
                driver.findElement(By.xpath("//*[@id='u_1l_2_ZG']")).click();
            }
            else {
                driver.findElement(By.xpath("//*[@id='u_1l_4_Zg']")).click();
            }
            // click to register
            driver.findElement(By.xpath("//*[@id='u_1l_s_sk']")).click();
            // check if page contains error message
            boolean checkError = driver.getPageSource().contains("It looks like you may have entered an incorrect");
            if (checkError != true)
                return true;
            else
                return false;
        }
    return false;
    }
    //click on the option to access creating a new account
    public void clickCreateNewAccount(WebDriver driver){
        driver.findElement(By.xpath("//*[@id='u_0_2_db']")).click();
    }

}
