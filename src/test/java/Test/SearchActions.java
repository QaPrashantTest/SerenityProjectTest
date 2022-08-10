package Test;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class SearchActions extends UIInteractions {

   @Step("Search for '{0}'")
    public void byKeyword(String Keyword){
      //  $("//input[@id='search_form_input_homepage']").sendKeys(Keyword);
      //  $("#search_button_homepage").click();

        $("#searchInput").sendKeys(Keyword);
        $("//button[@type='submit']").click();


    }

}
