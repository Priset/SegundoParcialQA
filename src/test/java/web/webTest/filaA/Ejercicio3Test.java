package web.webTest.filaA;

import org.junit.jupiter.api.Test;
import web.webTest.TestBase;

import java.util.Date;
import java.util.Random;

public class Ejercicio3Test extends TestBase {

    String nameProject = "UPA QA Testing " + new Date().getTime();
    private static Random rand = new Random();

    @Test
    public void verifyEjercicio3Test() {
        mainPage.signUpButton.click();

    }
}
