import org.openqa.selenium.By;

public class PageObjects {

    public By headerLogin = By.xpath("//a[text()='Login']");

    public By headerLogout = By.xpath("//a[text()='logout']");

    public By headerAddition = By.xpath("//a[text()='Операция сложения']");

    public By loginInput = By.id("username");

    public By passwordInput = By.id("password");

    public By greeting = By.xpath("//h3[contains(text(), 'Привет, ')]");

    public By input1 = By.id("value1");

    public By input2 = By.id("value2");

    public By input3 = By.id("value3");

}
