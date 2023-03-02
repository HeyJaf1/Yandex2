import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderRent {

    private WebDriver driver;

    //поле Когда привезти самокат
    private final By dateField = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    //выбор даты в календаре
    private final By choosingDate = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
    //поле с выпадающим списком со скроком аренды самоката
    private final By rentField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //выбор периода аренды из списка
    private final By choosingRentalPeriod = By.xpath(".//div[text()='сутки']");
    //выбор цвета самоката
    private final By colorOfScooter = By.id("black"); //выбор черного цвета
    //поле с комментарием
    private final By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    //финальная кнопка заказать
    private final By finalOrderButton = By.xpath(".//div[3]/button[text()='Заказать']");
    //Всплывающее окно хотите оформить заказ? Кнопка Да
    private final By yesOrderButton = By.xpath(".//button[text()='Да']");
    //сообщение об успешном оформлении заказа
    //private final By notification = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

    public OrderRent(WebDriver driver) {
        this.driver = driver;
    }

    public void rent(String dayWhatIWant, String comment) {
        driver.findElement(dateField).sendKeys(dayWhatIWant);
        driver.findElement(choosingDate).click();
        driver.findElement(rentField).click();
        driver.findElement(choosingRentalPeriod).click();
        driver.findElement(colorOfScooter).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(finalOrderButton).click();
        driver.findElement(yesOrderButton).click();
    }
}
