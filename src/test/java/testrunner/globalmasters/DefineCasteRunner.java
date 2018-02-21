package testrunner.globalmasters;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"src/test/featurefiles/globalmasters"}
        ,glue= {"stepdefinitions"}
      /* ,monochrome=true
        ,plugin= {"html:target/cucumber_html_report",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"} */
)

public class DefineCasteRunner {
}
