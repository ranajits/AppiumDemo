package rnjt.com.appium3;

import android.support.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class unclickTest1 {
    WebDriver driver;
    private UiDevice mDevice;

    @Before
    public void setUp() throws MalformedURLException {



        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Lenovo");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "6.0");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "in.unclick");

        // Set android appActivity desired capability. It is
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "in.unclick.ui.activity.SplashScreenActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {

        driver.findElement(By.id("in.unclick:id/btn_start")).click();

        //Mobile Number Input
        driver.findElement(By.id("in.unclick:id/mobile_no")).sendKeys("8879917028");
        driver.findElement(By.id("in.unclick:id/btn_submit_phone_number")).click();

        //Wait to get OTP
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String OTP=driver.findElement(By.id("in.unclick:id/verify_otp")).getText();
        System.out.println("OTP Is"+OTP);
        if (OTP != "")
        {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("OTP Is"+OTP);
            driver.findElement(By.id("in.unclick:id/btn_submit_phone_number")).click();
        }
        driver.findElement(By.id("in.unclick:id/et_first_name")).clear();
        driver.findElement(By.id("in.unclick:id/et_first_name")).sendKeys("Lakshmi");
        driver.findElement(By.id("in.unclick:id/et_last_name")).clear();
        driver.findElement(By.id("in.unclick:id/et_last_name")).sendKeys("Iyer");
        driver.findElement(By.id("in.unclick:id/btn_done")).click();
        driver.findElement(By.id("in.unclick:id/btn_add_new_ps")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void End() {
        driver.quit();
    }
}
