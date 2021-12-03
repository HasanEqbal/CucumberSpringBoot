package com.cucumberspringboot.preference.stepDefinitions;

import com.cucumberspringboot.preference.data.Border;
import com.cucumberspringboot.preference.data.Font;
import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class PreferenceStepDefinition {
    @Autowired
    private Font font;
    @Autowired
    private Border border;

    @Given("User at preference selection page")
    public void user_at_preference_selection_page() {
        log.info("Default values are :");
        log.info(font);
        log.info(border);
    }
}

