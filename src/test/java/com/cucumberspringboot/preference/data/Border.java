package com.cucumberspringboot.preference.data;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Data
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class Border {
    private String style = "dotted";
    private String color = "gray";
    private String width = "default";
}

