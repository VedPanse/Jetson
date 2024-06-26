package com.example.seleniumautomation;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  public SelenideElement searchInput = $("[name='q']");
  public SelenideElement searchButton = $x("(//input[@name='btnK'])[2]");

  public static void openPage(String url) {
    open(url);
  }

  public void search(String query) {
    this.searchButton.click();
    this.searchInput.sendKeys("Selenium");
    this.searchInput.pressEnter();
  }
}
