package exceltechonologistltdhw;

import org.testng.annotations.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class SmartCarePro {
  @Test
  public void TestHomeWork() {
	//Browser setup, put URL in the browser and windows maximize.
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://carepro-training.ihmafrica.com/");
		driver.manage().window().maximize();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Login into the SmartCarePRO Website.
		System.out.println("Login Started");
		WebElement Username = driver.findElement(By.name("username"));
		Username.sendKeys("tester");
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys("tester2023!");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println("Login Completed");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Select Province
		System.out.println("After Login Search the Facility");
		Select drpProvince = new Select(driver.findElement(By.xpath("(//div[contains(@class,'flex flex-col')]//select)[1]")));
		drpProvince.selectByVisibleText("Lusaka");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Select District
		Select drpDistrict = new Select(driver.findElement(By.xpath("(//div[contains(@class,'flex flex-col')]//select)[2]")));
		drpDistrict.selectByVisibleText("Lusaka");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Select Facility
		WebElement Facility = driver.findElement(By.xpath("//div[contains(@class,'overflow-auto rounded-md')]//input[1]"));
		Facility.sendKeys("Dr. Watson Dental Clinic");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//div[text()='Dr. Watson Dental Clinic']")).click();

		System.out.println("Facility Search Completed");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Start add new patient
		System.out.println("Add new patient process start.");
		driver.findElement(By.xpath("//div[@class='mt-5 2xl:mt-8']//button[1]")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Click the NRC Button");
		driver.findElement(By.xpath("//button[normalize-space()='NRC']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Set the NRC number 111111111");
		WebElement enterNRC = driver.findElement(By.xpath("//div[contains(@class,'flex flex-col')]//input[1]"));
		enterNRC.sendKeys("111111111");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Next Step to Click Search Button");
		driver.findElement(By.xpath("//button[text()='Search']")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Click to Add Patient");
		driver.findElement(By.xpath("//button[text()='Attend to Patient']")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  //If biometric part arrived
		System.out.println("Fingure print skip");
		driver.findElement(By.xpath("//div[contains(@class,'flex justify-center')]//button[1]")).click();
		driver.findElement(By.xpath("(//div[@class='flex items-center']//span)[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//div[contains(@class,'flex justify-center')]//button)[2]")).click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	  
		//Click Vital for next step
		System.out.println("Click the Vital");
		driver.findElement(By.xpath("//p[text()='Vital']")).click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Add new patient records");
		driver.findElement(By.xpath("//button[@type='button']")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CSV file reading start
		
		System.out.println("Start CSV Reading");

		String csvFile = "CSVFILE\\Sample Dataset.csv";
		try {
			// Read CSV file
			Reader reader = new FileReader(csvFile);
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			List<CSVRecord> records = csvParser.getRecords();

			if (records.isEmpty()) {
				System.out.println("No data found in the CSV file.");
				return;
			}

			CSVRecord firstRecord = records.get(0);

			// Print CSV data to console
			System.out.println("CSV Data:");
			firstRecord.toMap().forEach((key, value) -> System.out.println(key + ": " + value));

			// Store data in an array
			String[] dataArray = new String[firstRecord.size()];
			int index = 0;
			for (String value : firstRecord) {
				dataArray[index++] = value;
			}

			// Print array data
			System.out.println("Print the CSV data");
			System.out.println("Array Data: " + Arrays.toString(dataArray));
			
			//Set the data to the entry field.
			System.out.println("Start entry csv data in the text field");

			driver.findElement(By.name("temperature")).sendKeys(dataArray[5]);
			driver.findElement(By.name("systolic")).sendKeys(dataArray[6]);
			driver.findElement(By.name("diastolic")).sendKeys(dataArray[7]);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.name("pulseRate")).sendKeys(dataArray[8]);
			driver.findElement(By.name("respiratoryRate")).sendKeys(dataArray[9]);
			driver.findElement(By.name("oxygenSaturation")).sendKeys(dataArray[10]);

			WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']//span[1]"));
			submitButton.click();
			System.out.println("Data submission completed and thank you");
			System.out.println("Assignment Completed");
			csvParser.close();

		} catch (IllegalArgumentException e) {
			System.err.println("Column not found in CSV file: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.manage().window().minimize();
		}
	}
}
