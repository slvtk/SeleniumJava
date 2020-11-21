package helpers;

import manager.ApplicationManager;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openIndexPage() {
        driver.navigate().to(baseUrl);
    }

/*    public void openDraftsPage() {
        driver.navigate().to(baseUrl);
    }*/
}
