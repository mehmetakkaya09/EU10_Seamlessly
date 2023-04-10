package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{


    @FindBy(xpath = "//button[@id='new-contact-button']")
    public WebElement newContactButton;

    @FindBy(xpath = "//section[@class='contact-details']")
    public WebElement form;

    @FindBy(xpath = "//input[@id='contact-org']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@id='contact-title']")
    public WebElement inputLastName;

    @FindBy(xpath = "//div[@class='app-content-list']/div")
    public WebElement listOfContacts;





    }

