package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome=true
//,stepNotifications = true
,dryRun = false
,features="src\\test\\resources\\Feature"
,glue={"com.StepDefinition"}
//,snippets = SnippetType.CAMELCASE
)
public class TestRunner {

}
