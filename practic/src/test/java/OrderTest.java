import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private static By orderButton;

    private static String name;
    private static String surname;
    private static String address;
    private static String phoneNumber;

    private final By notification = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public OrderTest(By orderButton, String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object [][] getCredentials(){
        return new Object[][] {
                {MainPage.orderButtonTop, "Иванов", "Иван", "Москва", "89000000000"},
                {MainPage.orderButtonMiddle, "Романов", "Роман", "Москва", "89000066600"}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        MainPage webScooterMainPage = new MainPage(driver);
        webScooterMainPage.openMainPage();

    }
    @Test
    public void makeAnOrder() {
        Order order = new Order(driver);
        order.clickOrder(orderButton ,name, surname, address, phoneNumber);
        OrderRent orderRent = new OrderRent(driver);
        orderRent.rent("1", "Нормально" );
        assertTrue(driver.findElement(notification).isDisplayed());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}