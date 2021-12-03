package com.cucumberspringboot.preference;

import com.cucumberspringboot.preference.data.Border;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Configuration
@ComponentScan("com.cucumberspringboot.preference")
public class Config {

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public Border getBorder() {
        return new Border();
    }
}
