package com.accelerator.spring.automationaccelerator.mouri.config;

import com.accelerator.spring.automationaccelerator.mouri.annotations.LazyConfiguration;
import com.accelerator.spring.automationaccelerator.mouri.annotations.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @Value("${default.timeout:30}")
    private int timeout;

    @ThreadScopeBean
    @ConditionalOnProperty(name="browser",havingValue="firefox")
    public WebDriver remoteFirefoxDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.firefox());
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name="browser",havingValue="chrome")
    public WebDriver remoteChromeDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.chrome());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteDriver(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.chrome());
    }


}
