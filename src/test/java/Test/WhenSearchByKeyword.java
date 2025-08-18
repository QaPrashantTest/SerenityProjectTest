package Test;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

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

    // 5 new failing tests to validate RCA

    @Test
    void nullPointerExceptionTest() {
        String str = null;
        str.length();
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
    void numberFormatExceptionTest() {
        Integer.parseInt("not a number");
    }

}
