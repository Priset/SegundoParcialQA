package web.pages.todoLy;

import org.openqa.selenium.By;
import web.controls.TextBox;

public class SignUpPage {
    public TextBox fullNameTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTextBox = new TextBox(By.id(""));
}
