package com.blue.pages;

import org.openqa.selenium.support.PageFactory;
import com.blue.utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public BasePage(){ PageFactory.initElements(Driver.get(),this);}

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(12));

}
