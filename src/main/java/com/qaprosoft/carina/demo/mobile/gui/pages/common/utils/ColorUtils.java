package com.qaprosoft.carina.demo.mobile.gui.pages.common.utils;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorUtils  {
    static final Logger LOGGER = LogManager.getLogger(ColorUtils.class);




    public static boolean colorOptions(WebDriver driver, ExtendedWebElement element) {

        int centerx = (element.getSize().height - element.getLocation().x) / 2;
        int centerY = (element.getSize().width - element.getLocation().y) / 2;

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
        if (red > 0 && green > 0 && blue > 0) {
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

