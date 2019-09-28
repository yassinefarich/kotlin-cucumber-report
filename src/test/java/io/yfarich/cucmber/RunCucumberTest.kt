package io.yfarich.cucmber

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(plugin = ["pretty",
    "json:reports/cucumber-reports/Cucumber.json",
    "io.yfarich.cucmber.reporting.MasterthoughtReportPlugin:reports/cucumber-reports/html"
], features = ["src/test/resources/features"])
class RunCucumberTest