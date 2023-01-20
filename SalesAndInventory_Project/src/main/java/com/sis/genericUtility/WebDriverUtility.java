    package com.sis.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void elementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	
	public void select(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}
	
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void select(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void mouseHovering(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	public void moveByOffset(WebDriver driver, int X, int Y) {
		Actions action = new Actions(driver);
		action.moveByOffset(X, Y).click().perform();
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dst);
	}
	
	public void doubleClickAction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}
	
	public void rightClick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void enterKeyPress(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void enterKey(WebDriver driver) throws Throwable {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver, String partialTitle) {
		//Step1 - Use getWindowHandles to capture all Window IDs
		Set<String> windows = driver.getWindowHandles();
		
		//step2 - Iterate through the Windows
		Iterator<String> iterator = windows.iterator();
		
		//Step3 - Check whether there is next window 
		while (iterator.hasNext()) {
			//step4 - Capture current Window ID
			String winID = iterator.next();
			
			//step5 - Switch to current window and capture the title
			String currentWindowTitle = driver.switchTo().window(winID).getTitle();
			
			//Step6 - Check whether current window is expected
			if (currentWindowTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;
	}	
	
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 800)", " ");
	}
	
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0, "+y+")", element);
		//jse.executeScript("arugument[0].scrollIntoView()", element);
	}
}
