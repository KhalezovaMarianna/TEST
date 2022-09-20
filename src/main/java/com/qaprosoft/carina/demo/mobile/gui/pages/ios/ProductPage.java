package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    static final Logger LOGGER = LogManager.getLogger(ProductPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"AddPlus Icons\"`]")
    private ExtendedWebElement plusBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    private ExtendedWebElement image;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement basketBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Add To Cart\"`]")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement popUpOkBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarSelected Icons\"`][1]")
    private ExtendedWebElement firstStar;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarUnSelected Icons\"`][1]")
    private ExtendedWebElement starBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarUnSelected Icons\"`]")
    private ExtendedWebElement finalStarBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private ExtendedWebElement backBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement moreBtn;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"1\"`]")
    private ExtendedWebElement amountProducts;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"SubtractMinus Icons\"`]")
    private ExtendedWebElement minusBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label CONTAINS \"%s\"`]")
    private ExtendedWebElement optionSectionColor;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return addToCartBtn.isElementPresent();
    }


    public void addProduct() {
        plusBtn.click();
        addToCartBtn.click();
    }

    @Override
    public CartPageBase goToCart() {
        basketBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public void deleteSeveralProducts(int count) {
        for (int i = 1; i < count; i++) {

            minusBtn.click();

        }
    }

    public void addSeveralProducts(int count) {
        for (int i = 1; i < count + 1; i++) {

            plusBtn.click();

        }
    }

    @Override
    public boolean checkChosenColor(String color) {
        optionSectionColor.format(color).click();
        if (Integer.parseInt(optionSectionColor.format(color).getAttribute("value")) == 1) {
            return true;
        } else {
            return false;
        }
    }


    public void addToCart() {

        addToCartBtn.click();
    }


    @Override
    public MorePageBase openMorePage() {
        moreBtn.click();
        return initPage(getDriver(), MorePageBase.class);
    }

    @Override
    public boolean rateProduct() {
        firstStar.click();
        popUpOkBtn.clickIfPresent();
        for (int i = 1; i <= 4; i++) {
            if (starBtn.isElementPresent()) {
                starBtn.click();
                popUpOkBtn.clickIfPresent();
            } else {
                finalStarBtn.click();
                popUpOkBtn.clickIfPresent();
                break;
            }

        }
        backBtn.click();
        return true;

    }


    @Override
    public boolean checkImageDownloading() {
        int centerx = 173;
        int centerY = 356;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage image = null;
        try {
            image = ImageIO.read(scrFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int clr = image.getRGB(centerx, centerY);
        int red = clr & 0x00ff0000;
        int green = clr & 0x0000ff00;
        int blue = clr & 0x000000ff;
        if (red > 0 && green > 8 && blue > 0) {
            LOGGER.info("Red Color value = " + red);
            LOGGER.info("Green Color value = " + green);
            LOGGER.info("Blue Color value = " + blue);
            return true;
        } else {
            LOGGER.info("Image isn't download");
            return false;
        }
    }
}
