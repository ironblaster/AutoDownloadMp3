package autoDownloadMp3;

import java.awt.BorderLayout;
import java.awt.Label;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

import javax.swing.JFrame;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.Mp3File;

public class TestJunit {

	
	@Ignore
	public static void window() {
		
		JFrame frame = new JFrame("Test Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Label test = new Label();
		
		frame.getContentPane().add(test,BorderLayout.CENTER);
		
		
		frame.pack();
		
		frame.setVisible(true);
		
		
		
		
	}
	
	
	
	
	@Test
	public void testSearch() {
		
		
	/*	WebDriver driver = new HtmlUnitDriver();

		driver.get("https://my-free-mp3s.com/");

		WebElement element = driver.findElement(By.id("query"));

		element.sendKeys("anastasio");

		WebElement cerca = driver.findElement(By.className("btn"));
		cerca.click();

		
		Set <String> test = driver.getWindowHandles();
		 
		
		
		System.out.println(driver.getTitle());
		
		
		driver.quit();*/
		
		
		
		DownloadPage("https://my-free-mp3s.com/");
		
	}
	
	
	
	
	 private static void DownloadPage(String url) {
	        ChromeDriver driver = null;

	        try
	        {
	            ChromeOptions options = new ChromeOptions();
	            // add whatever extensions you need
	            // for example I needed one of adding proxy, and one for blocking
	            // images
	            // options.addExtensions(new File(file, "proxy.zip"));
	            // options.addExtensions(new File("extensions",
	            // "Block-image_v1.1.crx"));

	            DesiredCapabilities cap = DesiredCapabilities.chrome();
	            cap.setCapability(ChromeOptions.CAPABILITY, options);

	            // set performance logger
	            // this sends Network.enable to chromedriver
	            LoggingPreferences logPrefs = new LoggingPreferences();
	            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
	            cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

	            driver = new ChromeDriver();

	            // navigate to the page
	            System.out.println("Navigate to " + url);
	            driver.navigate().to(url);
	            
	            WebElement element = driver.findElement(By.id("query"));

	    		element.sendKeys("anastasio");

	    		WebElement cerca = driver.findElement(By.className("btn"));
	    		cerca.click();

	            
	            

	            // and capture the last recorded url (it may be a redirect, or the
	            // original url)
	            String currentURL = driver.getCurrentUrl();

	            // then ask for all the performance logs from this request
	            // one of them will contain the Network.responseReceived method
	            // and we shall find the "last recorded url" response
	            LogEntries logs = driver.manage().logs().get("performance");

	            int status = -1;

	            System.out.println("\nList of log entries:\n");

	            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
	            {
	                LogEntry entry = it.next();

	                try
	                {
	                    JSONObject json = new JSONObject(entry.getMessage());

	                    System.out.println(json.toString());

	                    JSONObject message = json.getJSONObject("message");
	                    String method = message.getString("method");

	                    if (method != null
	                            && "Network.responseReceived".equals(method))
	                    {
	                        JSONObject params = message.getJSONObject("params");

	                        JSONObject response = params.getJSONObject("response");
	                        String messageUrl = response.getString("url");

	                        if (currentURL.equals(messageUrl))
	                        {
	                            status = response.getInt("status");

	                            System.out.println(
	                                    "---------- bingo !!!!!!!!!!!!!! returned response for "
	                                            + messageUrl + ": " + status);

	                            System.out.println(
	                                    "---------- bingo !!!!!!!!!!!!!! headers: "
	                                            + response.get("headers"));
	                        }
	                    }
	                } catch (JSONException e)
	                {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }

	            System.out.println("\nstatus code: " + status);
	        } finally
	        {
	            if (driver != null)
	            {
	                driver.quit();
	            }
	        }
	    }
	
	
	
	
	
	
	
	@Ignore
	public void TestMp3title () {
		
		
		File dir = new File("H:");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		    
				System.out.println(child.getName());
	
		    
				if(child.getName().contains(".mp3"))
        try {

 
        	Mp3File mp3file = new Mp3File(child.getAbsoluteFile());
        	
        	String[] file = child.getName().replace("my-free-mp3s.com", "").replace(".mp3", "").split("-", 2);
        	
        	ID3v1Tag id3v1Tag = new ID3v1Tag();
        	  mp3file.setId3v1Tag(id3v1Tag);
        	  
        	  id3v1Tag.setArtist(file[0]);
        	  id3v1Tag.setTitle(file[1]);
        	  
        	  
        	mp3file.save("H:/"+file[0]+" - "+file[1]+".mp3");
        	child.delete(); 
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        
		   }}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
