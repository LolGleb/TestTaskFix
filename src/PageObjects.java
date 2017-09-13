import org.openqa.selenium.By;

public class PageObjects {

    //Header
    public By headerLogin = By.xpath("//a[text()='Login']");

    public By headerLogout = By.xpath("//a[text()='logout']");

    public By headerAddition = By.xpath("//a[text()='Операция сложения']");

    //Main page
    public By welcome = By.xpath("//h1[text()='Welcome']");

    public By allImg = By.xpath("//img");

    //Login page
    public By loginInput = By.id("username");

    public By passwordInput = By.id("password");

    public By btnLogin = By.xpath("//button[text()='Login']");

    //Addition page
    public By additionTitle = By.xpath("//h1[text()='Операция сложения']");

    public By greeting = By.xpath("//h3[contains(text(), 'Привет, ')]");

    public By descriptionTitle = By.xpath("//h4");

    public By description = By.xpath("//div[@class='animate-switch ng-scope']");

    public By input1 = By.id("value1");

    public By input2 = By.id("value2");

    public By input3 = By.id("value3");

    public By btnBack = By.xpath("//input[@value='Назад']");

    public By btnForward = By.xpath("//input[@value='Вперед']");

}
