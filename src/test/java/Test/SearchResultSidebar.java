package Test;

import net.serenitybdd.core.pages.PageComponent;

public class SearchResultSidebar  extends PageComponent {

    public String heading(){


        return $("#firstHeading").getText();
    }

}
