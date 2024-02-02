package com.blue.pages;

import com.blue.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.blue.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SpartanCrudOperationPage extends BasePage{

    @FindBy(id = "search")
    public WebElement searchButton;

    @FindBy(id = "clear")
    public WebElement clearButton;

    @FindBy(id = "add_spartan_btn")
    public WebElement addSpartanButton;

    @FindBy(id = "name")
    public WebElement nameSearchBox;

    @FindBy(id = "total")
    public WebElement total;

    @FindBy(id = "total_up_count")
    public WebElement totalResult;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameDataOnTheColumn;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> phoneDataOnTheColumn;

    public void clickOnTheButton(String buttonName) {
        WebElement button = switch (buttonName) {
            case "Search" -> searchButton;
            case "Clear" -> clearButton;
            case "Add Spartan" -> addSpartanButton;
            default -> null;
        };
        BrowserUtils.clickOn(button);
    }

    public void clickOnTheButtonForTheSpartanId(String buttonName, String spartanId) {
        WebElement button = switch (buttonName) {
            case "View" -> Driver.get().findElement(By.id("view_spartan_" + spartanId));
            case "Edit" -> Driver.get().findElement(By.id("edit_spartan_" + spartanId));
            case "Delete" -> Driver.get().findElement(By.id("delete_spartan_" + spartanId));
            default -> null;
        };
        BrowserUtils.clickOn(button);
    }

    public void enterDataToTheInputBox(String data, String inputBoxName) throws InterruptedException {
        Thread.sleep(1000);
        WebElement inputBox = switch (inputBoxName) {
            case "Name Search Text Box" -> nameSearchBox;
            default -> null;
        };
        BrowserUtils.enterData(inputBox, data);
    }

    public String getData(String title){
        if(title.equals("0")) return "0";
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
        List<WebElement> columnDataList = switch (columnName) {
            case "Name" -> nameDataOnTheColumn;
            case "Phone" -> phoneDataOnTheColumn;
            default -> null;
        };
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
