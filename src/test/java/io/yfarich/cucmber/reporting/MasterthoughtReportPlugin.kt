package io.yfarich.cucmber.reporting

import cucumber.api.Plugin
import cucumber.api.event.EventListener
import cucumber.api.event.EventPublisher
import cucumber.api.event.TestRunFinished
import cucumber.runtime.formatter.PluginFactory
import net.masterthought.cucumber.Configuration
import net.masterthought.cucumber.ReportBuilder
import java.io.File
import java.util.*

class MasterthoughtReportPlugin(private val outputDir: File = File("target/cucumber")) : Plugin, EventListener {

    private val temporaryJsonReport: String = "${outputDir.absolutePath}/json/temp_report_${Date().time}.json"
    private val jsonReportEventListener: EventListener
    private val htmlReportConfiguration: Configuration

    init {
        jsonReportEventListener = PluginFactory().create("json:$temporaryJsonReport") as EventListener
        htmlReportConfiguration = Configuration(outputDir, "testCucumber")
        setup()
    }

    private fun setup() {
        File(temporaryJsonReport).deleteOnExit()
        htmlReportConfiguration.buildNumber = "pre-${Date().time}"
    }

    override fun setEventPublisher(publisher: EventPublisher) {
        jsonReportEventListener.setEventPublisher(publisher)
        publisher.registerHandlerFor(TestRunFinished::class.java) { this.generateMasterthoughtReport(it) }
    }

    private fun generateMasterthoughtReport(event: TestRunFinished) {
        ReportBuilder(listOf(temporaryJsonReport), htmlReportConfiguration).generateReports()
    }
}
