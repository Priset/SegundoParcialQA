package web.pages.todoLy;

import org.openqa.selenium.By;
import web.controls.Button;
import web.controls.TextBox;

public class SignUpPage {
    public TextBox fullNameTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox passwordTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Button acceptTermsButton = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signUpButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
}
