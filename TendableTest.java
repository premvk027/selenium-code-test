package SeleniumCode;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TendableTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tendable.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1.Confirm accessibility of the top-level menus: Home, Our Story, Our Solution, and Why Tendable.
		
		List<WebElement> allMenu=driver.findElements(By.xpath("//*[@id='main-navigation-new']//following-sibling::ul/parent::li"));
		int count = allMenu.size();
		System.out.println(count);
	    for (WebElement menu : allMenu) {
			
		System.out.println(menu.getText());
		
		//2.Verify that the "Request a Demo" button is present and active on each of the
		//aforementioned top-level menu pages.
		
		Thread.sleep(3000);
		System.out.println("Validated the Request A Demo button");
		WebElement reqDemoBtn = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
		
		boolean reqBut = reqDemoBtn.isEnabled();
		System.out.println("Request A Demo' button enabled " + reqBut);
		
		//3. Navigate to the "Contact Us" section, choose "Marketing", and complete the form—
		//excluding the "Message" field. On submission, an error should arise. Ensure your script
		//confirms the error message's appearance. If the error is displayed, mark the test as PASS. If
		//absent, it's a FAIL.
		
		Thread.sleep(3000);
		System.out.println("Navigate to the Contact Us section and perform the task");
		WebElement contactUsBtn = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		
		Actions actions = new Actions(driver);
		actions.click(contactUsBtn).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w-full body-content']//h1[text()='Contact us']")));
		
		
		driver.findElement(By.xpath("//button[@data-target='.toggle-163701']")).click();
		driver.findElement(By.id("form-input-fullName")).sendKeys("Test_FullName");
		driver.findElement(By.id("form-input-organisationName")).sendKeys("Test");
		driver.findElement(By.name("cellPhone")).sendKeys("5465465445");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("form-input-jobRole")).sendKeys("Test");
		driver.findElement(By.id("form-input-message")).sendKeys("text");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("consentAgreed")));
		//agreeBtn.isSelected();
		WebElement agreeBtn= driver.findElement(By.name("consentAgreed"));
		//boolean agreeButton = agreeBtn.isSelected();
		agreeBtn.isEnabled();
	   // agreeBtn.click();
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@fdprocessedid='xtw3h']")));
		WebElement submitBtn = driver.findElement(By.xpath("//button[@fdprocessedid='xtw3h']"));
		Thread.sleep(2000);
		
		javascript.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		
		submitBtn.click();
		
		
		}
		
		}
	}

