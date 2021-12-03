package com.cucumberspringboot.preference.data;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Data
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class Font {
    private String style = "arial";
    private String color = "black";
    private String weight = "normal";
}


