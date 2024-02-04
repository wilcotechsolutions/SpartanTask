package com.spartans.pages;

import com.spartans.utilities.BrowserUtility;
import com.spartans.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SpartanCrudOperationPage extends BasePage {

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

    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> genderDataOnTheColumn;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> idDataOnTheColumn;

    public void clickOnTheButton(String buttonName) {
        WebElement button = switch (buttonName) {
            case "Search" -> searchButton;
            case "Clear" -> clearButton;
            case "Add Spartan" -> addSpartanButton;
            default -> null;
        };
        BrowserUtility.clickOn(button);
    }

    public void clickOnTheButtonForTheFirstSpartanAfterSearch(String buttonName, String spartanName) {
        String id = getIdOfTheSpartan(spartanName);
        WebElement button = switch (buttonName) {
            case "View" -> Driver.get().findElement(By.id("view_spartan_" + id));
            case "Edit" -> Driver.get().findElement(By.id("edit_spartan_" + id));
            case "Delete" -> Driver.get().findElement(By.id("delete_spartan_" + id));
            default -> null;
        };
        BrowserUtility.clickOn(button);
    }

    private String getIdOfTheSpartan(String spartanName) {
        int index = 0;
        for (WebElement each : nameDataOnTheColumn) {
            if(each.getText().equals(spartanName)){
                index = nameDataOnTheColumn.indexOf(each);
                break;
            }
        }
        return idDataOnTheColumn.get(index).getAttribute("innerText");
    }

    public void enterDataToTheInputBox(String data, String inputBoxName) throws InterruptedException {
        Thread.sleep(1000);
        WebElement inputBox = switch (inputBoxName) {
            case "Name Search Text Box" -> nameSearchBox;
            default -> null;
        };
        BrowserUtility.enterData(inputBox, data);
    }

    public String getData(String title) {
        if (title.equals("0")) return "0";
        String data = "";
        if (title.equals("Total Result")) {
            wait.until(ExpectedConditions.visibilityOf(totalResult));
            data = totalResult.getText().substring(2);
        } else if (title.equals("Total")) {
            wait.until(ExpectedConditions.visibilityOf(total));
            data = total.getText().substring(7);
        }
        return data;
    }

    public List<String> getColumnData(String columnName) {
        List<WebElement> columnDataList = switch (columnName) {
            case "Name" -> nameDataOnTheColumn;
            case "Phone" -> phoneDataOnTheColumn;
            case "Gender" -> genderDataOnTheColumn;
            default -> null;
        };
        return columnDataList.stream()
                .map(WebElement::getText)
                .filter(each -> !each.isEmpty())
                .toList();
    }

}
