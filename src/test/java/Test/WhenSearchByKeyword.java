package Test;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchByKeyword {

    @Managed(driver ="chrome")//options ="headless"
    WebDriver driver;
    NavigateActions navigate;
    SearchActions searchActions;
    SearchResultSidebar searchResultSidebar;

    @Test
    void theKeywordShouldAppearInTheResultsSidebar() {
        navigate.toTheDuckDuckGoSearchPage();
        searchActions.byKeyword("Quality Assurance");
        Serenity.reportThat("The Keyword should appear in the sidebar heading",()->
        assertThat(searchResultSidebar.heading()).isEqualTo("Quality assurance")
        );
    }

    // 20 failing tests to validate RCA

    @Test
    void assertionFailureTest() {
        assertThat("actual").isEqualTo("expected");
    }

    @Test
    void nullPointerExceptionTest() {
        String str = null;
        str.length();
    }

    @Test
    void elementNotFoundTest() {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("non-existent-element"));
    }

    @Test
    void timeoutExceptionTest() {
        driver.get("https://duckduckgo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element-that-will-not-appear")));
    }

    @Test
    void staleElementReferenceTest() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.id("search_form_input_homepage"));
        driver.navigate().refresh();
        searchInput.sendKeys("stale");
    }

    @Test
    void arithmeticExceptionTest() {
        int i = 1 / 0;
    }

    @Test
    void indexOutOfBoundsTest() {
        List<String> list = new ArrayList<>();
        list.get(0);
    }

    @Test
    void classCastExceptionTest() {
        Object x = Integer.valueOf(0);
        System.out.println((String) x);
    }

    @Test
    void illegalArgumentExceptionTest() {
        throw new IllegalArgumentException("This is a test for illegal argument exception");
    }

    @Test
    void numberFormatExceptionTest() {
        Integer.parseInt("not a number");
    }

    @Test
    void javascriptErrorTest() {
        driver.get("https://duckduckgo.com/");
        ((JavascriptExecutor) driver).executeScript("throw new Error('This is a custom JS error');");
    }

    @Test
    void elementClickInterceptedExceptionTest() throws InterruptedException {
        File htmlFile = new File("src/test/resources/overlay_test.html");
        driver.get("file://" + htmlFile.getAbsolutePath());
        Thread.sleep(2000); // Wait for overlay to appear
        driver.findElement(By.id("clickable-button")).click();
    }

    @Test
    void elementNotInteractableExceptionTest() {
        driver.get("https://duckduckgo.com/");
        // The search input is visible, but let's try to interact with a hidden element
        WebElement hiddenElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.getElementById('search_form_input_homepage');");
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", hiddenElement);
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("hidden");
    }

    @Test
    void invalidSelectorExceptionTest() {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("///invalid-xpath"));
    }

    @Test
    void noAlertPresentExceptionTest() {
        driver.get("https://duckduckgo.com/");
        driver.switchTo().alert();
    }

    @Test
    void noSuchWindowExceptionTest() {
        driver.get("https://duckduckgo.com/");
        driver.switchTo().window("non-existent-window");
    }

    @Test
    void unsupportedOperationExceptionTest() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Test
    void illegalStateExceptionTest() {
        throw new IllegalStateException("This is an illegal state");
    }

    @Test
    void securityExceptionTest() {
        throw new SecurityException("This is a security exception");
    }

    @Test
    void genericRuntimeExceptionTest() {
        throw new RuntimeException("This is a generic runtime exception");
    }
}
