import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FixTest {
    @Test
    public void userCanLoginByUsername() {
        String login = "QWA";
        String pass = "12345";
        PageObjects page = new PageObjects();
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://rulkov.ru/qa/");
        $(page.headerLogin).click();
        $(page.loginInput).setValue(login);
        $(page.passwordInput).setValue(pass).pressEnter();
        //$(".loading_progress").should(disappear); // Waits until element disappears
        $(page.greeting).shouldHave(text("Привет, " + login +"!")); // Waits until element gets text
    }
}
