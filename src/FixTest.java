import com.codeborne.selenide.CollectionCondition;
import org.junit.Test;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FixTest {
    @Test
    public void userCanLoginByUsername() {
        String login = "QWA";
        String pass = "12345";
        String val1 = "1";
        String val2 = "2";
        String val3 = "3";
        PageObjects page = new PageObjects();
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://rulkov.ru/qa/");
        $(page.welcome).isDisplayed();
        $$(page.allImg).shouldHave(CollectionCondition.size(11));
        $(page.headerLogin).click();
        Assert.assertEquals(url(), "http://rulkov.ru/qa/login");
        $(page.btnLogin).has(cssClass("btn-danger"));
        $(page.loginInput).setValue(login);
        $(page.passwordInput).setValue(pass);
        $(page.btnLogin).shouldNotHave(cssClass("btn-danger"));
        $(page.btnLogin).click();
        //$(".loading_progress").should(disappear); // Waits until element disappears
        $(page.additionTitle).isDisplayed();
        $(page.greeting).shouldHave(text("Привет, " + login +"!")); // Waits until element gets text
        $(page.descriptionTitle).shouldHave(text("Шаг \"Ввод данных\"."));
        $(page.description).shouldHave(text("Содержит три текстовых поля, обязательных к заполнению, формат вводимых данных - целые положительные числа."));
        Assert.assertEquals(url(), "http://rulkov.ru/qa/addition");
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        $(page.input1).sendKeys(val1);
        $(page.input2).sendKeys(val2);
        $(page.input3).sendKeys(val3);
        $(page.btnForward).shouldNotBe(disabled);
        $(page.btnForward).click();
        $(page.descriptionTitle).shouldHave(text("Шаг \"Подтверждение данных\""));
        $(page.description).shouldHave(text("На данном шаге, пользователю в табличном виде представляются данные, которые он ввел на шаге \"Ввода данных\"."));
    }
}
