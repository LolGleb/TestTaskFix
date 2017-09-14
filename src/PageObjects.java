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
    public By loginTitle = By.xpath("//h2[text()='Login']");

    public By loginInput = By.id("username");

    public By loginReq = By.xpath("//form/div[1]/span");

    public By passwordInput = By.id("password");

    public By passReq = By.xpath("//form/div[2]/span");

    public By btnLogin = By.xpath("//button[text()='Login']");

    //Addition page
    public By additionTitle = By.xpath("//h1[text()='Операция сложения']");

    public By greeting = By.xpath("//h3[contains(text(), 'Привет, ')]");

    public By descriptionTitle = By.xpath("//h4");

    public By description = By.xpath("//div[@class='animate-switch ng-scope']");

    public By input1 = By.id("value1");

    public By input2 = By.id("value2");

    public By input3 = By.id("value3");

    public By check1 = By.xpath("//tbody/tr[1]/td");

    public By check2 = By.xpath("//tbody/tr[2]/td");

    public By check3 = By.xpath("//tbody/tr[3]/td");

    public By result = By.xpath("//tbody/tr[4]/td");

    public By resultLine = By.xpath("//tbody/tr[4]");

    public By btnBack = By.xpath("//input[@value='Назад']");

    public By btnForward = By.xpath("//input[@value='Вперед']");

    public By btnToTheBeginning = By.xpath("//input[@value='Вернуться к вводу данных']");

    public By preloaderText = By.xpath("//p[text()='Производятся расчеты, пожалуйста подождите...']");

    public By preloader = By.xpath("//img[@src='data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==']");

}
