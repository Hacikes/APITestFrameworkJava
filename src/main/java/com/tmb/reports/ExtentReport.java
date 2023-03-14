package com.tmb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    // Отвечает за формирование отчёта
    private ExtentReport(){}
    private static ExtentReports extent;
    private static ExtentTest test; // Не безопасна при запуске нескольких потоков



    public static void initReports(){
        // После изменения теста необходимо сделать ReloadFromDisk нажав правую кнопку по названию проекта,
        // для обновления отчёта
        // Дока по Extern Report https://www.extentreports.com/docs/versions/5/java/index.html
        // Создаём объект для отчёта
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);
    }

    public static void tearDownReports(){
        extent.flush();
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
        ExtentManager.setExtent(test);
    }
}
