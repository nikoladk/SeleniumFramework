package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;
import gherkin.lexer.Ru;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "configs//Configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found in " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if(driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath is not specified in the Configuration.properties");
    }

    public String getGeckoDriverPath() {
        String geckoDriver = properties.getProperty("geckoDriverPath");
        if(geckoDriver != null) return geckoDriver;
        else throw new RuntimeException("Gecko driver path is not specified in the Configuration.properties");
    }

    public long getImplicitWait() {
        String implicitWait = properties.getProperty("implicitlyWait");
        if(implicitWait != null) return  Long.parseLong(implicitWait);
        else throw new RuntimeException("implicitlyWait is not specified in the Configuration.properties");
    }

    public String getApplicationUrl() {
        String applicationUrl = properties.getProperty("URL");
        if(applicationUrl != null) return applicationUrl;
        else throw new RuntimeException("URL is not specified in the Configuration.properties");
    }

    public DriverType getBrowser() {
        String browserType = properties.getProperty("browser");
        if(browserType == null || browserType.equals("chrome")) return DriverType.CHROME;
        else if(browserType.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserType.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser name in Configuration.properties is not matched: " + browserType);
    }

    public EnvironmentType getEnvironment() {
        String environmentType = properties.getProperty("environment");
        if(environmentType == null || environmentType.equals("local")) return EnvironmentType.LOCAL;
        else if(environmentType.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentType);
    }

    public Boolean getBrowserWindowSize() {
        String browserSize = properties.getProperty("windowMaximize");
        if(browserSize != null) return Boolean.valueOf(browserSize);
        return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if(testDataResourcePath != null) return testDataResourcePath;
        else throw new RuntimeException("Test data resource path is not specified in the configuration properties");
    }
}
