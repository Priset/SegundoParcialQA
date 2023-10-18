package web.webTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web.pages.todoLy.*;
import web.singletonSession.Session;

public class TestBase {

    //TODOLY

    protected MainPage mainPage = new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();

    protected ProjectSection projectSection = new ProjectSection();

    protected CentralSection centralSection = new CentralSection();

    protected SettingsSection settingsSection = new SettingsSection();

    @BeforeEach
    public void openBroswer() {
        Session.getSession().goTo("https://todo.ly/");
    }

    @AfterEach
    public void closeBroswer() {

        Session.getSession().closeBrowser();

    }

}
