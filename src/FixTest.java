import com.codeborne.selenide.CollectionCondition;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FixTest extends Helper {
    @Test(description = "Проверка функциаонала на корректную работу, проверка текста, проверка поведения кнопок", priority = 1)
    public void positiveTest() throws InterruptedException {
        setUp();
        PageObjects page = new PageObjects();
        //Start page
        $(page.welcome).waitUntil(appear, 20000);
        $$(page.allImg).shouldHave(CollectionCondition.size(11));
        $(page.headerLogin).click();
        //Login page
        Assert.assertEquals(url(), "http://rulkov.ru/qa/login");
        $(page.btnLogin).has(cssClass("btn-danger"));
        $(page.btnLogin).shouldBe(disabled);
        $(page.loginInput).setValue(login);
        $(page.passwordInput).setValue(pass);
        $(page.btnLogin).shouldNotHave(cssClass("btn-danger"));
        $(page.btnLogin).click();
        //$(".loading_progress").should(disappear); // Waits until element disappears
        //Addition page
        $(page.additionTitle).shouldBe(exist);
        $(page.greeting).shouldBe(text("Привет, " + login + "!"));
        //Step1
        $(page.descriptionTitle).shouldBe(text("Шаг \"Ввод данных\"."));
        $(page.description).shouldBe(text("Содержит три текстовых поля, обязательных к заполнению, формат вводимых " +
                "данных - целые положительные числа."));
        Assert.assertEquals(url(), "http://rulkov.ru/qa/addition");
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        $(page.input1).setValue(val1);
        $(page.input2).setValue(val2);
        $(page.input3).setValue(val3);
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
        $(page.description).shouldBe(text("На данном шаге в течении 5 секунд отображается сообщение, информирующие " +
                "пользователя что производится расчет. Все кнопки заблокированы или скрыты. После производится " +
                "автоматический переход на следующий шаг."));
        Thread.sleep(2000);
        $(page.btnBack).shouldBe(disabled);
        $(page.btnForward).shouldBe(disabled);
        $(page.preloaderText).should(disappear);
        $(page.preloader).should(disappear);
        //Step4
        $(page.descriptionTitle).shouldBe(text("Шаг \"Результат\"."));
        $(page.description).shouldBe(text("На данном шаге, пользователю в табличном виде представляются данные, " +
                "которые он ввел на шаге \"Ввода данных\", а также строку с результатом вычисления. Строка с " +
                "результатами должна содержать результат сложения трех чисел, которые ввел пользователь на первом шаге. " +
                "Если результатом операции является четное число, последняя строка должна быть зеленого цвета."));
        $(page.check1).shouldBe(text(val1));
        $(page.check2).shouldBe(text(val2));
        $(page.check3).shouldBe(text(val3));
        Assert.assertEquals(Integer.parseInt($(page.result).getText()), sum1);
        successLineColorCheck(sum1, page.resultLine);
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
        //Check sum % 2 == 1
        $(page.input1).setValue(val1);
        $(page.input2).setValue(val2);
        $(page.input3).setValue(val2);
        $(page.btnForward).click();
        $(page.btnForward).click();
        Thread.sleep(2000);
        $(page.preloaderText).should(disappear);
        Assert.assertEquals(Integer.parseInt($(page.result).getText()), sum2);
        successLineColorCheck(sum2, page.resultLine);
        //Logout
        $(page.headerLogout).click();
        $(page.welcome).shouldBe(exist);
        Assert.assertEquals(url(), "http://rulkov.ru/qa/");
    }

    @Test(description = "Проверка валидации", priority = 2)
    public void negativeTest() throws InterruptedException {
        setUp();
        PageObjects page = new PageObjects();
        $(page.headerLogin).click();
        $(page.loginInput).setValue(login);
        $(page.btnLogin).has(cssClass("btn-danger"));
        $(page.btnLogin).shouldBe(disabled);
        $(page.loginInput).clear();
        $(page.loginReq).shouldBe(text("Поле Логин обязательное для заполнения"));
        $(page.passwordInput).setValue(pass);
        $(page.btnLogin).has(cssClass("btn-danger"));
        $(page.btnLogin).shouldBe(disabled);
        $(page.passwordInput).clear();
        $(page.passReq).shouldBe(text("Поле Пароль обязательное для заполнения"));
        $(page.btnLogin).has(cssClass("btn-danger"));
        $(page.btnLogin).shouldBe(disabled);
        $(page.loginInput).setValue(strangeLogin);
        $(page.passwordInput).setValue(strangePassword).pressEnter();
        $(page.greeting).shouldBe(text("Привет, " + strangeLogin + "!"));
        $(page.input1).setValue(strangeVal1);
        Assert.assertEquals(Integer.parseInt($(page.input1).getAttribute("value")), Integer.parseInt(strangeVal1.replaceAll("[\\D]", "")));
        $(page.btnForward).shouldBe(disabled);
        $(page.input2).setValue(strangeVal2);
        Assert.assertEquals($(page.input2).getAttribute("value"), strangeVal2);
        $(page.btnForward).shouldBe(disabled);
        $(page.input3).setValue(strangeVal3);
        Assert.assertEquals($(page.input3).getAttribute("value"), strangeVal3);
        $(page.btnForward).click();
        $(page.btnForward).click();
        Thread.sleep(2000);
        $(page.preloaderText).should(disappear);
        Assert.assertEquals(Integer.parseInt($(page.result).getText()), strangeSum);
    }
}
