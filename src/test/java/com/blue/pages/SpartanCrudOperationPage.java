package com.blue.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.blue.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SpartanCrudOperationPage extends BasePage{

    @FindBy(id = "search")
    public WebElement searchButton;

    @FindBy(id = "clear")
    public WebElement clearButton;

    @FindBy(id = "name")
    public WebElement nameSearchBox;

    @FindBy(id = "total")
    public WebElement total;

    @FindBy(id = "total_up_count")
    public WebElement totalResult;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameDataOnTheColumn;

    public void clickOnTheButton(String buttonName) {
        WebElement button = switch (buttonName) {
            case "Search" -> searchButton;
            case "Clear" -> clearButton;
            default -> null;
        };
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public void clickOnTheButtonForTheSpartanId(String buttonName, String spartanId) {
        WebElement button = null;
        switch (buttonName){
            case "View":
                button = Driver.get().findElement(By.id("view_spartan_" + spartanId));
                break;
            case "Edit":
                button = Driver.get().findElement(By.id("edit_spartan_" + spartanId));
                break;
            case "Delete":
                button = Driver.get().findElement(By.id("delete_spartan_" + spartanId));
                break;
        }
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        button.click();
    }

    public void enterDataToTheTextBox(String data, String textBoxName) throws InterruptedException {
        Thread.sleep(1000);
        WebElement textBox = null;
        if(textBoxName.equals("Name Search Text Box")){
            textBox = nameSearchBox;
        }
        wait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.sendKeys(data);
    }

    public String getData(String title){
        String data = "";
        wait.until(ExpectedConditions.visibilityOf(totalResult));
        wait.until(ExpectedConditions.visibilityOf(total));
        if(title.equals("Total Result")){
            data = totalResult.getText().substring(2);
        }else if(title.equals("Total")){
            data = total.getText().substring(7);
        }
        return data;
    }

    public List<String> getColumnData(String columnName){
        List<WebElement> columnDataList = new ArrayList<>();
        if(columnName.equals("Name")){
            columnDataList = nameDataOnTheColumn;
        }
        return columnDataList.stream()
                .map(WebElement::getText)
                .filter(each -> !each.isEmpty())
                .toList();
    }

//    public void clickOnTheButtonaaaaaa(String buttonName) {
//        Driver.get().findElement(By.xpath("//tbody//tr//td//a[@id=\"view_spartan_"+ spartanID +"\"]")).click();
//    }

    public void addSpartan(String name, String Gender, Long phone) {

    }

}
