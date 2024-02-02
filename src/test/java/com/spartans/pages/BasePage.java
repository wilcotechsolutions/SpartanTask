package com.spartans.pages;

import org.openqa.selenium.support.PageFactory;
import com.spartans.utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public BasePage(){ PageFactory.initElements(Driver.get(),this);}

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(12));

}
