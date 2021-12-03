package com.cucumberspringboot.preference.stepDefinitions;

import com.cucumberspringboot.preference.data.Font;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FontStepDefinition {
    @Autowired
    private Font font;

    @When("User selects font details")
    public void user_selects_below_font_details(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            font.setStyle(columns.get(0));
            font.setColor(columns.get(1));
            font.setWeight(columns.get(2));
        }
    }
}
