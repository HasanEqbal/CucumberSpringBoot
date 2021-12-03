package com.cucumberspringboot.preference.stepDefinitions;

import com.cucumberspringboot.preference.data.Border;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BorderStepDefinition {
    @Autowired
    private Border border;

    @When("User selects border details")
    public void user_selects_below_border_details(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            border.setStyle(columns.get(0));
            border.setColor(columns.get(1));
            border.setWidth(columns.get(2));
        }
    }
}
