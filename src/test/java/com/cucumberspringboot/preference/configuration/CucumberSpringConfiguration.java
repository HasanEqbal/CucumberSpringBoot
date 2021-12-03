package com.cucumberspringboot.preference.configuration;

import com.cucumberspringboot.preference.Config;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Config.class)
public class CucumberSpringConfiguration {
}
