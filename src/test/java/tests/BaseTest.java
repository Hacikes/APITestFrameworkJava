package tests;

import com.tmb.reports.ExtenLogger;
import com.tmb.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {
    // Аннотация, которая выполняется перед каждым сьютом
    @BeforeSuite
    public void setUpSuite(){
        // Создаём объект отчёта
        ExtentReport.initReports();
    }
    // Аннотация, которая выполняется после каждым сьютом
    @AfterSuite
    public void tearDownSuite(){
        ExtentReport.tearDownReports();

    }

    // Действия, которые будут выполняться до каждого теста
    @BeforeMethod
    public void setUp(Method m){
        // Первый тест, берущийся из класса ExtentReport
        ExtentReport.createTest(m.getName());
    }

    // Действия, которые будут выполняться после каждого теста
    @AfterMethod
    // Логирует статус теста
    public void tearDown(ITestResult result){
        if (!result.isSuccess()){
            ExtenLogger.fail(String.valueOf(result.getThrowable()));
        }

    }
}
