import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eszti\\Java Spring\\eclipse\\eclipse\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//40 3
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object>coordinates = new HashMap<String,Object>();
		//40 3
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		Thread.sleep(3000);
		driver.get("http://google.com");

		driver.findElement(By.xpath("//*[text()='I agree']")).click();
		
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);
		
		
		
		
		
		
		
		
	}

}
