package Test;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class RcaValidationTests {

    @Managed(driver = "chrome")
    WebDriver driver;

    // 1. Assertion Failure
    @Test
    void assertionFailureTest() {
        assertThat("actual").isEqualTo("expected");
    }

    // 2. Null Pointer Exception
    @Test
    void nullPointerExceptionTest() {
        String str = null;
        str.length();
    }

    // 3. Element Not Found Exception
    @Test
    void elementNotFoundTest() {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("non-existent-element"));
    }

    // 4. Timeout Exception
    @Test
    void timeoutExceptionTest() {
        driver.get("https://duckduckgo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element-that-will-not-appear")));
    }

    // 5. Stale Element Reference Exception
    @Test
    void staleElementReferenceTest() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.id("search_form_input_homepage"));
        driver.navigate().refresh();
        // This will throw a StaleElementReferenceException
        searchInput.sendKeys("stale");
    }

    // 6. Arithmetic Exception
    @Test
    void arithmeticExceptionTest() {
        int i = 1 / 0;
    }

    // 7. Index Out of Bounds Exception
    @Test
    void indexOutOfBoundsTest() {
        List<String> list = new ArrayList<>();
        list.get(0);
    }

    // 8. Class Cast Exception
    @Test
    void classCastExceptionTest() {
        Object x = Integer.valueOf(0);
        System.out.println((String) x);
    }

    // 9. Illegal Argument Exception
    @Test
    void illegalArgumentExceptionTest() {
        throw new IllegalArgumentException("This is a test for illegal argument exception");
    }

    // 10. Number Format Exception
    @Test
    void numberFormatExceptionTest() {
        Integer.parseInt("not a number");
    }
}
