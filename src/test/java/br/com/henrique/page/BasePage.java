package br.com.henrique.page;

import br.com.henrique.interaction.Interaction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class BasePage {

    private final Interaction interaction;

    public BasePage(AppiumDriver<MobileElement> appiumDriver) {
        this.interaction = new Interaction(appiumDriver);
    }

    protected Interaction getInteraction() {
        return interaction;
    }

    public void back() {
        interaction.back();
    }
}
