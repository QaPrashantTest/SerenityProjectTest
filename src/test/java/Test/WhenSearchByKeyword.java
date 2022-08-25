package Test;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

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
    //my code
    @Test
    public void test(){
        System.out.println("Test method 1");
    }
    @Test
    public void test2(){
        System.out.println("Test method 2");
    }
    @Test
    public void test3(){
        System.out.println("Test method 3");
    }


}
