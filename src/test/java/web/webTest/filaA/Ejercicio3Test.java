package web.webTest.filaA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web.webTest.TestBase;

import java.util.Date;
import java.util.Random;

public class Ejercicio3Test extends TestBase {

    String nameProject = "UPA QA Testing " + new Date().getTime();
    private static Random rand = new Random();

    @Test
    public void verifyEjercicio3Test() throws InterruptedException {
        mainPage.signUpButton.click();
        signUpPage.fullNameTextBox.setText("GhostQA"+rand.nextInt(10000));
        signUpPage.emailTextBox.setText("ghost"+rand.nextInt(10000)+"@gmail.com");
        signUpPage.passwordTextBox.setText("ghost753159");
        signUpPage.acceptTermsButton.click();
        signUpPage.signUpButton.click();
        Assertions.assertTrue(centralSection.openSettingsButton.isControlDisplayed(), "ERROR! El Usuario no se creo correctamente");
        projectSection.addProjectButton.click();
        projectSection.projectNameTextBox.setText(nameProject);
        projectSection.projectNameButton.click();
        Assertions.assertTrue(projectSection.addNameToProjectLabel(nameProject).isControlDisplayed(), "ERROR! El Proyecto no se creo correctamente");
        Thread.sleep(3000);

    }
}
