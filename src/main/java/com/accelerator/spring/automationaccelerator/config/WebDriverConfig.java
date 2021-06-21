package com.accelerator.spring.automationaccelerator.config;

import com.accelerator.spring.automationaccelerator.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;


@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @Bean
    //@ConditionalOnProperty(name="browser",havingValue = "chrome")
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    //@ConditionalOnProperty(name="browser",havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean
    //@ConditionalOnProperty(name="browser",havingValue = "ie")
    public WebDriver ieDriver(){
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    @Bean
    @Scope("browserscope")
    //@ConditionalOnMissingBean
    public WebDriver safariDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }



}
