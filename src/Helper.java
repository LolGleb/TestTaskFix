import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Helper {
    String login = "Gleb Fox";
    String pass = "Super-tester42";
    String strangeLogin = "КаПиTo$h!@#_1999%(^+=)";
    String strangePassword = "123,456/78.90-=!@#$%^&*()_+qweQWEячсЯЧС";
    String val1 = "1";
    String val2 = "2";
    String val3 = "3";
    String strangeVal1 = "123,456/78.90-=!@#$%^&*()_+qweQWEячсЯЧС";
    String strangeVal2 = "000000000000000000000000000000000000000";
    String strangeVal3 = "000000000000000000000000000000000000001";
    int sum1 = Integer.parseInt(val1) + Integer.parseInt(val2) + Integer.parseInt(val3);
    int sum2 = Integer.parseInt(val1) + Integer.parseInt(val2) + Integer.parseInt(val2);
    int strangeSum = Integer.parseInt(strangeVal1.replaceAll("[\\D]", "")) + Integer.parseInt(strangeVal2) + Integer.parseInt(strangeVal3);

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://rulkov.ru/qa/");
    }

    public void successLineColorCheck(int sum, By by){
        if ((sum % 2) == 0){
            $(by).shouldBe(cssClass("bg-success"));
        } else {
            $(by).shouldBe(cssClass(""));
        }
    }
}
