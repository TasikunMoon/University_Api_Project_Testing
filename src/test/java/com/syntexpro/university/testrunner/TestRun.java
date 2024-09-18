package com.syntexpro.university.testrunner;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.core.Config;
import com.linecorp.armeria.internal.shaded.reflections.vfs.Vfs;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRun {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:com/syntexpro/university/features/POST")
                .outputCucumberJson(true)
                .parallel(0);
        generateReport(results.getReportDir());
    }
    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "Your project name here");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }




    }






