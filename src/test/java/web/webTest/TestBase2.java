package web.webTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web.pages.todoist.*;
import web.singletonSession.Session;

public class TestBase2 {

    //TODOIST

    protected MainTodoistPage mainTodoistPage = new MainTodoistPage();
    protected LoginPage loginPage = new LoginPage();

    protected AddProjectPopUp addProjectPopUp = new AddProjectPopUp();

    protected LateralProjectSection lateralProjectSection = new LateralProjectSection();

    protected CentralProjectSection centralProjectSection = new CentralProjectSection();

    protected EditProjectPopUp editProjectPopUp = new EditProjectPopUp();


    @BeforeEach
    public void openBroswer() {
        Session.getSession().goTo("https://todoist.com/");
    }

    @AfterEach
    public void closeBroswer() {

        Session.getSession().closeBrowser();

    }

}
