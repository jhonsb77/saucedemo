package utils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class SelectDriver implements DriverSource {

    private static final String NAVEGADOR_ACTUAL="firefox";
    WebDriver driver;
    public WebDriver seleccionarTipoDriver() {
        MyDriverSetup myDriverSetup = new MyDriverSetup();
        switch (NAVEGADOR_ACTUAL.trim().toLowerCase()){
            case "firefox":
                Serenity.recordReportData().withTitle("Navegador").andContents("Firefox");
                driver = myDriverSetup.webFirefoxDriver("firefox");
                break;
            default:
                Serenity.recordReportData().withTitle("Navegador").andContents("Chrome");
                break;
        }
        return driver;
    }

    @Override
    public WebDriver newDriver() {
        return seleccionarTipoDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }



}
