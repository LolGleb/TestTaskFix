import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FixTest {
    @Test
    public void positiveTest() throws InterruptedException {
        String login = "QWA";
        String pass = "12345";
        String val1 = "1";
        String val2 = "2";
        String val3 = "3";
        int sum = Integer.parseInt(val1) + Integer.parseInt(val2) + Integer.parseInt(val3);
        PageObjects page = new PageObjects();
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://rulkov.ru/qa/");
        //Start page
        $(page.welcome).shouldBe(exist);
        $$(page.allImg).shouldHave(CollectionCondition.size(11));
        $(page.headerLogin).click();
        //Login page
        Assert.assertEquals(url(), "http://rulkov.ru/qa/login");
        $(page.btnLogin).has(cssClass("btn-danger"));
        $(page.loginInput).setValue(login);
        $(page.passwordInput).setValue(pass);
        $(page.btnLogin).shouldNotHave(cssClass("btn-danger"));
        $(page.btnLogin).click();
        //$(".loading_progress").should(disappear); // Waits until element disappears
        //Addition page
        $(page.additionTitle).shouldBe(exist);
        $(page.greeting).shouldHave(text("Привет, " + login + "!")); // Waits until element gets text
        //Step1
        $(page.descriptionTitle).shouldBe(text("Шаг \"Ввод данных\"."));
        $(page.description).shouldBe(text("Содержит три текстовых поля, обязательных к заполнению, формат вводимых " +
                "данных - целые положительные числа."));
        Assert.assertEquals(url(), "http://rulkov.ru/qa/addition");
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        $(page.input1).sendKeys(val1);
        $(page.input2).sendKeys(val2);
        $(page.input3).sendKeys(val3);
        $(page.btnForward).shouldNotBe(disabled);
        $(page.btnForward).click();
        //Step2
        $(page.descriptionTitle).shouldBe(text("Шаг \"Подтверждение данных\""));
        $(page.description).shouldBe(text("На данном шаге, пользователю в табличном виде представляются данные, которые" +
                " он ввел на шаге \"Ввода данных\"."));
        $(page.check1).shouldBe(text(val1));
        $(page.check2).shouldBe(text(val2));
        $(page.check3).shouldBe(text(val3));
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldNotBe(disabled);
        $(page.btnForward).click();
        //Step3
        $(page.descriptionTitle).shouldBe(text("Шаг \"Расчет\"."));
        $(page.description).shouldHave(text("На данном шаге в течении 5 секунд отображается сообщение, информирующие " +
                "пользователя что производится расчет. Все кнопки заблокированы или скрыты. После производится " +
                "автоматический переход на следующий шаг."));
        Thread.sleep(2000);
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        $(page.preloaderText).should(disappear);
        $(page.preloader).should(disappear);
        //Step4
        $(page.descriptionTitle).shouldBe(text("Шаг \"Результат\"."));
        $(page.description).shouldHave(text("На данном шаге, пользователю в табличном виде представляются данные, " +
                "которые он ввел на шаге \"Ввода данных\", а также строку с результатом вычисления. Строка с " +
                "результатами должна содержать результат сложения трех чисел, которые ввел пользователь на первом шаге. " +
                "Если результатом операции является четное число, последняя строка должна быть зеленого цвета."));
        $(page.check1).shouldBe(text(val1));
        $(page.check2).shouldBe(text(val2));
        $(page.check3).shouldBe(text(val3));
        Assert.assertEquals(Integer.parseInt($(page.result).getText()), sum);
        if ((sum % 2) == 0){
            $(page.resultLine).shouldBe(cssClass("bg-success"));
        } else {
            $(page.resultLine).shouldBe(cssClass(""));
        }
        $(page.btnToTheBeginning).shouldNotBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        $(page.btnBack).shouldNotBe(exist);
        $(page.btnToTheBeginning).click();
        //Back to Step1
        $(page.descriptionTitle).shouldBe(text("Шаг \"Ввод данных\"."));
        $(page.description).shouldBe(text("Содержит три текстовых поля, обязательных к заполнению, формат вводимых " +
                "данных - целые положительные числа."));
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        //Logout
        $(page.headerLogout).click();
        $(page.welcome).shouldBe(exist);
        Assert.assertEquals(url(), "http://rulkov.ru/qa/");
    }
}
